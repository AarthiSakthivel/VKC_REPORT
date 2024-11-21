package com.vkc_s4.Multi_DB_Productwise_Performance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Multi_DB_Productwise_ProductDao {
	
	@JsonProperty("d:Product")
	private String dProduct;

	@JsonProperty("d:YY1_ArticleNumber_PRD")
	private String dYY1ArticleNumberPRD;

	@JsonProperty("d:YY1_Colurcode_PRD") 
	private String dYY1ColurcodePRD;

	@JsonProperty("d:YY1_Sizecategory_PRD")
	private String dYY1SizecategoryPRD;

	@JsonProperty("d:YY1_Size_PRD")
	private String dYY1SizePRD;


	

}
