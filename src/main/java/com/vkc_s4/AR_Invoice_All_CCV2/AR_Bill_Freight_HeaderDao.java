package com.vkc_s4.AR_Invoice_All_CCV2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties({"link","id","title","category","updated"})

public class AR_Bill_Freight_HeaderDao {
	
	@JsonProperty("content")
	private AR_Bill_Freight_SubHeaderDao content;
	
}
