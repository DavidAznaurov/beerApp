package com.hcl.beer.web.service.v2;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.hcl.beer.web.model.v2.BeerDtoEnum;
import com.hcl.beer.web.model.v2.BeerDtoV2;

@Service
public class BeerServiceImplV2 implements BeerServiceV2{

	@Override
	public BeerDtoV2 getBeerById(UUID beerId) {
		return BeerDtoV2.builder().id(UUID.randomUUID())
				  .beerName("Galaxy Cat")
				  .beerStyle(BeerDtoEnum.LAGER)
				  .build();
	}

	@Override
	public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(UUID beerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
		// TODO Auto-generated method stub
		
	}

}
