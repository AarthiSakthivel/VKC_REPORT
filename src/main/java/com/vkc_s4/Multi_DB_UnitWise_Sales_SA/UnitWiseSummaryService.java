package com.vkc_s4.Multi_DB_UnitWise_Sales_SA;

import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.vkc_s4.CustWiseBrandWiseReport.CustPlantCodeDao;
import com.vkc_s4.CustWiseBrandWiseReport.CustPlantCodeHeaderDao;
import com.vkc_s4.master.MasterService;
import com.vkc_s4.utils.UtilsService;
import com.vkc_s4.utils.methodsUtilsService;
@Service
public class UnitWiseSummaryService {

	@Autowired
	methodsUtilsService altrocksUtils;

	@Autowired
	UtilsService Utils;
	
	@Autowired
	MasterService masterService;
	
	 private static final String ODATA_URL = "https://my410016-api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_MULTIDBUNITWISE_SUMMAR_CDS/";
	    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    
		public List<CustPlantCodeDao> custPlantCodeApiDetails() throws Exception {
			String custPlantCodeApi = "https://" + Utils.port + "-"
					+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_VKCPLANT_CDS/YY1_VKCPlant";
	
			HttpResponse<String> response = altrocksUtils.ApiCall(custPlantCodeApi, Utils.apiUserName, Utils.apiPassword);
	
			ObjectMapper mapper = new ObjectMapper();
			JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
			List<CustPlantCodeDao> data = null;
			// Validating the Blank Data
			if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
				List<CustPlantCodeHeaderDao> entryNodes = mapper.reader()
						.forType(mapper.getTypeFactory().constructCollectionType(List.class, CustPlantCodeHeaderDao.class))
						.readValue(entryNodeArray.toString());
				data = entryNodes.parallelStream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
			}
	
			List<CustPlantCodeDao> getCustPlantCode = data;
	
