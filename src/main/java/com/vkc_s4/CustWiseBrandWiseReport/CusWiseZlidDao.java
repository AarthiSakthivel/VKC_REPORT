package com.vkc_s4.CustWiseBrandWiseReport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CusWiseZlidDao {


  

    @JsonProperty("d:BillingDocument")
    private String dBillingDocument;

    @JsonProperty("d:ConditionType")
    private String dConditionType;

    @JsonProperty("d:ZLID_Value")
    private String dZLIDValue;

    @JsonProperty("d:TransactionCurrency")
    private String dTransactionCurrency;

    @JsonProperty("d:ConditionApplication")
    private String dConditionApplication;

    @JsonProperty("d:BillingDocumentItem")
    private String dBillingDocumentItem;

    @JsonProperty("d:Plant")
    private String dPlant;

    @JsonProperty("d:BillingDocument_1")
    private String dBillingDocument1;

    @JsonProperty("d:ConditionRateValue")
    private Double dConditionRateValue;

    @JsonProperty("d:ConditionBaseValue")
    private Double dConditionBaseValue;
	
}
