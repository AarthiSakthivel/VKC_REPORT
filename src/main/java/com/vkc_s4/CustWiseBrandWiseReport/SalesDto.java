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
public class SalesDto {

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
	
}
