package com.vkc_s4.CustWiseBrandWiseReport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustMaterialTypeDao {

	@JsonProperty("d:ProductType")
    private String dProductType;

    @JsonProperty("d:MaterialTypeName")
    private String dMaterialTypeName;
	
}
