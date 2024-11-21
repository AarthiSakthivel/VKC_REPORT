package com.vkc_s4.master;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties({ "xmlns:d", "xmlns:m" })
public class MasterCustomerGroupPropertiesDAO {

	@JsonProperty(value = "d:CustomerGroup")
	private String customerGroup;
	
	@JsonProperty(value = "d:CustomerGroupName")
	private String customerGroupName;
	
	@JsonProperty(value = "d:Language")
	private String language;
	
	
}
