package com.vkc_s4.AR_Invoice_All_CCV2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AR_Invoice_All_PlantCodeDao {

	@JsonProperty("d:Plant")
	private String dPlant;

	@JsonProperty("d:PlantName")
	private String dPlantName;

	@JsonProperty("d:CompanyCode")
	private String dCompanyCode;

}
