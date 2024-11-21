package com.vkc_s4.master;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterRoundOffProperties {
	@JsonProperty("d:BillingDocument")
	private String billingDocument;
	@JsonProperty("d:BillingDocumentItem")
	private String billingDocumentItem;
	@JsonProperty("d:BillingDocumentItemText")
	private String billingDocumentItemText;
	@JsonProperty("d:ConditionType")
	private String conditionType;	
	@JsonProperty("d:ConditionBaseValue")
	private String conditionBaseValue;
	@JsonProperty("d:ConditionRateValue")
	private String conditionRateValue;
	@JsonProperty("d:ConditionAmount")
	private String conditionAmount;
	@JsonProperty("d:TransactionCurrency")
	private String transactionCurrency;
}
