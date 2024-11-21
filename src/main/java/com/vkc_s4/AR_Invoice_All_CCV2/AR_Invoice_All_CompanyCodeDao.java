package com.vkc_s4.AR_Invoice_All_CCV2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AR_Invoice_All_CompanyCodeDao {

	   @JsonProperty("d:CompanyCode")
	    private String dCompanyCode;

	    @JsonProperty("d:CompanyCodeName")
	    private String dCompanyCodeName;
}
