package com.cache.redis;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

  @Autowired
  private CustomerRepository customerRepository;

  @Cacheable(value = "customers")
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public Iterable<Customer> getCustomers() {
    return customerRepository.findAll();
  }

  @CachePut(value = "customers", key = "#customer.id")
  @PutMapping("/save")
  public Customer save(@RequestBody Customer customer) {
    customerRepository.save(customer);
    return customer;
  }

}