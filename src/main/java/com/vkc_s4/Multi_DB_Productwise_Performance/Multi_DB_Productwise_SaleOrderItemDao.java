package com.vkc_s4.Multi_DB_Productwise_Performance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Multi_DB_Productwise_SaleOrderItemDao {

	@JsonProperty("d:SalesDocument")
	private String dSalesDocument;

	@JsonProperty("d:SalesDocumentItem")
	private String dSalesDocumentItem;

	@JsonProperty("d:SalesDocumentItemText")
	private String dSalesDocumentItemText;

	@JsonProperty("d:Material")
	private String dMaterial;

	@JsonProperty("d:OrderQuantity")
	private String dOrderQuantity;

	@JsonProperty("d:OrderQuantityUnit")
	private String dOrderQuantityUnit;

	@JsonProperty("d:CreationDate")
	private String dCreationDate;

	@JsonProperty("d:BillingCompanyCode")
	private String dBillingCompanyCode;

	@JsonProperty("d:CustomerGroup")
	private String dCustomerGroup;

	@JsonProperty("d:SalesDocumentItemCategory")
	private String dSalesDocumentItemCategory;

	
}
