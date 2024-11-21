package com.vkc_s4.CustWiseBrandWiseReport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties({"link","id","title","category","updated"})
public class CustItemCategoryHeaderDao {

	@JsonProperty("content")
	private CustItemCategorySubHeaderDao content; 
	
}
