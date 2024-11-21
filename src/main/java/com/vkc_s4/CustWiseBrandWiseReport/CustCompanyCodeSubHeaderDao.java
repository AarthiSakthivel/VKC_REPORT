package com.vkc_s4.CustWiseBrandWiseReport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties("type")
public class CustCompanyCodeSubHeaderDao {

	@JsonProperty("m:properties")
	private CustCompanyCodeDao properties;
	
}
