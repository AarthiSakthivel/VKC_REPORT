package com.vkc_s4.master;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterPlantPropertiesDAO {

	@JsonProperty(value = "d:PlantName")
	private String dPlantName;

	@JsonProperty(value = "d:CompanyCode")
	private String dCompanyCode;

	@JsonProperty(value = "d:Plant")
	private String dPlant;

}
