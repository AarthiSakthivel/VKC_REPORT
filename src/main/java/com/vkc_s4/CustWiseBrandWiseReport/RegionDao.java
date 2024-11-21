package com.vkc_s4.CustWiseBrandWiseReport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class RegionDao {

	@JsonProperty("d:Country")
    private String dCountry;

    @JsonProperty("d:Region")
    private String dRegion;
    
    @JsonProperty("d:Language")
    private String dLanguage;

    @JsonProperty("d:RegionName")
    private String dRegionName;
	
}
