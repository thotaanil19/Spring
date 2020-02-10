package com.springboot.blockchain.domain;


import org.mongodb.morphia.annotations.Property;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Registration {
	
	@Field("SellerName")
	@Property("SellerName")
	private String sellerName;
	
	@Field("BuyerName")
	@Property("BuyerName")
	private String buyerName;
	
	@Field("Price")
	@Property("Price")
	private Double price;
	
	@Field("SurveyNumber")
	@Property("SurveyNumber")
	private String surveyNumber;
	
	@Field("PropertyAddress")
	@Property("PropertyAddress")
	private String propertyAddress;
	
	@Field("PropertyType")
	@Property("PropertyType")
	private String propertyType;	
	
	

}
