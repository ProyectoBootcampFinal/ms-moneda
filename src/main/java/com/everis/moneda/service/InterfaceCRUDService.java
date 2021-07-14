package com.everis.moneda.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//T = Table, K = Key
//Interface Padre
public interface InterfaceCRUDService<T, K> {

	Mono<T> create(T moneda);
	
	Flux<T> findAll();
	
	Mono<T> findById(K id);
	
	Mono<T> update(T moneda);
	
	Mono<Void> delete(K id);
}
