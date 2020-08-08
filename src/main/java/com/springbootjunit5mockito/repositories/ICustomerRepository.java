package com.springbootjunit5mockito.repositories;

import com.springbootjunit5mockito.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
}