
package com.vkc_s4.CustWiseBrandWiseReport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerWiseZhidDao { 

	@JsonProperty("d:BillingDocument")
	private String dBillingDocument;

	@JsonProperty("d:ConditionType")
	private String dConditionType;

	@JsonProperty("d:BillingDocumentItem")
	private String dBillingDocumentItem;

	@JsonProperty("d:ConditionAmount")
	private String dConditionAmount;

	@JsonProperty("d:TransactionCurrency")
	private String dTransactionCurrency;

	@JsonProperty("d:YY1_PlantCode_BDH")
	private String dYY1PlantCodeBDH;

	@JsonProperty("d:TransactionCurrency_1")
	private String dTransactionCurrency1;
	
	
}
