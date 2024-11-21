package com.vkc_s4.SalesDataPrevious3Months;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties({ "d:ID", "xmlns:d", "xmlns:m" })
public class SalesDataPrevious3MonthsSalesDAO {

	@JsonProperty("d:BillingDocument")
	private String dBillingDocument;

	@JsonProperty("d:BillingDocumentItem")
	private String dBillingDocumentItem;

	@JsonProperty("d:BillingDocumentItemText")
	private String dBillingDocumentItemText;

	@JsonProperty("d:Product")
	private String dProduct;

	@JsonProperty("d:BillingDocumentType")
	private String dBillingDocumentType;

	@JsonProperty("d:BillingDocumentDate")
	private String dBillingDocumentDate;

	@JsonProperty("d:YY1_Model_PRD")
	private String dYY1_Model_PRD;

	@JsonProperty("d:YY1_Color_PRD")
	private String dYY1_Color_PRD;

	@JsonProperty("d:YY1_Sizecategory_PRD")
	private String dYY1_Sizecategory_PRD;

	@JsonProperty("d:YY1_ProductType1_PRD")
	private String dYY1_ProductType1_PRD;

	@JsonProperty("d:YY1_MRP6_PRD")
	private String dYY1_MRP6_PRD;

	@JsonProperty("d:ProductGroup")
	private String dProductGroup;

	@JsonProperty("d:Region")
	private String dRegion;

	private String dCountry;

	private String Region;

	private String dLanguage;

	private String dRegionName;

}
