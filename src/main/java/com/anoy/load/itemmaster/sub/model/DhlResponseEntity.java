package com.anoy.load.itemmaster.sub.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class DhlResponseEntity {
	@JsonProperty
	private String itemId;
	@JsonProperty
	private String status;
	@JsonProperty
	private String comment;
}
