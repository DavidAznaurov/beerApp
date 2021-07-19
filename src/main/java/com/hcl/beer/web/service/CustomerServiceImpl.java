package com.hcl.beer.web.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.hcl.beer.web.model.CustomerDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto getCustomerById(UUID customerId) {
		return CustomerDto.builder().id(UUID.randomUUID())
						  .name("David")
						  .build();
	}

	@Override
	public void deleteCustomerById(UUID customerId) {
		log.debug("Deleting a beer...");
		
	}

	@Override
	public void updateCustomer(CustomerDto customerDto) {
		//todo impl - would add a real impl  to update customer
		
	}

	@Override
	public CustomerDto saveNewCustomer(CustomerDto customerDto) {
		return CustomerDto.builder().id(UUID.randomUUID()).build();
	}

	
	
}
