from securesystemslib import interface
from in_toto.models.layout import Layout, Step, Inspection
from in_toto.models.metadata import Metablock


def main():
    # Load Alice's private key to later sign the layout
    priv_key_alice = interface.import_rsa_privatekey_from_file("resources/keys/alice")

    # Load public keys
    pub_key_alice = interface.import_rsa_publickey_from_file("resources/keys/alice.pub")


    layout = Layout.read({
        "_type":
        "layout",
        "keys": {
            pub_key_alice["keyid"]: pub_key_alice,
        },
        "steps": [{
            "name": "clone",
            "expected_products": [["CREATE", "src/*"]],
            "pubkeys": [pub_key_alice["keyid"]],
            "threshold": 1,
        },{
            "name": "code-build",
            "pubkeys": [pub_key_alice["keyid"]],
            "expected_command": ['mvn', 'clean', 'install', '-DskipTests'],
            "expected_materials": [["MATCH", "src/*", "WITH", "PRODUCTS","FROM", "clone"],["DISALLOW", "*"]],
            "expected_products": [
              ["CREATE", "target/SpringBootHelloWorld-0.0.1.jar"], 
              ["CREATE", "target/*"],
              ["DISALLOW", "*"],
             ],
            "threshold": 1,
        }
        ],
        "inspect": [
            {
              "name": "docker-build",
              "expected_materials": [
                  ["MATCH", "target/SpringBootHelloWorld-0.0.1-SNAPSHOT.jar", "WITH", "PRODUCTS", "FROM", "code-build"],
              ],
              "expected_products": [
                  ["MATCH", "./SpringBootHelloWorld-0.0.1-SNAPSHOT.jar", "WITH", "PRODUCTS", "FROM", "code-build"]
              ],
              "run": [
                  "ls"
#                   "find",
#                   "-type", 
#                   "f", 
#                   "-name", 
#                   "SpringBootHelloWorld-0.0.1-SNAPSHOT.jar"
              ]
            }
        ],
    })

    metadata = Metablock(signed=layout)

    # Sign and dump layout to "root.layout"
    metadata.sign(priv_key_alice)
    metadata.dump("root.layout")
    print('Created in-toto layout as "root.layout".')


if __name__ == '__main__':
    main()
