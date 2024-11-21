//package com.altrocks.reports.CustWiseBrandWiseReport;
//
//public class Sample {
//
//	Service
//	public class HSN_Credit_Debit_Service {
//		@Autowired
//		UtilsService altrocksUtils;
//	 
//		private static final String UserName = "YY1_VKCREPORTS";
//		private static final String Password = "QoTCLzEWBnkjvKSsdFhgXGb[NBTX5fJhYTAluUCr";
//		private static final String BillingApi = "https://my409401-api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_HSN_SAC_AR_INV_CDS/YY1_HSN_SAC_AR_INV";
//		private static final String BaseAPi = "https://my409401-api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERWISEZPRO_API_CDS/YY1_CUSTOMERWISEZPRO_API";
//		private static final String LineDiscount = "https://my409401-api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERWISEZLID_API_CDS/YY1_CUSTOMERWISEZLID_API";
//		private static final String HeaderDisc = "https://my409401-api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERWISEZHID_API_CDS/YY1_CUSTOMERWISEZHID_API";
//		private static final String Freight = "https://my409401-api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERWISEYBHD_API_CDS/YY1_CUSTOMERWISEYBHD_API";
//		private static final String RoundOff = "https://my409401-api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERWISEYBHD_API_CDS/YY1_CUSTOMERWISEYBHD_API";
//		private static final String NetSales = "https://my409401-api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_HSN_SAC_AR_INV_CDS/YY1_HSN_SAC_AR_INV";
//		private static final String OverAllTax = "https://my409401-api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_TAX_CONDITION_TYPES_CDS/YY1_TAX_CONDITION_TYPES";
//		private static final double TOLERANCE = 1e-6;
//	 
//		public HttpResponse<String> ApiCall(String apiUrl, String username, String password) throws UnirestException {
//			HttpResponse<String> response = Unirest.get(apiUrl).basicAuth(username, password).asString();
//			return response;
//		}
//	 
//		public List<BillingDocumentDAO> getBillingDocuments(String fromDate, String toDate, List<String> companyCodes,
//				List<String> plantCodes) throws UnirestException, JsonMappingException, JsonProcessingException {
//	 
//			HttpResponse<String> response = altrocksUtils.ApiCall(BillingApi, UserName, Password);
//			ObjectMapper mapper = new ObjectMapper();
//			JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody());
//			List<BillingDocumentDAO> data = null;
//			if (entryNodeArray != null && !entryNodeArray.isEmpty()) {
//				List<BillingDocumentHeaderDAO> entryNodes = mapper.reader()
//						.forType(
//								mapper.getTypeFactory().constructCollectionType(List.class, BillingDocumentHeaderDAO.class))
//						.readValue(entryNodeArray.toString());
//				data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
//			}
//			if (data == null) {
//				throw new DataNotFoundException("No billing documents found for the given criteria.");
//			}
//			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
//			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//			LocalDate from = parseDate(fromDate, dateTimeFormatter, dateFormatter);
//			LocalDate to = parseDate(toDate, dateTimeFormatter, dateFormatter);
//			List<BillingDocumentDAO> filteredData = data.stream().filter(e -> {
//				LocalDate billingDate = parseDate(e.getBillingDocumentDate(), dateTimeFormatter, dateFormatter);
//				return (from == null || billingDate.compareTo(from) >= 0) && (to == null || billingDate.compareTo(to) <= 0)
//						&& (companyCodes == null || companyCodes.contains(e.getCompanyCode()))
//						&& (plantCodes == null || plantCodes.contains(e.getPlant()));
//			}).collect(Collectors.toList());
//			// GroupBy
//	 
//			List<LineDAO> discountDetailsList = getZlidValue();
//			List<BaseValueDAO> baseValueFilter = getConditionAmount();
//			List<HeaderDiscountDAO> headerDiscountValue = getDiscountValue();
//			List<FreightDAO> freightValue = getFreightValue();
//			List<RoundOffDAo> roundOffValue = getRoundedValue();
//			List<NetSalesDAO> netSalesValue = getNetSalesValue();
//			List<OverAllDAO> overAllTaxs = getOverAllSalesValue();
//	 
//			
//			// use this iteration for filtering the data
//			
//			for (BillingDocumentDAO obj : filteredData) {
//				// FilterBaseValue
//	 
//				List<BaseValueDAO> getBaseValue = baseValueFilter.stream()
//						.filter(e -> e.getBillingDocument().equalsIgnoreCase(obj.getBillingDocument())
//								&& e.getBillingDocumentItem().equalsIgnoreCase(obj.getBillingDocumentItem()))
//						.collect(Collectors.toList());
//				obj.setZlidValue(!getBaseValue.isEmpty() ? getBaseValue.get(0).getConditionAmount() : 0.00);
//	 
//				// LineFilter
//				List<LineDAO> discountFilteredList = discountDetailsList.stream()
//						.filter(e -> e.getBillingDocument().equalsIgnoreCase(obj.getBillingDocument())
//								&& e.getBillingDocumentItem().equalsIgnoreCase(obj.getBillingDocumentItem()))
//						.collect(Collectors.toList());
//				obj.setZlidValue(!discountFilteredList.isEmpty() ? discountFilteredList.get(0).getZLID_Value() : 0.00);
//	 
//				// FilterHeaderDiscount
//				List<HeaderDiscountDAO> headerDiscountFilterList = headerDiscountValue.stream()
//						.filter(e -> e.getBillingDocument().equalsIgnoreCase(obj.getBillingDocument())
//								&& e.getBillingDocumentItem().equalsIgnoreCase(obj.getBillingDocumentItem()))
//						.collect(Collectors.toList());
//				obj.setConditionAmount(
//						!headerDiscountFilterList.isEmpty() ? headerDiscountFilterList.get(0).getConditionAmount() : 0.00);
//	 
//				// Filter Freight
//				List<FreightDAO> freightFliterValue = freightValue.stream()
//						.filter(e -> e.getBillingDocument().equalsIgnoreCase(obj.getBillingDocument())
//								&& e.getBillingDocumentItem().equalsIgnoreCase(obj.getBillingDocumentItem()))
//						.collect(Collectors.toList());
//				obj.setYbhdValue(!freightFliterValue.isEmpty() ? freightFliterValue.get(0).getYBHDValue() : 0.00);
//	 
//				// Filter RoundOff
//				//Url has need to be change
//				List<RoundOffDAo> RoundoffValue = roundOffValue.stream()
//						.filter(e -> e.getBillingDocument().equalsIgnoreCase(obj.getBillingDocument())
//								&& e.getBillingDocumentItem().equalsIgnoreCase(obj.getBillingDocumentItem()))
//						.collect(Collectors.toList());
//				obj.setRoundOffYbhdValue(!RoundoffValue.isEmpty() ? RoundoffValue.get(0).getYBHD_Value() : 0.00);
//	 
//				// Filter NetOff
//				List<NetSalesDAO> filterNetvalue = netSalesValue.stream()
//						.filter(e -> e.getBillingDocument().equalsIgnoreCase(obj.getBillingDocument())
//								&& e.getBillingDocumentItem().equalsIgnoreCase(obj.getBillingDocumentItem()))
//						.collect(Collectors.toList());
//				obj.setNetSales(!filterNetvalue.isEmpty() ? filterNetvalue.get(0).getNetAmount() : 0.00);
//	 
//				// Filter CGST6
//				List<OverAllDAO> overAllValues = overAllTaxs.stream()
//						.filter(e -> e.getBillingDocument().equalsIgnoreCase(obj.getBillingDocument())
//								&& e.getBillingDocumentItem().equalsIgnoreCase(obj.getBillingDocumentItem()))
//						.collect(Collectors.toList());
//	 
//				List<Double> conditionRateValues6 = overAllValues.stream()
//						.filter(e -> "JOCG".equalsIgnoreCase(e.getConditionType())
//								&& Math.abs(e.getConditionRateValue() - 6.0) < TOLERANCE)
//						.map(OverAllDAO::getConditionAmount).collect(Collectors.toList());
//				if (!conditionRateValues6.isEmpty()) {
//					obj.setCgst6(conditionRateValues6.get(0));
//				}
//	 
//				List<Double> conditionRateValues9 = overAllValues.stream()
//						.filter(e -> "JOCG".equalsIgnoreCase(e.getConditionType())
//								&& Math.abs(e.getConditionRateValue() - 9.0) < TOLERANCE)
//						.map(OverAllDAO::getConditionAmount).collect(Collectors.toList());
//				if (!conditionRateValues9.isEmpty()) {
//					obj.setCGST9(conditionRateValues9.get(0));
//				}
//	 
//				List<Double> conditionRateSGST6 = overAllValues.stream()
//						.filter(e -> "JOSG".equalsIgnoreCase(e.getConditionType())
//								&& Math.abs(e.getConditionRateValue() - 6.0) < TOLERANCE)
//						.map(OverAllDAO::getConditionAmount).collect(Collectors.toList());
//				if (!conditionRateSGST6.isEmpty()) {
//					obj.setSGST6(conditionRateSGST6.get(0));
//				}
//	 
//				List<Double> conditionRateSGST9 = overAllValues.stream()
//						.filter(e -> "JOSG".equalsIgnoreCase(e.getConditionType())
//								&& Math.abs(e.getConditionRateValue() - 9.0) < TOLERANCE)
//						.map(OverAllDAO::getConditionAmount).collect(Collectors.toList());
//				if (!conditionRateSGST9.isEmpty()) {
//					obj.setSGST9(conditionRateSGST9.get(0));
//				}
//	 
//				List<Double> conditionRateIGST12 = overAllValues.stream()
//						.filter(e -> "JOIG".equalsIgnoreCase(e.getConditionType())
//								&& Math.abs(e.getConditionRateValue() - 12.0) < TOLERANCE)
//						.map(OverAllDAO::getConditionAmount).collect(Collectors.toList());
//				if (!conditionRateIGST12.isEmpty()) {
//					obj.setIGST12(conditionRateIGST12.get(0));
//				}
//	 
//				List<Double> conditionRateIGST18 = overAllValues.stream()
//						.filter(e -> "JOIG".equalsIgnoreCase(e.getConditionType())
//								&& Math.abs(e.getConditionRateValue() - 18.0) < TOLERANCE)
//						.map(OverAllDAO::getConditionAmount).collect(Collectors.toList());
//				if (!conditionRateIGST18.isEmpty()) {
//					obj.setIGST18(conditionRateIGST18.get(0));
//				}
//			}
//	 
////			java.util.Map<String, java.util.Map<String, List<BillingDocumentDAO>>> map = filteredData.stream()
////					.collect(Collectors.groupingBy(BillingDocumentDAO::getCompanyCode,
////							Collectors.groupingBy(BillingDocumentDAO::getPlant)));
//	 
//			var data12 = filteredData.stream().collect(Collectors.groupingBy(BillingDocumentDAO::getCompanyCode, Collectors
//					.groupingBy(BillingDocumentDAO::getPlant, Collectors.reducing(new BillingDocumentDAO(), (a, b) -> {
//						BillingDocumentDAO result = new BillingDocumentDAO();
//						result.setCompanyCode(a.getCompanyCode());
//						result.setPlant(a.getPlant());
//						result.setBaseUnit(a.getBaseUnit());
//						result.setConsumptionTaxCtrlCode(a.getConsumptionTaxCtrlCode());
//						result.setConsumptionTaxCtrlCodeText1(a.getConsumptionTaxCtrlCodeText1());
//						result.setBillingQuantity(a.getBillingQuantity() + b.getBillingQuantity());
//						result.setYY1_Pairqty4_BDI(a.getYY1_Pairqty4_BDI() + b.getYY1_Pairqty4_BDI());
//						result.setConditionAmount(a.getConditionAmount() + b.getConditionAmount());
//						result.setZlidValue(a.getZlidValue() + b.getZlidValue());
//						result.setConditionAmount(a.getConditionAmount() + b.getConditionAmount());
//						result.setYbhdValue(a.getYbhdValue() + b.getYbhdValue());
//						// roundoff
//						result.setNetAmount(a.getNetAmount() + b.getNetAmount());
//						result.setCgst6(a.getCgst6() + b.getCgst6());
//						result.setCGST9(a.getCGST9() + b.getCGST9());
//						result.setSGST6(a.getSGST6() + b.getSGST6());
//						result.setSGST9(a.getSGST9() + b.getSGST9());
//						result.setIGST12(a.getIGST12() + b.getIGST12());
//						result.setIGST18(a.getIGST18() + b.getIGST18());
//						return result;
//					}))));
//	 
//			System.out.println("data12 " + data12);
//	 
////			System.out.println("map " + map);
//	 
//			return data12;
//	 
//		}
//	 
//	//DateConversion
//		private LocalDate parseDate(String dateStr, DateTimeFormatter dateTimeFormatter, DateTimeFormatter dateFormatter) {
//			if (dateStr == null) {
//				return null;
//			}
//			try {
//				return LocalDate.parse(dateStr, dateTimeFormatter);
//			} catch (DateTimeParseException e) {
//				return LocalDate.parse(dateStr, dateFormatter);
//			}
//		}
//	 
//	//LineLevel
//		public List<LineDAO> getZlidValue() throws UnirestException, JsonMappingException, JsonProcessingException {
//			HttpResponse<String> response = altrocksUtils.ApiCall(LineDiscount, UserName, Password);
//			ObjectMapper mapper = new ObjectMapper();
//			JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody());
//			List<LineDAO> data = null;
//			if (entryNodeArray != null && !entryNodeArray.isEmpty()) {
//				List<LineDiscountHeaderDAO> entryNodes = mapper.reader()
//						.forType(mapper.getTypeFactory().constructCollectionType(List.class, LineDiscountHeaderDAO.class))
//						.readValue(entryNodeArray.toString());
//				data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
//			}
//			return data;
//		}
//	 
//	//HeaderDiscountValue
//		private List<HeaderDiscountDAO> getDiscountValue()
//				throws UnirestException, JsonMappingException, JsonProcessingException {
//			HttpResponse<String> response = altrocksUtils.ApiCall(HeaderDisc, UserName, Password);
//			ObjectMapper mapper = new ObjectMapper();
//			JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody());
//			List<HeaderDiscountDAO> data = null;
//			if (entryNodeArray != null && !entryNodeArray.isEmpty()) {
//				List<HeaderDiscountHeaderDAO> entryNodes = mapper.reader()
//						.forType(mapper.getTypeFactory().constructCollectionType(List.class, HeaderDiscountHeaderDAO.class))
//						.readValue(entryNodeArray.toString());
//				data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
//			}
//			return data;
//		}
//	 
//	//FreightValue
//		private List<FreightDAO> getFreightValue() throws UnirestException, JsonMappingException, JsonProcessingException {
//			HttpResponse<String> response = altrocksUtils.ApiCall(Freight, UserName, Password);
//			ObjectMapper mapper = new ObjectMapper();
//			JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody());
//			List<FreightDAO> data = null;
//			if (entryNodeArray != null && !entryNodeArray.isEmpty()) {
//				List<FreightHeaderDAO> entryNodes = mapper.reader()
//						.forType(mapper.getTypeFactory().constructCollectionType(List.class, FreightHeaderDAO.class))
//						.readValue(entryNodeArray.toString());
//				data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
//			}
//			return data;
//		}
//	 
//	//RoundedValue
//		private List<RoundOffDAo> getRoundedValue() throws UnirestException, JsonMappingException, JsonProcessingException {
//			HttpResponse<String> response = altrocksUtils.ApiCall(RoundOff, UserName, Password);
//			ObjectMapper mapper = new ObjectMapper();
//			JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody());
//			List<RoundOffDAo> data = null;
//			if (entryNodeArray != null && !entryNodeArray.isEmpty()) {
//				List<RoundOffHeaderDAO> entryNodes = mapper.reader()
//						.forType(mapper.getTypeFactory().constructCollectionType(List.class, RoundOffHeaderDAO.class))
//						.readValue(entryNodeArray.toString());
//				data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
//			}
//			return data;
//		}
//	 
//	//NetSales
//		private List<NetSalesDAO> getNetSalesValue()
//				throws UnirestException, JsonMappingException, JsonProcessingException {
//			HttpResponse<String> response = altrocksUtils.ApiCall(NetSales, UserName, Password);
//			ObjectMapper mapper = new ObjectMapper();
//			JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody());
//			List<NetSalesDAO> data = null;
//			if (entryNodeArray != null && !entryNodeArray.isEmpty()) {
//				List<NetSalesHeaderDAO> entryNodes = mapper.reader()
//						.forType(mapper.getTypeFactory().constructCollectionType(List.class, NetSalesHeaderDAO.class))
//						.readValue(entryNodeArray.toString());
//				data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
//			}
//			return data;
//	 
//		}
//	 
//	//OverAllTax
//		private List<OverAllDAO> getOverAllSalesValue()
//				throws UnirestException, JsonMappingException, JsonProcessingException {
//			HttpResponse<String> response = altrocksUtils.ApiCall(OverAllTax, UserName, Password);
//			ObjectMapper mapper = new ObjectMapper();
//			JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody());
//			List<OverAllDAO> data = null;
//			if (entryNodeArray != null && !entryNodeArray.isEmpty()) {
//				List<OverAllTaxHeaderDAO> entryNodes = mapper.reader()
//						.forType(mapper.getTypeFactory().constructCollectionType(List.class, OverAllTaxHeaderDAO.class))
//						.readValue(entryNodeArray.toString());
//				data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
//			}
//			return data;
//		}
//	 
//	//BaseValue
//		private List<BaseValueDAO> getConditionAmount()
//				throws UnirestException, JsonMappingException, JsonProcessingException {
//			HttpResponse<String> response = altrocksUtils.ApiCall(BaseAPi, UserName, Password);
//			ObjectMapper mapper = new ObjectMapper();
//			JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody());
//			List<BaseValueDAO> data = null;
//			if (entryNodeArray != null && !entryNodeArray.isEmpty()) {
//				List<BaseHeaderDAO> entryNodes = mapper.reader()
//						.forType(mapper.getTypeFactory().constructCollectionType(List.class, BaseHeaderDAO.class))
//						.readValue(entryNodeArray.toString());
//				data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
//			}
//			return data;
//		}
//	}
//	 
//	 
//	
//}
