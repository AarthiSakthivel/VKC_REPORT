package com.vkc_s4.Multi_DB_UnitWise_Sales_SA;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnitWiseSummaryDao {

//	public UnitWiseSummaryDao(String unitName2, double ftd2, double mtd2, double ytd2, double avgSalesPerDay2) {
//		
//	}
	private String unitName; 
    private double ftd;
    private double mtd;
    private double ytd;
    private double avgSalesPerDay;

   }
