package com.hcl.beer.web.service;

import java.util.UUID;

import com.hcl.beer.web.model.BeerDto;


public interface BeerService {

	BeerDto getBeerById(UUID beerId);
	BeerDto saveNewBeer(BeerDto beerDto);
	void updateBeer(UUID beerId, BeerDto beerDto);
	void deleteById(UUID beerId);

}
