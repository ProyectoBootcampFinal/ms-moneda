package com.everis.moneda.service;

import com.everis.moneda.entity.Coin;

import reactor.core.publisher.Mono;

/**
 * Interface del Service con metodos externos al crud.
 * Interface hereda del InterfaceCRUD
 */

public interface InterfaceCoinService extends InterfaceCRUDService<Coin, String> {

	Mono<Coin> findbyIdentityNumber(String identityNumber);
	
	Mono<Coin> create(Coin coin);
	  
	Mono<Coin> update(Coin coin, String indentityNumber);
	  
	Mono<Void> delete(String indentityNumber);
}
