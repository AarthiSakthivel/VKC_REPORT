package com.vkc_s4.AR_Invoice_All_CCV2;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AR_Invoice_HeadDiscountDao {

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

	@JsonProperty("d:ConditionQuantity")
	private Integer dConditionQuantity;

	@JsonProperty("d:TaxCode")
	private String dTaxCode;

	@JsonProperty("d:ConditionAmount")
	private String dConditionAmount;

	@JsonProperty("d:ConditionQuantityUnit")
	private String dConditionQuantityUnit;

	@JsonProperty("d:TransactionCurrency")
	private String dTransactionCurrency;

	
}
