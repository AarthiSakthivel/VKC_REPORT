package com.vkc_s4.AR_Invoice_All_CCV2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties("type")
public class AR_Invoice_All_CompanyCodeSubHeaderDao {

	@JsonProperty("m:properties")
	private AR_Invoice_All_CompanyCodeDao properties;
	
}