			return getCustPlantCode;
		}

	    // Fetch the summary data based on the current date
	    public List<UnitWiseSummaryDao> getSummary(String currentDateString) throws Exception {
	        // Fetch the data from OData service
	        List<Map<String, Object>> fetchedData = null; 
			try {
				fetchedData = fetchDataFromOData();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        // Group the data by Plant (Unit Name)

Map<String, List<Map<String, Object>>> groupedDataByPlant = fetchedData.parallelStream()
    .filter(data -> data.get("Plant") != null) // Filter out null "Plant" values
    .collect(Collectors.groupingBy(data -> (String) data.get("Plant")));



	        // Initialize the result list to store UnitWiseSummary for each plant
	        List<UnitWiseSummaryDao> summaries = new ArrayList<>();

	        LocalDate currentDate = LocalDate.parse(currentDateString, dateFormatter);
	        LocalDate startOfFinancialYear = currentDate.withMonth(4).withDayOfMonth(1);

	        double totalFTD = 0.0;
	        double totalMTD = 0.0;
	        double totalYTD = 0.0;
	        double totalAvgSalesPerDay = 0.0;
	        
	        for (int i = 0; i < groupedDataByPlant.entrySet().size(); i++) {
	            List<Entry<String, List<Map<String, Object>>>> entryList = groupedDataByPlant.entrySet().parallelStream().collect(Collectors.toList());
	            Entry<String, List<Map<String, Object>>> entry = entryList.get(i);
	            String unitName = entry.getKey();
	            List<Map<String, Object>> plantData = entry.getValue();

	           
	            
	            // Calculate FTD, MTD, YTD, and Avg Sales in Lakhs/Day
	            String unitPlantName = getUnitName(unitName);
	            double ftd = calculateFTD(plantData, currentDate); 
	            double mtd = calculateMTD(plantData, currentDate);
	            double ytd = calculateYTD(plantData, startOfFinancialYear, currentDate);
	            double avgSalesPerDay = calculateAvgSalesPerDay(ytd, plantData.size());

	            totalFTD += ftd;
	            totalMTD += mtd;
	            totalYTD += ytd;
	            totalAvgSalesPerDay += avgSalesPerDay;
//	            System.out.println("UnitName" +"----"+unitPlantName);
//	            System.out.println("Ftd" +"----"+ ftd);
//	            System.out.println("mtd" +"----"+ mtd);
//	            System.out.println("ytd" +"----"+ ytd);
//	            System.out.println("avgSalesPerDay" +"----"+ avgSalesPerDay);
//	            
//	            System.out.println("Adding to summaries: " + unitPlantName + ", " + ftd + ", " + mtd + ", " + ytd + ", " + avgSalesPerDay);
	            
	            UnitWiseSummaryDao summary = new UnitWiseSummaryDao(unitPlantName, ftd, mtd, ytd, avgSalesPerDay);
	            summaries.add(summary);
	        }
	        String totalUnitName = "Total"; // or however you want to label it
	        UnitWiseSummaryDao totalSummary = new UnitWiseSummaryDao(totalUnitName, totalFTD, totalMTD, totalYTD, totalAvgSalesPerDay);
	        summaries.add(totalSummary);

	        return summaries;
	        
	    }

	    private String getUnitName(String unitName) throws Exception {
	    	List<CustPlantCodeDao>  getAllPlantNamesList = this.custPlantCodeApiDetails(); 
	    	
	    	String subStringBatch =unitName.substring(0, 2);
		    
		    String getPlantName =  getAllPlantNamesList.parallelStream().filter(e -> e.getDPlant().contains(subStringBatch))
		    		.map(CustPlantCodeDao :: getDPlantName).findFirst().orElse("");
	    	
	    	
			return getPlantName;
		}

		// Fetch data from the OData service (stubbed here, replace with actual implementation)
	  
	    	public List<Map<String, Object>> fetchDataFromOData() throws Exception {
	    	     String summaryApi = "https://" + Utils.port + "-"
	    	            + "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_MULTIDBBRANDWISESTATEW_CDS/YY1_MultiDBBrandwiseStatew";
	    	    
	    	     HttpResponse<String> response = altrocksUtils.ApiCall(summaryApi, Utils.apiUserName,
	    	            Utils.apiPassword);

	    	    ObjectMapper mapper = new ObjectMapper();
	    	    
	    	    // Assuming response.getBody() contains the XML response from API
	    	    JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
	    	    
	    	    List<Map<String, Object>> data = new ArrayList<>();
	    	    
	    	    // Validating the Blank Data
	    	    if (entryNodeArray != null && !"".equals(entryNodeArray.toString())) {
	    	        List<SummaryHeaderDao> entryNodes = mapper.reader()
	    	            .forType(mapper.getTypeFactory().constructCollectionType(List.class, SummaryHeaderDao.class))
	    	            .readValue(entryNodeArray.toString());
	    	        
	    	        // Mapping each SummaryrDao into Map<String, Object>
	    	        data = entryNodes.parallelStream()
	    	            .map(e -> {
	    	                SummaryrDao properties = e.getContent().getProperties();
	    	                Map<String, Object> map = new HashMap<>();
	    	                // Assuming SummaryrDao has appropriate getters or fields to retrieve the data
	    	                map.put("BillingDocument", properties.getDBillingDocument());
	    	                map.put("BillingDocumentItem", properties.getDBillingDocumentItem());
	    	                map.put("BillingDocumentItemText", properties.getDBillingDocumentItemText());
	    	                map.put("Product", properties.getDProduct());
	    	                map.put("Plant", properties.getDPlant());
	    	                map.put("BillingDocumentDate", properties.getDBillingDocumentDate());
	    	                map.put("ProductGroup", properties.getDProductGroup());
	    	                map.put("TotalNetAmount", properties.getDTotalNetAmount());
	    	                map.put("Region", properties.getDRegion());
	    	                map.put("NetAmount", properties.getDNetAmount());
	    	                map.put("TransactionCurrency", properties.getDTransactionCurrency());
	    	                map.put("TaxAmount", properties.getDTaxAmount());
	    	                return map;
	    	            })
	    	            .collect(Collectors.toList());
	    	       // System.out.println("RawMasterData ------- "+data);
	    	    }
	    	    
	    	    return data;
	    	}
	    

	    // Calculate FTD (Yesterday's sales): Sum TotalNetAmount + TaxAmount for transactions on currentDate - 1
		private double calculateFTD(List<Map<String, Object>> plantData, LocalDate ftdDate) {
			// currentDate = LocalDate.now();
			// need to remove
			// LocalDate ftdDate = currentDate.minusDays(1);

			double sum = plantData.parallelStream()
				    .filter(Objects::nonNull)
				    .filter(data -> !ObjectUtils.isEmpty(data.get("BillingDocumentDate")) 
				    		&& isSameDate(data.get("BillingDocumentDate").toString(), ftdDate))
				    .mapToDouble(filteredFtdData -> getNetAmountWithTax(filteredFtdData))
				    .sum() / 10000000.0;// in crores
		        //System.out.println("Ftd data "+ sum);    
		    // Round the result to 2 decimal places
		    double result = sum / 10000000.0;
		    return Math.round(result * 100.0)/100.0;																					// crores
		}

	    // Calculate MTD (Month To Date): Sum TotalNetAmount + TaxAmount from the 1st of the month to currentDate - 1
	    private double calculateMTD(List<Map<String, Object>> plantData, LocalDate currentDate) {
	        LocalDate startOfMonth = currentDate.withDayOfMonth(1);
	     
	        double mtdValue  = plantData.parallelStream()
	                .filter(data -> !ObjectUtils.isEmpty(data) && !ObjectUtils.isEmpty(data.get("BillingDocumentDate")))
	                .filter(data -> isFilteredDate(startOfMonth, currentDate, data)) // Filter the data with the date range
	                .mapToDouble(data -> getNetAmountWithTax(data))
	                .sum()/ 10000000.0;
	        
	        //System.out.println("mtd data "+ mtdValue);    
	        
	        return Math.round(mtdValue * 100.0) / 100.0;
		}

	    // Calculate YTD (Year To Date): Sum TotalNetAmount + TaxAmount from the start of the financial year to currentDate - 1
	    private double calculateYTD(List<Map<String, Object>> plantData, LocalDate startOfFinancialYear, LocalDate currentDate) {
	    	
	    	 double ytd = plantData.parallelStream()
	    		        .filter(data -> !ObjectUtils.isEmpty(data) && !ObjectUtils.isEmpty(data.get("BillingDocumentDate")))
	    		        .filter(data -> isFilteredDate(startOfFinancialYear, currentDate, data))
	    		        .mapToDouble(data -> getNetAmountWithTax(data))
	    		        .sum() / 10000000.0; // Convert to crores
                     
	    //	 System.out.println("ytd values" + ytd);
	    	 
	    		    return Math.round(ytd * 100.0) / 100.0; 
	    }

	    // Calculate Avg Sales in Lakhs/Day: (YTD / count of BillingDocuments)
	    private double calculateAvgSalesPerDay(double ytd, int documentCount) {
	    	 double avgSales = (ytd * 100.0 / documentCount); // Convert crores to lakhs

	    	    // Format to two decimal places
	    	    DecimalFormat df = new DecimalFormat("#.##");
	    	    String formattedValue = df.format(avgSales);

	    	    // Parse the formatted string back to double
	    	    return Double.parseDouble(formattedValue);  // Convert crores to lakhs
	    }

	    // Utility function to check if a date is within a range
//	    private boolean isDateInRange(String billingDocumentDate, LocalDate startDate, LocalDate endDate) {
//	        LocalDate date = convertToDate(billingDocumentDate);
//	        return (date != null) && (date.isBefore(startDate) && date.isAfter(endDate));
//	    }

	    // Utility function to check if a date matches exactly
	    private boolean isSameDate(String billingDocumentDate, LocalDate targetDate) {
	        LocalDate date = convertToDate(billingDocumentDate);
	        return (date != null) && date.equals(targetDate);
	    }
	    // Utility function to convert OData date string to LocalDate
          private LocalDate convertToDate(String dateTimeStr) { 
	        // Parse the date-time string to LocalDateTime
	        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);

	        // Return only the date part
	        return localDateTime.toLocalDate();
	    }
	    
