package com.everis.moneda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.everis.moneda.entity.Coin;
import com.everis.moneda.exception.EntityNotFoundException;
import com.everis.moneda.repository.InterfaceCoinRepository;
import com.everis.moneda.repository.InterfaceRepository;
import com.everis.moneda.service.InterfaceCoinService;

import reactor.core.publisher.Mono;
/*
 * Clase que extiende la clase abstracta (CRUD Service Impl) y hereda los métodos del InterfaceCustomerService
 * */
@Service
public class CoinServiceImpl extends CRUDServiceImpl<Coin, String> implements InterfaceCoinService{
	//@Value("${msg.error.registro.notfound}")
	//private String msgNotFound;
	private String msgNotFound = "no se encontro el registro";
	
	@Autowired
	private InterfaceCoinRepository repository;
	 
	@Autowired
	private InterfaceCoinService service;
	  
	
	@Override
	protected InterfaceRepository<Coin, String> getRepository() {
	  return repository;
	}

	@Override
	public Mono<Coin> findbyIdentityNumber(String identityNumber) {
		// TODO Auto-generated method stub
		return repository.findByIdentityNumber(identityNumber)
				.switchIfEmpty(Mono.error( new EntityNotFoundException(msgNotFound)));
	}
	
	
	@Override
	public Mono<Coin> create(Coin coin) {
		// TODO Auto-generated method stub
		return repository.insert(coin);
	}
	
	
	@Override
	public Mono<Coin> update(Coin coin, String indentityNumber) {
		// TODO Auto-generated method stub
		return repository.findById(coin.getId())
				.switchIfEmpty(Mono.error( new EntityNotFoundException(msgNotFound) ))
				 .flatMap(item-> repository.save(coin));
	}
	
	
	@Override
	public Mono<Void> delete(String indentityNumber) {
		// TODO Auto-generated method stub
		return  repository.deleteById(indentityNumber);
	}

}
