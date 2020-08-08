package com.springbootjunit5mockito.controllers;


import com.springbootjunit5mockito.models.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
        // loads complete application  and injects all the beans. it'll start your full application context and not customize component scanning at all.
class CustomerControllerIntegrationTest {
    @Autowired
    CustomerController _controller;
    @Test
    void getAll() {

        List<Customer> actual= _controller.getAll();
        Assertions.assertEquals(3,actual.size());
    }

    @Test
    void get() {

        Customer actual=_controller.get(1);
        Assertions.assertEquals( 1, actual.getId());
        Assertions.assertEquals( "mesut", actual.getName());
    }
}