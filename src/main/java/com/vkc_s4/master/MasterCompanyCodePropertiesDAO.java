package com.vkc_s4.master;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties({"xmlns:d","xmlns:m"})
public class MasterCompanyCodePropertiesDAO {

	@JsonProperty(value="d:CompanyCode")
	private String dCompanyCode;
	
	@JsonProperty(value="d:CompanyCodeName")
	private String dCompanyCodeName;
}
