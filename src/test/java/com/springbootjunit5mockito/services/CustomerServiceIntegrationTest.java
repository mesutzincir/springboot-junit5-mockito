package com.springbootjunit5mockito.services;

import com.springbootjunit5mockito.models.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest // load application context
public class CustomerServiceIntegrationTest {
    @Autowired
    private CustomerService _service;
    @Test
    public  void getAll()
    {
        List<Customer> listCustomer= _service.getAll();
        Assertions.assertEquals(3, listCustomer.size());
    }

    @Test
    public  void getCustomer()
    {
        Customer actual =_service.getCustomer(1);
        Assertions.assertEquals(1, actual.getId());
        Assertions.assertEquals("mesut", actual.getName());
        Assertions.assertEquals("zincir", actual.getSurname());
    }

}