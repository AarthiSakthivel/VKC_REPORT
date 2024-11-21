package com.vkc_s4.AR_Invoice_All_CCV2;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AR_BILL_CGST_Dao {
    
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

	@JsonProperty("d:CGST0")
	private String cgst0;

	@JsonProperty("d:CGST2")
	private String cgst2;

	@JsonProperty("d:CGST6")
	private String cgst6;

	@JsonProperty("d:CGST9")
	private String cgst9;

	@JsonProperty("d:CGST14")
	private String cgst14;

	
}