//	    private LocalDate convertToDate(Object odataDate) {
//	        if (odataDate != null) {
//	            String dateStr = odataDate.toString();
//	            long timestamp = Long.parseLong(dateStr.replaceAll("\\D+", ""));
//	            return LocalDate.ofEpochDay(timestamp / 86400000L);  // Convert milliseconds to days
//	        }
//	        return null;
//	    }

	    // Utility function to get TotalNetAmount + TaxAmount
	    private double getNetAmountWithTax(Map<String, Object> data) {
	        double totalNetAmount = Double.parseDouble((String) data.get("NetAmount"));
	        double taxAmount = Double.parseDouble((String) data.get("TaxAmount"));
	        
	        double totalAmount = totalNetAmount + taxAmount; 
	        
	       // System.out.println("Total Amount "+ totalAmount);
	        
	        return (totalNetAmount + taxAmount);
	        
	    }
	    
	    private Boolean isFilteredDate(LocalDate startOfMonth, LocalDate mtdEndDate, Map<String, Object> data) {
	        // Assuming BillingDocumentDate is in String format (adjust parsing if necessary)
	        LocalDate billingDate = convertToDate(data.get("BillingDocumentDate").toString()); 

	        // Get all dates between startOfMonth and mtdEndDate
	        List<LocalDate> dateRange = calcListOfDates(startOfMonth, mtdEndDate);

	        // Check if the billing date is in the date range
	        return dateRange.contains(billingDate);
	    }
	    
	    private List<LocalDate> calcListOfDates(LocalDate startDate,LocalDate endDate){
	    	 List<LocalDate> dates = new ArrayList<>();
	         
	         // Ensure the startDate is before or equals the endDate
	         if (startDate.isAfter(endDate)) {
	             throw new IllegalArgumentException("Start date must be before or equal to end date.");
	         }
	         
	         // Add each date from startDate to endDate (inclusive)
	         LocalDate currentDate = startDate;
	         while (!currentDate.isAfter(endDate)){
	             dates.add(currentDate);
	             currentDate = currentDate.plusDays(1);
	         }	          
	         return dates;
	    }
}
