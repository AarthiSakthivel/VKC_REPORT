package com.vkc_s4.master;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties({ "link", "id", "title", "category", "updated" })
public class MasterRegionHeaderDAO {
	@JsonProperty("content")
	private MasterRegionSubHeaderDAO content;
	

}
