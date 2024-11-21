package com.vkc_s4.apiEntity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDescription {
	@JsonProperty("Product")
	private String product;
	@JsonProperty("Language")
	private String language;
	@JsonProperty("ProductDescription")
	private String productdescription;

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getProductdescription() {
		return productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

//	@Override
//	public String toString() {
//		return String.format("{Product:%s,Language:%s,productdescription:%s}", Product, Language, productdescription);
//	}

}
