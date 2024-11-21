package com.vkc_s4.master;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterRegionProperties {
	@JsonProperty("d:Country")
	private String country;
	@JsonProperty("d:Region")
	private String region;
	@JsonProperty("d:Language")
	private String language;
	@JsonProperty("d:RegionName")
	private String regionName;

}
