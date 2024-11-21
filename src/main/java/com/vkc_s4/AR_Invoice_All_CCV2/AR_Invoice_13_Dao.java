package com.vkc_s4.AR_Invoice_All_CCV2;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

	@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AR_Invoice_13_Dao {

	@JsonProperty("d:ID")
	private String id;

	@JsonProperty("d:CompanyCode")
	private String companyCode;

	@JsonProperty("d:AccountingDocument")
	private String accountingDocument;

	@JsonProperty("d:FiscalYear")
	private String fiscalYear;

	@JsonProperty("d:AccountingDocumentItem")
	private String accountingDocumentItem;

	@JsonProperty("d:FiscalPeriod")
	private String fiscalPeriod;

	@JsonProperty("d:PostingKey")
	private String postingKey;

	@JsonProperty("d:BillingDocument")
	private String billingDocument;

	@JsonProperty("d:Plant")
	private String plant;

	@JsonProperty("d:Customer")
	private String customer;

	@JsonProperty("d:CustomerAccountGroup")
	private String customerAccountGroup;

	@JsonProperty("d:StreetName_1")
	private String streetName1;

	@JsonProperty("d:CityName_1")
	private String cityName1;

	@JsonProperty("d:DistrictName_1")
	private String districtName1;

	@JsonProperty("d:PostalCode_1")
	private String postalCode1;

	@JsonProperty("d:Region_1")
	private String region1;

	@JsonProperty("d:Country_1")
	private String country1;

	@JsonProperty("d:TaxNumber3")
	private String taxNumber3;

	@JsonProperty("d:TaxNumber2")
	private String taxNumber2;

	@JsonProperty("d:GSTType")
	private String gstType;

	@JsonProperty("d:QuantityInEntryUnit")
	private String quantityInEntryUnit;

	@JsonProperty("d:GoodsMovementEntryUnit")
	private String goodsMovementEntryUnit;

	@JsonProperty("d:DocumentType")
	private String documentType;

	@JsonProperty("d:AccountingDocumentHeaderText")
	private String accountingDocumentHeaderText;

	@JsonProperty("d:Product")
	private String product;

	@JsonProperty("d:AmountInCompanyCodeCurrency")
	private String amountInCompanyCodeCurrency;

	@JsonProperty("d:CompanyCodeCurrency")
	private String companyCodeCurrency;

	@JsonProperty("d:TaxCode")
	private String taxCode;

	@JsonProperty("d:PartnerFunction")
	private String partnerFunction;

	@JsonProperty("d:AddressID")
	private String addressID;

	@JsonProperty("d:HouseNumber")
	private String houseNumber;

	@JsonProperty("d:StreetName")
	private String streetName;

	@JsonProperty("d:CityName")
	private String cityName;

	@JsonProperty("d:DistrictName")
	private String districtName;

	@JsonProperty("d:PostalCode")
	private String postalCode;

	@JsonProperty("d:Region")
	private String region;

	@JsonProperty("d:Country")
	private String country;

	@JsonProperty("d:PostingDate")
	private String postingDate;

	@JsonProperty("d:DocumentStatus")
	private String documentStatus;

	@JsonProperty("d:TaxRate")
	private String taxRate;

	@JsonProperty("d:ClearingJournalEntry")
	private String clearingJournalEntry;

	@JsonProperty("d:ClearingJournalEntryFiscalYear")
	private String clearingJournalEntryFiscalYear;

	@JsonProperty("d:CustomerFullName")
	private String customerFullName;

	@JsonProperty("d:TaxItemAcctgDocItemRef")
	private String taxItemAcctgDocItemRef;

	@JsonProperty("d:TaxItemGroup")
	private String taxItemGroup;

	@JsonProperty("d:AccountingDocumentType")
	private String accountingDocumentType;

	@JsonProperty("d:DebitCreditCode")
	private String debitCreditCode;

	@JsonProperty("d:Plant_1")
	private String plant1;

	public String internalNumber;
	public String internalNumber2;
	public String invDate;
	public String invLine;
	public String invNo;
	public String refNo;
	public String costCenter;
	public String code;
	public String customerName;
	public String customerGroup;
	public String billTo;
	public String customerState;
	public String tin;
	public String shipToAddress;
	public String shipToState;
	public String gstTypeSales;
	public String gstTin;
	public String itemCode;
	public String itemName;
	public String hsnCode;
	public String materialType;
	public String gstTaxCategory;
	public String productCategory;
	public String sizeCategory;
	public String itemGroupName;
	public String quantity;
	public String pairQty;
	public String nofPair;
	public String mrp;
	public String ratePerPair;
	public String ratePerCase;
	public String basicValue;
	public String lineDiscount;
	public String headerDiscount;
	public String totalAfterDiscount;
	public String freight;
	public String roundOff;
	public String netSales;
	public String documentTypeSales;
	public String documentStatusSales;
	public String totalQty;
	public String uom;
	public String whsCode;
	public String remarks;
	public String lineNum;

	// GST Variables
	public String cgst0;
	public String cgst25;
	public String cgst6;
	public String cgst9;
	public String cgst14;
	public String sgst0;
	public String sgst25;
	public String sgst6;
	public String sgst9;
	public String sgst14;
	public String igst0;
	public String igst5;
	public String igst12;
	public String igst18;
	public String igst28;

}
