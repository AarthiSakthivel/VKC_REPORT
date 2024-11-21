package com.vkc_s4.Multi_DB_UnitWise_Sales_SA;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties({"link","id","title","category","updated"})
public class SummaryHeaderDao {

	@JsonProperty("content")
	private SummarySubHeaderDao content; 
	
}
