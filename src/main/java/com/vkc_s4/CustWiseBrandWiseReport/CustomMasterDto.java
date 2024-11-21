package com.vkc_s4.CustWiseBrandWiseReport;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomMasterDto {

	String costCenter;
	
	String dealerName;
	
	String location;
	
	String zone;
	
	String Brand;
	
	Double salePairQty;
	
	Double saleQty;
	
	Double SalevalueBefDisc; 
	
	Double SaleLineDisc;
	
	Double SaleDiscount;
	
	Double salefreightPositive;
	
	Double salefreightNegative;
	
	Double salevalueAfterDisc;
	
	Double saletaxAmount;
	
	Double salevalueWithTax;
	
    Double creditPairQty;
	
	Double creditQty;
	
	Double creditvalueBefDisc; 
	
	Double creditLineDisc;
	
	Double creditDiscount;
	
	Double creditfreightPositive;
	
	Double creditfreightNegative;
	
	Double creditvalueAfterDisc;
	
	Double credittaxAmount;
	
	Double creditvalueWithTax;
	
	String docType;

}
