package com.vkc_s4.master;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties({ "xmlns:d", "xmlns:m" })
public class MasterMaterialTypePropertiesDAO {


		@JsonProperty(value="d:ProductType")
		private String dProductType;
		
		@JsonProperty(value="d:MaterialTypeName")
		private String dMaterialTypeName;

}
