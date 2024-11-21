package com.vkc_s4.SalesDataPrevious3Months;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties({"link","id","title","category","updated"})
public class SalesDataPrevious3MonthsSalesHeaderLineDAO {

	@JsonProperty("content")
	private SalesDataPrevious3MonthsSalesSubHeaderLineDAO content;
}
