package com.vkc_s4.master;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties({ "xmlns:d", "xmlns:m" })
public class MasterMaterialGroupPropertiesDAO {

	@JsonProperty(value = "d:MaterialGroup")
	private String dMaterialGroup;

	@JsonProperty(value = "d:MaterialGroupText")
	private String dMaterialGroupText;

	@JsonProperty(value = "d:MaterialGroupName")
	private String dMaterialGroupName;

}
