package com.vkc_s4.CustWiseBrandWiseReport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustWiseYbhdDao {

    @JsonProperty("d:BillingDocument")
    private String dBillingDocument;

    @JsonProperty("d:ConditionType")
    private String dConditionType;

    @JsonProperty("d:YBHD_Value")
    private String dYBHDValue;

    @JsonProperty("d:TransactionCurrency")
    private String dTransactionCurrency;

    @JsonProperty("d:ConditionApplication")
    private String dConditionApplication;

    @JsonProperty("d:BillingDocumentItem")
    private String dBillingDocumentItem;

    @JsonProperty("d:BillingDocument_1")
    private String dBillingDocument1;

    @JsonProperty("d:Plant")
    private String dPlant;

    @JsonProperty("d:ConditionBaseValue")
    private Double dConditionBaseValue;

    @JsonProperty("d:ConditionRateValue")
    private Double dConditionRateValue;
	
}
