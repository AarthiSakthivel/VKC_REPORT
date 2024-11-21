package com.vkc_s4.Multi_DB_UnitWise_Sales_SA;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties("type")
public class SummarySubHeaderDao {
	@JsonProperty("m:properties")
	private SummaryrDao properties;

}
