package com.vkc_s4.SalesDataPrevious3Months;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties("type")
public class SalesDataPrevious3MonthsSalesSubHeaderDAO {

	@JsonProperty("m:properties")
	private SalesDataPrevious3MonthsSalesDAO properties;
	
}