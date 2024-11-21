package com.vkc_s4.SalesDataPrevious3Months;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SalesDataPrevious3MonthsDto {
	
	String model;
	
	String color;
	
	String sizeChat;
	
	String productType;
	
	String mrp;
	
	String brand;
	
	String brandCode;
	
	String previousFirstMonthSale;
	
	String previousSecondMonthSale;
	
	String previousThirdMonthSale;
	
	String stateCode;
	
	String stateName;   	
	
}
