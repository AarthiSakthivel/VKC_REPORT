package com.vkc_s4.AR_Invoice_All_CCV2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AR_Invoice_All_RegionDao {

	@JsonProperty("d:Country")
	private String dCountry;

	@JsonProperty("d:Region")
	private String dRegion;

	@JsonProperty("d:RegionName")
	private String dRegionName;

	
}
