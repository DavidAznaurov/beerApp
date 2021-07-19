package com.hcl.beer.web.service;

import java.util.UUID;

import com.hcl.beer.web.model.CustomerDto;


public interface CustomerService {

	CustomerDto getCustomerById(UUID customerId);

	void deleteCustomerById(UUID customerId);

	void updateCustomer(CustomerDto customerDto);

	CustomerDto saveNewCustomer(CustomerDto customerDto);
}
