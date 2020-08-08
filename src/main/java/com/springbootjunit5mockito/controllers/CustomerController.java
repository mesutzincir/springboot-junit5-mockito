package com.springbootjunit5mockito.controllers;

import com.springbootjunit5mockito.models.Customer;
import com.springbootjunit5mockito.services.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService _service;

    public CustomerController(CustomerService service) {
        _service = service;
    }

    @GetMapping("/customer/all")
    public List<Customer> getAll() {
        return _service.getAll();
    }
    @GetMapping("/customer/get/{id}")
    public Customer get(@PathVariable int id) {
        return _service.getCustomer(id);
    }
}
