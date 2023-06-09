package com.anoy.load.itemmaster.sub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class EbsItemMasterEntity {

	@JsonProperty
	private String itemId;
	@JsonProperty
	private String itemStore;
	@JsonProperty
	private String itemLocation;
	@JsonProperty
	private Double itemPrice;
	@JsonProperty
	private String itemStatus;
	@JsonProperty
	private String itemType;
	@JsonProperty
	private String postalCode;
	@JsonProperty
	private String managerName;
	@JsonProperty
	private String managerPhone;
	@JsonProperty
	private String ownership;
	
	
}
