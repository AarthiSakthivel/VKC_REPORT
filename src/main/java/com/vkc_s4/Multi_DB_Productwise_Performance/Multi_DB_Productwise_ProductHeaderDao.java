package com.vkc_s4.Multi_DB_Productwise_Performance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties({"link","id","title","category","updated"})
public class Multi_DB_Productwise_ProductHeaderDao {

	@JsonProperty("content")
	private Multi_DB_Productwise_ProductSubHeaderDao content;
	
}
