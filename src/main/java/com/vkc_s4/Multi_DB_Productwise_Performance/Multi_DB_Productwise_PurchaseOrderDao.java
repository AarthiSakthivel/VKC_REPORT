package com.vkc_s4.Multi_DB_Productwise_Performance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Multi_DB_Productwise_PurchaseOrderDao {

	@JsonProperty("d:PurchaseOrder")
	private String dPurchaseOrder;

	@JsonProperty("d:PurchaseOrderItem")
	private String dPurchaseOrderItem;

	@JsonProperty("d:Material")
	private String dMaterial;

	@JsonProperty("d:CompanyCode")
	private String dCompanyCode;

	@JsonProperty("d:Plant")
	private String dPlant;

	@JsonProperty("d:StorageLocation")
	private String dStorageLocation;

	@JsonProperty("d:PurchaseOrderQuantityUnit")
	private String dPurchaseOrderQuantityUnit;

	@JsonProperty("d:OrderQuantity")
	private String dOrderQuantity;

	@JsonProperty("d:PurchaseOrderDate")
	private String dPurchaseOrderDate;

	@JsonProperty("d:CreationDate")
	private String dCreationDate;

	
}
