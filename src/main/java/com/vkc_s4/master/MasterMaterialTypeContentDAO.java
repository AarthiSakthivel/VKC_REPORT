package com.vkc_s4.master;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties("type")
public class MasterMaterialTypeContentDAO {

		
	@JsonProperty(value = "m:properties")
	private MasterMaterialTypePropertiesDAO properties;
}
