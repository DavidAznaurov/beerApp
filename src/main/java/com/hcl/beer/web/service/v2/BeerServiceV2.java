package com.hcl.beer.web.service.v2;

import java.util.UUID;

import com.hcl.beer.web.model.v2.BeerDtoV2;

public interface BeerServiceV2 {

	BeerDtoV2 getBeerById(UUID beerId);

	BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto);

	void deleteById(UUID beerId);

	void updateBeer(UUID beerId, BeerDtoV2 beerDto);

}
