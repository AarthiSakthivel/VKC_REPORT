package com.vkc_s4.Multi_DB_Productwise_Performance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class Multi_DB_Productwise_MgfOrderDao {

	@JsonProperty("d:ID")
	private String dID;

	@JsonProperty("d:MfgOrderConfirmationGroup")
	private String dMfgOrderConfirmationGroup;

	@JsonProperty("d:MfgOrderConfirmation")
	private String dMfgOrderConfirmation;

	@JsonProperty("d:ConfirmationText")
	private String dConfirmationText;

	@JsonProperty("d:MfgOrderConfirmationEntryDate")
	private String dMfgOrderConfirmationEntryDate;

	@JsonProperty("d:MfgOrderConfirmationEntryTime")
	private String dMfgOrderConfirmationEntryTime;

	@JsonProperty("d:ConfirmationExternalEntryDate")
	private String dConfirmationExternalEntryDate;

	@JsonProperty("d:ConfirmationExternalEntryTime")
	private String dConfirmationExternalEntryTime;

	@JsonProperty("d:Material")
	private String dMaterial;

	@JsonProperty("d:Product")
	private String dProduct;

	@JsonProperty("d:StorageLocation")
	private String dStorageLocation;

	@JsonProperty("d:CompanyCode")
	private String dCompanyCode;

	@JsonProperty("d:ConfYieldQtyInProductionUnit")
	private String dConfYieldQtyInProductionUnit;

	@JsonProperty("d:ProductionUnit")
	private String dProductionUnit;

	@JsonProperty("d:MaterialDocument")
	private String dMaterialDocument;

	@JsonProperty("d:MaterialDocumentYear")
	private String dMaterialDocumentYear;

}
