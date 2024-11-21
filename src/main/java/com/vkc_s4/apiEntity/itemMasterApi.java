package com.vkc_s4.apiEntity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class itemMasterApi {

	@JsonProperty("Product")
	private String product;
	@JsonProperty("ProductType")
	private String productType;
	@JsonProperty("IndustrySector")
	private String industrySector;
	@JsonProperty("BaseUnit")
	private String baseUnit;
	@JsonProperty("BaseISOUnit")
	private String baseISOUnit;
	@JsonProperty("ProductGroup")
	private String productGroup;
	@JsonProperty("YY1_Colurcode_PRD")
	private String yy1_Colurcode_PRD;
	@JsonProperty("_ProductDescription")
	private List<ProductDescription> productdescription;

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getIndustrySector() {
		return industrySector;
	}

	public void setIndustrySector(String industrySector) {
		this.industrySector = industrySector;
	}

	public String getBaseUnit() {
		return baseUnit;
	}

	public void setBaseUnit(String baseUnit) {
		this.baseUnit = baseUnit;
	}

	public String getBaseISOUnit() {
		return baseISOUnit;
	}

	public void setBaseISOUnit(String baseISOUnit) {
		this.baseISOUnit = baseISOUnit;
	}

	public String getProductGroup() {
		return productGroup;
	}

	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}

	public String getYY1_Colurcode_PRD() {
		return yy1_Colurcode_PRD;
	}

	public void setYY1_Colurcode_PRD(String yY1_Colurcode_PRD) {
		yy1_Colurcode_PRD = yY1_Colurcode_PRD;
	}

	public List<ProductDescription> getProductdescription() {
		return productdescription;
	}

	public void setProductdescription(List<ProductDescription> listDescription) {
		this.productdescription = listDescription;
	}

//	@Override	
//	public String toString() {
//		return String.format("{Product:%s,ProductType:%s,IndustrySector:%s,BaseUnit:%s,BaseISOUnit:%s,ProductGroup:%s,YY1_Colurcode_PRD:%s}", Product, ProductType, IndustrySector, BaseUnit,BaseISOUnit,ProductGroup,YY1_Colurcode_PRD);
//	}

}
