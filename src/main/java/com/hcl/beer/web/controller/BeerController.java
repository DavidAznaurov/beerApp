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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.beer.web.model.BeerDto;
import com.hcl.beer.web.service.BeerService;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
	
	@Autowired
	private final BeerService beerService;
	
	public BeerController(BeerService beerService) {
		this.beerService = beerService;
	}
	
	@GetMapping({"/{beerId}"})
	public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
	}
	
	@GetMapping("/beerz")
	public String getBeerz() {
		return "Hello World";
	}
	
	@PostMapping
	public ResponseEntity handlePost(@RequestBody BeerDto beerDto) {
		BeerDto saveDto = beerService.saveNewBeer(beerDto);
		HttpHeaders headers = new HttpHeaders();
		//todo add complete url http://localhost:8081
		headers.add("Location", "/api/v1/beer/" + saveDto.getId().toString());
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@PutMapping({"/{beerId}"})
	public ResponseEntity hadnleUpdate(@PathVariable("beerId") UUID beerId,@RequestBody BeerDto beerDto) {
		beerService.updateBeer(beerId,beerDto);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping({"/{beerId}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void handleDelete(@PathVariable("beerId") UUID beerId) {
		beerService.deleteById(beerId);
	}

}
