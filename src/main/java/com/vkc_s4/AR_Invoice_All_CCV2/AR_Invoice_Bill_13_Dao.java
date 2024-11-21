package com.vkc_s4.AR_Invoice_All_CCV2;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AR_Invoice_Bill_13_Dao {
	
	@JsonProperty("d:BillingDocument")
	private String billingDocument;

	@JsonProperty("d:BillingDocumentItem")
	private String billingDocumentItem;

	@JsonProperty("d:BillingDocumentItemText")
	private String billingDocumentItemText;

	@JsonProperty("d:YY1_Pairqty4_BDI")
	private String yy1Pairqty4BDI;

	@JsonProperty("d:BillingQuantity")
	private String billingQuantity;

	@JsonProperty("d:BillingQuantityUnit")
	private String billingQuantityUnit;

	@JsonProperty("d:Product")
	private String product;

	@JsonProperty("d:ProductDescription")
	private String productDescription;

	@JsonProperty("d:ConsumptionTaxCtrlCode")
	private String consumptionTaxCtrlCode;

	@JsonProperty("d:ProductType")
	private String productType;

	@JsonProperty("d:ProductCategory")
	private String productCategory;

	@JsonProperty("d:YY1_Sizecategory_PRD")
	private String yy1SizecategoryPRD;

	@JsonProperty("d:ProductGroup")
	private String productGroup;

	@JsonProperty("d:YY1_Numberofpairs_PRD")
	private String yy1NumberofpairsPRD;

	@JsonProperty("d:YY1_MRP_BDI")
	private String yy1MRPBDI;

	@JsonProperty("d:GSTTaxCat")
	private String gstTaxCat;

	@JsonProperty("d:StorageLocation")
	private String storageLocation;

	@JsonProperty("d:YY1_pairprice8_BDI")
	private String yy1Pairprice8BDI;

	@JsonProperty("d:Plant")
	private String plant;

	@JsonProperty("d:BillingDocumentDate")
	private String billingDocumentDate;

	@JsonProperty("d:PurchaseOrderByCustomer")
	private String purchaseOrderByCustomer;

	@JsonProperty("d:CustomerGroup")
	private String customerGroup;

	@JsonProperty("d:CustomerGroupName")
	private String customerGroupName;

	@JsonProperty("d:MaterialGroupName")
	private String materialGroupName;

}
