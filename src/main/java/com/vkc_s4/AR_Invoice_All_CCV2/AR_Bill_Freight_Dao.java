package com.vkc_s4.AR_Invoice_All_CCV2;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AR_Bill_Freight_Dao {

	@JsonProperty("d:BillingDocument")
	private String dBillingDocument;

	@JsonProperty("d:BillingDocumentItem")
	private String dBillingDocumentItem;

	@JsonProperty("d:PricingProcedureStep")
	private String dPricingProcedureStep;

	@JsonProperty("d:PricingProcedureCounter")
	private String dPricingProcedureCounter;

	@JsonProperty("d:ConditionType")
	private String dConditionType;

	@JsonProperty("d:ConditionRateValue")
	private String dConditionRateValue;

	@JsonProperty("d:TaxCode")
	private String dTaxCode;

	@JsonProperty("d:ConditionAmount")
	private String dConditionAmount;

	@JsonProperty("d:TransactionCurrency")
	private String dTransactionCurrency;

	
}
