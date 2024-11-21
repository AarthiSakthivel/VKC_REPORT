package com.vkc_s4.master;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties({"xmlns:d","xmlns:m"})
public class MasterStorageLocationPropertiesDAO {

	@JsonProperty(value="d:Plant")
	private String dPlant;
	
	@JsonProperty(value="d:StorageLocation")
	private String dStorageLocation;
	
	@JsonProperty(value="d:StorageLocationName")
	private String dStorageLocationName;
}
