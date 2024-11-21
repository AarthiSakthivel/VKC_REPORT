package com.vkc_s4.CustWiseBrandWiseReport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class CustWiseItemDao {

	

    @JsonProperty("d:BillingDocument")
    private String billingDocument;

    @JsonProperty("d:BillingDocumentItem")
    private String billingDocumentItem;

    @JsonProperty("d:BillingDocumentItemText")
    private String billingDocumentItemText;

    @JsonProperty("d:Product")
    private String product;

    @JsonProperty("d:MaterialGroup")
    private String materialGroup;

    @JsonProperty("d:ProductGroup")
    private String productGroup;

    @JsonProperty("d:BillingQuantity")
    private String billingQuantity;

    @JsonProperty("d:TaxAmount")
    private Double taxAmount;

    @JsonProperty("d:Plant")
    private String plant;

    @JsonProperty("d:BillingQuantityUnit")
    private String billingQuantityUnit;

    @JsonProperty("d:TransactionCurrency")
    private String transactionCurrency;

    @JsonProperty("d:BillingDocumentType")
    private String billingDocumentType;

    @JsonProperty("d:BillingDocumentDate")
    private String billingDocumentDate;

    @JsonProperty("d:MaterialTypeName")
    private String materialTypeName;
    
    @JsonProperty("d:CompanyCode")
    private String companyCode;
    
    @JsonProperty("d:CancelledBillingDocument")
    private String cancelledBillingDocument;
    
    @JsonProperty("d:BillingDocumentIsCancelled")
    private String billingDocumentIsCancelled;
	
}
