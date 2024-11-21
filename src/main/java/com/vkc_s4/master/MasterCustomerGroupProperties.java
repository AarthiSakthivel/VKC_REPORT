package com.vkc_s4.master;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterCustomerGroupProperties {
	
	@JsonProperty("d:CustomerAccountGroup")
	private String customerAccountGroup;
	@JsonProperty("d:Language")
	private String language;
	@JsonProperty("d:AccountGroupName")
	private String accountGroupName;
	
}
