package com.vkc_s4.AR_Invoice_All_CCV2;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class AR_BILL_SGST_Dao {

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
	private BigDecimal conditionRateValue;

	@JsonProperty("d:TaxCode")
	private String taxCode;

	@JsonProperty("d:ConditionAmount")
	private BigDecimal conditionAmount;

	@JsonProperty("d:TransactionCurrency")
	private String transactionCurrency;

	@JsonProperty("d:SGST0")
	private String sgst0;

	@JsonProperty("d:SGST2")
	private String sgst2;

	@JsonProperty("d:SGST6")
	private String sgst6;

	@JsonProperty("d:SGST9")
	private String sgst9;

	@JsonProperty("d:SGST14")
	private String sgst14;

	
}
