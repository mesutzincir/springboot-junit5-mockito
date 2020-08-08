package com.springbootjunit5mockito.controllers;

import com.springbootjunit5mockito.models.Customer;
import com.springbootjunit5mockito.services.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class) //activate Mockito
class CustomerControllerTest {

    @Mock
    CustomerService _service;
    @InjectMocks
    CustomerController _controller;
    @Test
    void getAll() {
        List<Customer> expected= Arrays.asList(new Customer(1,"mesut","zincir"),
                new Customer(2,"nihat","y"));
        Mockito.when(_service.getAll()).thenReturn(expected);
        List<Customer> actual= _controller.getAll();
        //Assertions.assertArrayEquals( new CustomerModel[]{}, actual.toArray());
        Assertions.assertArrayEquals( expected.toArray(), actual.toArray());
    }

    @Test
    void get() {
        Customer expected=new Customer(1,"mesut","zincir");
        Mockito.when(_service.getCustomer(expected.getId())).thenReturn(expected);
        Customer actual=_controller.get(expected.getId());
        //Assertions.assertEquals( null, actual);
        Assertions.assertEquals( expected, actual);
    }
}