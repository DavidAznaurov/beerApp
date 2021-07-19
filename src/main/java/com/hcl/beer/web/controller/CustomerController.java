package com.hcl.beer.web.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.beer.web.model.CustomerDto;
import com.hcl.beer.web.service.CustomerService;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
	
	@Autowired
	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping({"/{customerId}"})
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {
		return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity handlePost(@RequestBody CustomerDto customerDto) {
		CustomerDto saveDto = customerService.saveNewCustomer(customerDto);
		HttpHeaders headers = new HttpHeaders();
		//todo add complete url http://localhost:8081
		headers.add("Location", "/api/v1/customer/" + saveDto.getId().toString());
		return new ResponseEntity(headers,HttpStatus.CREATED);
	}
	@PutMapping({"/{customerId}"})
	public ResponseEntity handleUpdate(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto) {
		customerService.updateCustomer(customerDto);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping({"/{customerId}"})
	public void handleDelete(@PathVariable("customerId") UUID customerId) {
		customerService.deleteCustomerById(customerId);
	}
	
}
