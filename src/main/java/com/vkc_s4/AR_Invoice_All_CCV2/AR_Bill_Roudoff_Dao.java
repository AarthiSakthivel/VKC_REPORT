package com.vkc_s4.AR_Invoice_All_CCV2;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AR_Bill_Roudoff_Dao {
	
	@JsonProperty("d:BillingDocument")
	private String billingDocument;

	@JsonProperty("d:BillingDocumentItem")
	private String billingDocumentItem;

	@JsonProperty("d:PricingProcedureStep")
	private String pricingProcedureStep;

	@JsonProperty("d:PricingProcedureCounter")
	private String pricingProcedureCounter;

	@JsonProperty("d:ConditionType")
	private String conditionType;

	@JsonProperty("d:ConditionRateValue")
	private String conditionRateValue;

	@JsonProperty("d:TaxCode")
	private String taxCode;

	@JsonProperty("d:ConditionAmount")
	private String conditionAmount;

	@JsonProperty("d:TransactionCurrency")
	private String transactionCurrency;


}
