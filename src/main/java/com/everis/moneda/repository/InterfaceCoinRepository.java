package com.everis.moneda.repository;


import com.everis.moneda.entity.Coin;

import reactor.core.publisher.Mono;

/*
 * Interface que hereda del InterfaceRepository
 * */
public interface InterfaceCoinRepository extends InterfaceRepository<Coin, String>{

	Mono<Coin> findByIdentityNumber(String identityNumber);
}
