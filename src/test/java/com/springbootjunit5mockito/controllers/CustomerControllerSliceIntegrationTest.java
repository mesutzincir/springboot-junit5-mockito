package com.springbootjunit5mockito.controllers;

import com.springbootjunit5mockito.models.Customer;
import com.springbootjunit5mockito.repositories.ICustomerRepository;
import com.springbootjunit5mockito.services.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


//@ExtendWith(MockitoExtension.class) //activate Mockito
//@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@WebMvcTest
@ContextConfiguration(classes = {CustomerController.class, CustomerService.class})
class CustomerControllerSliceIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    //@MockBean automatically replaces the bean of the same type in the application context with a Mockito mock.
    @MockBean // not @Mock. we try to inject ICustomerRepository instance for @WebMvcTest
            ICustomerRepository _repository;

    @Autowired
    CustomerController _controller;

    @Test
    void getAll_by_using_Autowired() throws Exception {
        List<Customer> expected = Arrays.asList(new Customer(1, "mesut", "zincir"),
                new Customer(2, "nihat", "y"));
        Mockito.when(_repository.findAll()).thenReturn(expected);
        List<Customer> actual = _controller.getAll();
        Assertions.assertEquals(2, actual.size());
    }

    @Test
    void getAll_by_using_mockMvc() throws Exception {
        List<Customer> expected = Arrays.asList(new Customer(1, "mesut", "zincir"),
                new Customer(2, "nihat", "y"));
        Mockito.when(_repository.findAll()).thenReturn(expected);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/customer/all")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print()) // print the response context on screen
                .andExpect(MockMvcResultMatchers.jsonPath("$.*").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", org.hamcrest.Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", org.hamcrest.Matchers.is("mesut")))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    void get_customer() throws Exception {

        Customer expected = new Customer(1, "mesut", "zincir");

        Mockito.when(_repository.findById(expected.getId())).thenReturn(Optional.of(expected));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/customer/get/"+expected.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print()) // print the response context on screen
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", org.hamcrest.Matchers.is(expected.getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", org.hamcrest.Matchers.is(expected.getName())))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }
}
