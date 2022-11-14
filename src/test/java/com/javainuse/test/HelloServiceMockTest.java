package com.javainuse.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.javainuse.controllers.HelloRepository;
import com.javainuse.controllers.HelloService;
import com.javainuse.controllers.HelloServiceImpl;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class) , need this? still able to run.
@SpringBootTest
public class HelloServiceMockTest {

    @Mock
    private HelloRepository helloRepository;

    //@Spy
    @InjectMocks // auto inject helloRepository
    private HelloService helloService = new HelloServiceImpl();

    @BeforeEach
    void setMockOutput() {
        when(helloRepository.get()).thenReturn("Hello Mockito From Responsitory");
    }

    @DisplayName("Test Mock helloService + helloRepository")
    @Test
    void testGet() {
        assertEquals("Hello Mockito From Responsitory", helloService.get());
    }
    
    @Test
    void testTrue() {
    	assertTrue(true);
    }

}
