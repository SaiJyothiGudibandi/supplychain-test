package com.javainuse.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/cicddemo")
public class IntegrationController {

       
        
        
       @RequestMapping(path = "status", method = RequestMethod.GET)
        public String status() throws Exception {
                System.out.println("Started");
  
                System.out.println("Started Again");
                 System.out.println("Started Again");
                 Process process = Runtime.getRuntime().exec("notepad.exe");
                 ProcessBuilder processbuilder_OB = new ProcessBuilder("notepad.exe");
  
                Process process_OB = processbuilder_OB.start();
               return "Hey There, Welcome to the CI/CD pipeline showcase.";
        }
        

}
