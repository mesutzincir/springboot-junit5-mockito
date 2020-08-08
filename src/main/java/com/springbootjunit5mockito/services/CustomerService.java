package com.springbootjunit5mockito.services;

import com.springbootjunit5mockito.models.Customer;
import com.springbootjunit5mockito.repositories.ICustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private ICustomerRepository _reRepository;

    public CustomerService(ICustomerRepository repository) {
        _reRepository = repository;
    }

    public List<Customer> getAll() {
        List<Customer> listCustomer = _reRepository.findAll();
        System.out.println("size of listCustomer = " + listCustomer.size());
        return listCustomer;
    }

    public Customer getCustomer(int id) {
        Optional<Customer> optCustomer=_reRepository.findById(id);
        return optCustomer.get();
    }
}
