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

import java.util.Arrays;
import java.util.List;


//this is a unit test not integration test, so no need spring boot properties or application context.
@ExtendWith(MockitoExtension.class) //activate Mockito
class CustomerServiceTest {
    @Mock
    private ICustomerRepository _repository; //mock the ICustomerRepository
    @InjectMocks
    private CustomerService _service; //inject the mock of ICustomerRepository
    @Test
    void getAll() {
        Mockito.when(_repository.findAll()).thenReturn(Arrays.asList(new Customer(1,"mesut","zincir"),
                new Customer(2,"nihat","y")));
        List<Customer> listCustomer= _service.getAll();
        Assertions.assertEquals(2, listCustomer.size());
    }

    @Test
    void getCustomer() {
    }
}