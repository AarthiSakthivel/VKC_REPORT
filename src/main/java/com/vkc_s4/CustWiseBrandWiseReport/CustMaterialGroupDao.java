package com.vkc_s4.CustWiseBrandWiseReport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustMaterialGroupDao {

	@JsonProperty("d:MaterialGroup")
    private String dMaterialGroup;

    @JsonProperty("d:MaterialGroupName")
    private String dMaterialGroupName;

    @JsonProperty("d:MaterialGroupText")
    private String dMaterialGroupText; 
	
}
