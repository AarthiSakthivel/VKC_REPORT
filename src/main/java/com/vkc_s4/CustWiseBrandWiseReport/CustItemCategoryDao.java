package com.vkc_s4.CustWiseBrandWiseReport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustItemCategoryDao {

	
	 @JsonProperty("d:BillingDocument")
	    private String dBillingDocument;

	    @JsonProperty("d:BillingDocumentItem")
	    private String dBillingDocumentItem;
	    
	    @JsonProperty("d:BillingDocumentItemText")
	    private String dBillingDocumentItemText;

	    @JsonProperty("d:SalesDocumentItemCategory")
	    private String dSalesDocumentItemCategory;
	    
	    @JsonProperty("d:SalesDocumentItemCategoryName")
	    private String dSalesDocumentItemCategoryName;
	    
}
