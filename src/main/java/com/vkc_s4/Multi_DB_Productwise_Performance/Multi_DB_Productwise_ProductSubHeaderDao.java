package com.vkc_s4.Multi_DB_Productwise_Performance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties("type")
public class Multi_DB_Productwise_ProductSubHeaderDao {

	@JsonProperty("m:properties")
	private Multi_DB_Productwise_ProductDao properties;
}
