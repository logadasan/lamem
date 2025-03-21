package com.events.laMem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.events.laMem.model.Customer;
import com.events.laMem.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Optional<Customer> getCustomerById(Long id) {
		return customerRepository.findById(id);
	}

	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}
}
