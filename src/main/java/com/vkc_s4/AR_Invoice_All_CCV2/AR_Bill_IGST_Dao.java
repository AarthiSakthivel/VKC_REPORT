package com.vkc_s4.AR_Invoice_All_CCV2;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AR_Bill_IGST_Dao {

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
	private BigDecimal dConditionRateValue;

	@JsonProperty("d:TaxCode")
	private String dTaxCode;

	@JsonProperty("d:ConditionAmount")
	private BigDecimal dConditionAmount;

	@JsonProperty("d:TransactionCurrency")
	private String dTransactionCurrency;

	@JsonProperty("d:IGST0")
	private String dIGST0;

	@JsonProperty("d:IGST5")
	private String dIGST5;

	@JsonProperty("d:IGST12")
	private String dIGST12;

	@JsonProperty("d:IGST18")
	private String dIGST18;

	@JsonProperty("d:IGST28")
	private String dIGST28;

	
}
