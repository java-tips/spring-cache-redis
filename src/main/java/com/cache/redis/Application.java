package com.cache.redis;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableCaching
@EnableAutoConfiguration
@EnableTransactionManagement
public class Application implements CommandLineRunner {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	private final CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	public Application(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public void run(String... strings) {
		// Populating embedded database here
		LOG.info("Saving Customers. Current count is {}.", customerRepository.count());
		Customer ols = new Customer("Oneide Luiz", new Random().nextLong());
		Customer l = new Customer("Luiz", new Random().nextLong());
		Customer m = new Customer("Mario", new Random().nextLong());

		customerRepository.save(ols);
		customerRepository.save(l);
		customerRepository.save(m);
		LOG.info("Now Current count is {}.", customerRepository.count());
		LOG.info("Done saving Customers. Data: {}.", customerRepository.findAll());
	}

}