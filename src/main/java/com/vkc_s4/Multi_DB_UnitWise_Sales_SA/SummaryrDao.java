package com.vkc_s4.Multi_DB_UnitWise_Sales_SA;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SummaryrDao {
	

	@JsonProperty("d:BillingDocument")
	private String dBillingDocument;

	@JsonProperty("d:BillingDocumentItem")
	private String dBillingDocumentItem;

	@JsonProperty("d:BillingDocumentItemText")
	private String dBillingDocumentItemText;

	@JsonProperty("d:Product")
	private String dProduct;

	@JsonProperty("d:Plant")
	private String dPlant;

	@JsonProperty("d:BillingDocumentDate")
	private String dBillingDocumentDate;

	@JsonProperty("d:ProductGroup")
	private String dProductGroup;

	@JsonProperty("d:TotalNetAmount")
	private String dTotalNetAmount;

	@JsonProperty("d:Region")
	private String dRegion;

	@JsonProperty("d:NetAmount")
	private String dNetAmount;

	@JsonProperty("d:TransactionCurrency")
	private String dTransactionCurrency;

	@JsonProperty("d:TaxAmount")
	private String dTaxAmount;
    
    public String unitName;
    public String ftd;
    public String mtd;
    public String ytd;
    public String averageSales;

}
