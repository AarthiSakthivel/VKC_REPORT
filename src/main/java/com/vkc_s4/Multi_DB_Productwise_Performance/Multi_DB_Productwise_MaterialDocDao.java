package com.vkc_s4.Multi_DB_Productwise_Performance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Multi_DB_Productwise_MaterialDocDao {
	
	@JsonProperty("d:ID")
	private String dID;

	@JsonProperty("d:MaterialDocumentYear")
	private String dMaterialDocumentYear;

	@JsonProperty("d:MaterialDocument")
	private String dMaterialDocument;

	@JsonProperty("d:MaterialDocumentItem")
	private String dMaterialDocumentItem;

	@JsonProperty("d:Material")
	private String dMaterial;

	@JsonProperty("d:Plant")
	private String dPlant;

	@JsonProperty("d:StorageLocation")
	private String dStorageLocation;

	@JsonProperty("d:ManufactureDate")
	private String dManufactureDate;

	@JsonProperty("d:GoodsMovementType")
	private String dGoodsMovementType;

	@JsonProperty("d:PostingDate")
	private String dPostingDate;

	@JsonProperty("d:DocumentDate")
	private String dDocumentDate;

	@JsonProperty("d:QuantityInBaseUnit")
	private String dQuantityInBaseUnit;

	@JsonProperty("d:QuantityInEntryUnit")
	private String dQuantityInEntryUnit;

	@JsonProperty("d:PurchaseOrder")
	private String dPurchaseOrder;

	@JsonProperty("d:PurchaseOrderItem")
	private String dPurchaseOrderItem;

	@JsonProperty("d:SalesOrder")
	private String dSalesOrder;

	@JsonProperty("d:SalesOrderItem")
	private String dSalesOrderItem;

	@JsonProperty("d:EntryUnit")
	private String dEntryUnit;

	@JsonProperty("d:MaterialBaseUnit")
	private String dMaterialBaseUnit;


}
