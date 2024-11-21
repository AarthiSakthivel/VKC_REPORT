package com.vkc_s4.SalesDataPrevious3Months;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties({ "d:ID", "xmlns:d", "xmlns:m" })
public class SalesDataPrevious3MonthsRegionDAO {
	
	   @JsonProperty("d:Country")
	    private String dCountry;
	  
	   @JsonProperty("d:Region")
	    private String dRegion;
	   
	   @JsonProperty("d:Language")
	    private String dLanguage;
	   
	   @JsonProperty("d:RegionName")
	    private String dRegionName;
}
