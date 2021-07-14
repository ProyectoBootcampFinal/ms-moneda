package com.everis.moneda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.moneda.entity.Coin;
import com.everis.moneda.service.InterfaceCoinService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
 * Clase Controlador 
 * */
@Slf4j
@RestController
@RequestMapping(path = "/coin")
public class CoinController {

	  @Autowired
	  private InterfaceCoinService service;
	    
	  /** Listado de moneda. */
	  @GetMapping
	  public Flux<Coin> findAll() { 
		  log.info("CoinController.findAll, calling");
		  return service.findAll();
	  }
	  
	  /** Buscar moneda por numero de identidad. */
	  @GetMapping("/{indentityNumber}")
	  public Mono<Coin> findByIdentityNumber(@PathVariable("indentityNumber") String indentityNumber) {
		  log.info("CoinController.findById, id value has -> "+indentityNumber);
		  return service.findbyIdentityNumber(indentityNumber);
	  }
	  
	  /** Crear moneda. */
	  @PostMapping
	  public Mono<Coin> create(@RequestBody Coin Coin) {
		  log.info("CoinController.insert is calling");
		  return service.create(Coin);
	  }
	  
	  /** Actualizar moneda por numero de identidad. */
	  @PutMapping("/{indentityNumber}")
	  public Mono<Coin> update(@RequestBody Coin Coin, @PathVariable("indentityNumber") String indentityNumber) {
		  log.info("CoinController.update is calling");
		  return service.update(Coin, indentityNumber);
	  }
	  
	  /** Eliminar moneda por numero de identidad. */
	  @DeleteMapping("/{indentityNumber}")
	  public Mono<Void> delete(@PathVariable("indentityNumber") String indentityNumber) {
		  log.info("CoinController.update is calling");
		  return service.delete(indentityNumber);	    
	  }
}
