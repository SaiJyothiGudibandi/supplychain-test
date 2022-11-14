package com.javainuse.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.javainuse.controllers.HelloService;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

//https://docs.spring.io/spring-boot/docs/2.1.2.RELEASE/reference/htmlsingle/#boot-features-testing-spring-boot-applications
@SpringBootTest
public class HelloServiceTest {

    @Autowired
    HelloService helloService;

    @DisplayName("Test Spring @Autowired Integration")
    @Test
    void testGet() {
        assertEquals("Hello JUnit ", helloService.get());
    }

    @Test
    void testRepo() {
    	assertNotEquals("Hello wrong code", helloService.get());
    }

}
