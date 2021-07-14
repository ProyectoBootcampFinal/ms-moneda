package com.everis.moneda.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "coin")
public class Coin {

	  @Id
	  private String id;

	  @Field(name = "identityNumber")
	  private String identityNumber;
	  
	  @Field(name = "name")
	  private String name;

	  @Field(name = "numberBuy")
	  private String numberBuy;
	  
	  @Field(name = "numberSell")
	  private String numberSell;
}
