package com.springbootjunit5mockito.services;

import com.springbootjunit5mockito.models.Customer;
import com.springbootjunit5mockito.repositories.ICustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
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

}