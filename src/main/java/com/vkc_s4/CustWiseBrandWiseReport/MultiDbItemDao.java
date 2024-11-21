package com.vkc_s4.CustWiseBrandWiseReport;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultiDbItemDao {

	 @JsonProperty("d:BillingDocument")
	    private String billingDocument;

	    @JsonProperty("d:BillingDocumentItem")
	    private String billingDocumentItem;

	    @JsonProperty("d:BillingDocumentItemText")
	    private String billingDocumentItemText;

	    @JsonProperty("d:Plant")
	    private String plant;

	    @JsonProperty("d:Product")
	    private String product;

	    @JsonProperty("d:ProductGroup")
	    private String productGroup;

	    @JsonProperty("d:YY1_ProductType_PRD")
	    private String yy1ProductTypePRD;

	    @JsonProperty("d:YY1_ProcessType_PRD")
	    private String yy1ProcessTypePRD;

	    @JsonProperty("d:BillingQuantity")
	    private String billingQuantity;

	    @JsonProperty("d:BillingDocumentDate")
	    private String billingDocumentDate;

	    @JsonProperty("d:BillingQuantityUnit")
	    private String billingQuantityUnit;

	    @JsonProperty("d:CompanyCode")
	    private String companyCode;

	    @JsonProperty("d:ProductType")
	    private String productType;

	    @JsonProperty("d:Region")
	    private String region;

	    @JsonProperty("d:BillToPartyRegion")
	    private String billToPartyRegion;

	    @JsonProperty("d:Country")
	    private String country;

	    @JsonProperty("d:BillToPartyCountry")
	    private String billToPartyCountry;

	    @JsonProperty("d:YY1_Pairqty4_BDI")
	    private String yy1Pairqty4BDI;

	    @JsonProperty("d:TaxAmount")
	    private String taxAmount;

	    @JsonProperty("d:TransactionCurrency")
	    private String transactionCurrency;

	    @JsonProperty("d:YY1_Numberofpairs_PRD")
	    private String yy1NumberofpairsPRD;

	    @JsonProperty("d:StorageLocation")
	    private String storageLocation;

	    @JsonProperty("d:ComparisonPriceQuantity")
	    private String comparisonPriceQuantity;

	    @JsonProperty("d:ContentUnit")
	    private String contentUnit;

	    @JsonProperty("d:CostAmount")
	    private String costAmount;

	    @JsonProperty("d:CustomerGroup")
	    private String customerGroup;

	    @JsonProperty("d:SalesDocumentItemCategory")
	    private String salesDocumentItemCategory;
	    
	    @JsonProperty("d:MaterialGroupName")
	    private String MaterialGroupName;
	    
	    @JsonProperty("d:MaterialGroupText")
	    private String MaterialGroupText;

	    public String costCenterPlant;
	    public String dealername;
	    public String location;
	    public String zone;
	    public String brand;
	    public String pairQty_sales;
	    public String quantity_sales; 
		public String valueBefDisc_sales;
		public String lineDisc_sales;
		public String discount_sales;
		public String freightpositive_sales;
		public String freightnegative_sales;
		public String ValueAfterDisc_sales;
		public String totaltax_sales;
		public String value_with_tax_sales; 
		
		public String pairQty_credit;
		public String quantity_credit; 
		public String valueBefDisc_credit;
		public String lineDisc_credit;
		public String discount_credit;
		public String freightpositive_credit;
		public String freightnegative_credit;
		public String ValueAfterDisc_credit;
		public String totaltax_credit;
		public String value_with_tax_credit;
		public String docType_credit;
	
}
