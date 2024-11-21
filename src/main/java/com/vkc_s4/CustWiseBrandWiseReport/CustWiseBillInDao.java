package com.vkc_s4.CustWiseBrandWiseReport;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustWiseBillInDao {

	
	    @JsonProperty("d:BillingDocument")
	    private String dBillingDocument;

	    @JsonProperty("d:CustomerFullName")
	    private String dCustomerFullName;

	    @JsonProperty("d:DistrictName")
	    private String dDistrictName;

	    @JsonProperty("d:Region")
	    private String dRegion;

	    @JsonProperty("d:TotalTaxAmount")
	    private String dTotalTaxAmount;

	    @JsonProperty("d:TransactionCurrency")
	    private String dTransactionCurrency;

	    @JsonProperty("d:BillingDocumentDate")
	    private String dBillingDocumentDate;

	    @JsonProperty("d:BillingDocumentType")
	    private String dBillingDocumentType;

	    @JsonProperty("d:YY1_PlantCode_BDH")
	    private String dYY1PlantCodeBDH;

	    @JsonProperty("d:BillingDocumentIsCancelled")
	    private Boolean dBillingDocumentIsCancelled;

	    @JsonProperty("d:CustomerName")
	    private String dCustomerName;

	    @JsonProperty("d:BPCustomerName")
	    private String dBPCustomerName;

	    @JsonProperty("d:SoldToParty")
	    private String dSoldToParty;
	    
	    @JsonProperty("d:CompanyCode")
	    private String dCompanyCode; 

	
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
