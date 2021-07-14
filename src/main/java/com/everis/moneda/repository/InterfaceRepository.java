package com.everis.moneda.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.everis.moneda.entity.Coin;
import reactor.core.publisher.Mono;

/*
 * Interface que llama al Repositorio Reactivo de Mongo
 * */
@NoRepositoryBean
public interface InterfaceRepository<T, K> extends ReactiveMongoRepository<T, K>{

	Mono<Coin> findByIdentityNumber(String identityNumber);
}
