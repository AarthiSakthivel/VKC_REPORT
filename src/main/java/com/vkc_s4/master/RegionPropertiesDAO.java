package com.vkc_s4.master;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(value={"xmlns:d","xmlns:m"})
public class RegionPropertiesDAO {
	
	@JsonProperty("d:Region")
	private String region;
	
	@JsonProperty("d:RegionName")
	private String regionName;
	
	@JsonProperty("d:Country")
	private String country;
}
