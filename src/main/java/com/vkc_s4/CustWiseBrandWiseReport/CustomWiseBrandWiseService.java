package com.vkc_s4.CustWiseBrandWiseReport;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.vkc_s4.AR_Invoice_All_CCV2.AR_Invoice_13_Dao;
import com.vkc_s4.utils.UtilsService;
import com.vkc_s4.utils.methodsUtilsService;

@Service
public class CustomWiseBrandWiseService {

	@Autowired
	methodsUtilsService altrocksUtils;

	@Autowired
	UtilsService Utils;

	public List<CustWiseItemDao> getCustWiseItemApiDetails() throws Exception {
		// String CustItemApi =
		// "https://my409401-api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTWISEBRANDWISEITEM_CDS/YY1_CUSTWISEBRANDWISEITEM";
		String CustItemApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTWISEBRANDWISEITEM_CDS/YY1_CUSTWISEBRANDWISEITEM";

		// Passing the Document Number & Fiscal year Dynamically
		HttpResponse<String> response = altrocksUtils.ApiCall(CustItemApi, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<CustWiseItemDao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<CustomItemHeaderDao> entryNodes = mapper.reader()
					.forType(mapper.getTypeFactory().constructCollectionType(List.class, CustomItemHeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<CustWiseItemDao> getCustItemData = data;

		// List<APCreditMemoLineDAO> lineFilteredList =
		// LineAPIDetails(documentNo,fiscalYear,companyCode );

		// return lineFilteredList.size() > 0 ? headerFilteredData.get(0) : null;
		return getCustItemData;
	}

	public List<MultiDbItemDao> multiDbItemHeaderAPIDetails() throws Exception {
		String multiDbItemHeaderApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_MULTIDBITEMWISECRAPI_CDS/YY1_MultiDBItemWiseCrAPI";
		// Passing the Document Number & Fiscal year Dynamically
		HttpResponse<String> response = altrocksUtils.ApiCall(multiDbItemHeaderApi, Utils.apiUserName,
				Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<MultiDbItemDao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<MultiDbItemHeaderDao> entryNodes = mapper.reader()
					.forType(mapper.getTypeFactory().constructCollectionType(List.class, MultiDbItemHeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<MultiDbItemDao> multiDbData = data;

		return multiDbData;
	}

	public List<CustWiseBillInDao> custWiseBillingAPIDetails() throws Exception {
		String CustWiseBillInApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERWISEBILLIN_API_CDS/YY1_CUSTOMERWISEBILLIN_API";
		// Passing the Document Number & Fiscal year Dynamically
		HttpResponse<String> response = altrocksUtils.ApiCall(CustWiseBillInApi, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<CustWiseBillInDao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<CustWiseBillInHeaderDao> entryNodes = mapper.reader()
					.forType(mapper.getTypeFactory().constructCollectionType(List.class, CustWiseBillInHeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<CustWiseBillInDao> CustWiseBill = data;

		return CustWiseBill;
	}

	public List<CustWiseYbhdDao> custWiseYbhdAPIDetails() throws Exception {
		String CustWiseYbhdApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERWISEYBHD_API_CDS/YY1_CUSTOMERWISEYBHD_API";
		// Passing the Document Number & Fiscal year Dynamically
		HttpResponse<String> response = altrocksUtils.ApiCall(CustWiseYbhdApi, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<CustWiseYbhdDao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<CustWiseYbhdHeaderDao> entryNodes = mapper.reader()
					.forType(mapper.getTypeFactory().constructCollectionType(List.class, CustWiseYbhdHeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<CustWiseYbhdDao> getCustWiseYbhd = data;

		return getCustWiseYbhd;
	}

	public List<CustWiseZdrdDao> custWiseZdrdAPIDetails() throws Exception {
		String CustWiseYbhdApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERWISEDRD1_API_CDS/YY1_CUSTOMERWISEDRD1_API";
		// Passing the Document Number & Fiscal year Dynamically
		HttpResponse<String> response = altrocksUtils.ApiCall(CustWiseYbhdApi, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<CustWiseZdrdDao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<CustWiseZdrdHeaderDao> entryNodes = mapper.reader()
					.forType(mapper.getTypeFactory().constructCollectionType(List.class, CustWiseZdrdHeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<CustWiseZdrdDao> getCustWiseZdrd = data;

		return getCustWiseZdrd;
	}

	public List<CustWiseZproDao> custWiseZproAPIDetails() throws Exception {
		String CustWiseYbhdApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERWISEZPRO_API_CDS/YY1_CUSTOMERWISEZPRO_API";
		// Passing the Document Number & Fiscal year Dynamically
		HttpResponse<String> response = altrocksUtils.ApiCall(CustWiseYbhdApi, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<CustWiseZproDao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<CustWiseZproHeaderDao> entryNodes = mapper.reader()
					.forType(mapper.getTypeFactory().constructCollectionType(List.class, CustWiseZproHeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<CustWiseZproDao> getCustWiseZpro = data;

		return getCustWiseZpro;
	}

	public List<CusWiseZlidDao> cusWiseZlidAPIDetails() throws Exception {
		String CusWiseZlidApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERWISEZLID_API_CDS/YY1_CUSTOMERWISEZLID_API";
		// Passing the Document Number & Fiscal year Dynamically
		HttpResponse<String> response = altrocksUtils.ApiCall(CusWiseZlidApi, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<CusWiseZlidDao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<CusWiseZlidHeaderDao> entryNodes = mapper.reader()
					.forType(mapper.getTypeFactory().constructCollectionType(List.class, CusWiseZlidHeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<CusWiseZlidDao> getCusWiseZlid = data;

		return getCusWiseZlid;
	}

	public List<RegionDao> regionApiDetails() throws Exception {
		String regionApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_REGIONTEXTAPI_CDS/YY1_RegionTextAPI";

		HttpResponse<String> response = altrocksUtils.ApiCall(regionApi, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<RegionDao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<RegionHeaderDao> entryNodes = mapper.reader()
					.forType(mapper.getTypeFactory().constructCollectionType(List.class, RegionHeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<RegionDao> getRegion = data;

		return getRegion;
	}

	public List<CustomerWiseZhidDao> customerWiseZhidApiDetails() throws Exception {
		String customerWiseZhidApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERWISEZHID_API_CDS/YY1_CUSTOMERWISEZHID_API";

		HttpResponse<String> response = altrocksUtils.ApiCall(customerWiseZhidApi, Utils.apiUserName,
				Utils.apiPassword);

		if (response.getBody() == null || response.getBody().isEmpty()) {
			throw new Exception("API response is empty.");
		}

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody());

		if (entryNodeArray == null || entryNodeArray.isEmpty()) {
			throw new Exception("No content to map after XML to JSON conversion.");
		}

		List<CustomerWiseZhidHeaderDao> entryNodes = mapper.reader()
				.forType(mapper.getTypeFactory().constructCollectionType(List.class, CustomerWiseZhidHeaderDao.class))
				.readValue(entryNodeArray.toString());

		List<CustomerWiseZhidDao> data = entryNodes.stream().map(e -> e.getContent().getProperties())
				.collect(Collectors.toList());

		return data;
	}

	public List<CustCompanyCodeDao> CustCompanyCodeApiDetails() throws Exception {
		String CustCompanyCodeApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_VKCCOMPANYCODE_CDS/YY1_VKCCompanyCode";

		HttpResponse<String> response = altrocksUtils.ApiCall(CustCompanyCodeApi, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<CustCompanyCodeDao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<CustCompanyCodeHeaderDao> entryNodes = mapper.reader()
					.forType(
							mapper.getTypeFactory().constructCollectionType(List.class, CustCompanyCodeHeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<CustCompanyCodeDao> getCustCompanyCOde = data;

		return getCustCompanyCOde;
	}

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
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<CustPlantCodeDao> getCustPlantCode = data;

		return getCustPlantCode;
	}

	public List<CustMaterialGroupDao> custMaterialGroupApiDetails() throws Exception {
		String custMaterialGroupApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_VKCPRODUCTGROUP_CDS/YY1_VKCProductGroup";
//   		String CustCompanyCodeApi = "https://" + Utils.port + "-" +"api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_VKCCOMPANYCODE_CDS/YY1_VKCCompanyCode";

		HttpResponse<String> response = altrocksUtils.ApiCall(custMaterialGroupApi, Utils.apiUserName,
				Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<CustMaterialGroupDao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<CustMaterialGroupHeaderDao> entryNodes = mapper.reader().forType(
					mapper.getTypeFactory().constructCollectionType(List.class, CustMaterialGroupHeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<CustMaterialGroupDao> getCustMaterialGroup = data;

		return getCustMaterialGroup;
	}

	public List<CustMaterialTypeDao> custMaterialTypeApiDetails() throws Exception {
		String custMaterialTypeApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_VKCPRODUCTTYPE_CDS/YY1_VKCProductType";

		HttpResponse<String> response = altrocksUtils.ApiCall(custMaterialTypeApi, Utils.apiUserName,
				Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<CustMaterialTypeDao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<CustMaterialTypeHeaderDao> entryNodes = mapper.reader().forType(
					mapper.getTypeFactory().constructCollectionType(List.class, CustMaterialTypeHeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<CustMaterialTypeDao> getCustMaterialType = data;

		return getCustMaterialType;
	}

	public List<CustItemCategoryDao> custItemCategoryApiDetails() throws Exception {
		String custItemCategoryApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_ITEMCATEOGORYTEXT_CDS/YY1_itemcateogorytext";

		HttpResponse<String> response = altrocksUtils.ApiCall(custItemCategoryApi, Utils.apiUserName,
				Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<CustItemCategoryDao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<CustItemCategoryHeaderDao> entryNodes = mapper.reader().forType(
					mapper.getTypeFactory().constructCollectionType(List.class, CustItemCategoryHeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<CustItemCategoryDao> getCustItemCategoryHeader = data;

		return getCustItemCategoryHeader;
	}

	public Map<String, Map<String, List<CustWiseBillInDao>>> datefilter(String fromDate, String toDate,
			String companyCode, String plant, String materialType, String materialGroup) throws Exception {

		Date fromDateStr = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
		Date toDateStr = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);

		List<String> companyCodeList = Utils.getStringListSepratedByComma(companyCode);
		List<String> plantCodeList = Utils.getStringListSepratedByComma(plant);
		List<String> materialTypeList = Utils.getStringListSepratedByComma(materialType);
		List<String> materialGroupList = Utils.getStringListSepratedByComma(materialGroup);

		List<CustWiseBillInDao> custWiseBillIn = this.custWiseBillingAPIDetails();
		List<CustWiseItemDao> custWiseBrandWiseItem = this.getCustWiseItemApiDetails();
//        List<MultiDbItemDao> multidbItems = this.multiDbItemHeaderAPIDetails();
		List<CustItemCategoryDao> custItemCategoryList = this.custItemCategoryApiDetails();
		List<CustomerWiseZhidDao> customerWiseZhid = this.customerWiseZhidApiDetails();
//        List<CustWiseZdrdDao> custWiseZdrd  = this.custWiseZdrdAPIDetails();
		List<CustWiseZproDao> custWiseZpro = this.custWiseZproAPIDetails();
		List<CusWiseZlidDao> cusWiseZlid = this.cusWiseZlidAPIDetails();
		List<CustWiseYbhdDao> custWiseYbhd = this.custWiseYbhdAPIDetails();
		List<CustMaterialTypeDao> custMaterialType = this.custMaterialTypeApiDetails();
		List<CustMaterialGroupDao> custMaterialGroup = this.custMaterialGroupApiDetails();
		List<MultiDbItemDao> multiDbItemCrApi = this.multiDbItemHeaderAPIDetails();
		List<CustPlantCodeDao> plantCodeApi = this.custPlantCodeApiDetails();
		List<CustWiseItemDao> custWiseBrandWiseApi = this.getCustWiseItemApiDetails();
		List<CustMaterialGroupDao> getMaterialGroupApi = this.custMaterialGroupApiDetails();
		List<RegionDao> region = this.regionApiDetails();

//		List<MultiDbItemDao> filteredAPData = multiDbItemCrApi.parallelStream().filter(e -> {
//			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
//			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//			LocalDate from = parseDate(fromDate, dateTimeFormatter, dateFormatter);
//			LocalDate to = parseDate(toDate, dateTimeFormatter, dateFormatter);
//
//			LocalDate billingDate = parseDate(e.getBillingDocumentDate(), dateTimeFormatter, dateFormatter);
//			return (from == null || billingDate.compareTo(from) >= 0) && (to == null || billingDate.compareTo(to) <= 0)
//					&& (companyCode == null || companyCode.contains(e.getCompanyCode()))
//					&& (plant == null || plant.contains(e.getPlant())) && (materialGroup == null || materialGroup.contains(e.getProductGroup()))
//					&& (materialGroup == null || materialGroup.contains(e.getProductGroup()));
//		}).collect(Collectors.toList());

		List<CustWiseBillInDao> filteredAPData = custWiseBillIn.parallelStream().filter(e -> {
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate from = parseDate(fromDate, dateTimeFormatter, dateFormatter);
			LocalDate to = parseDate(toDate, dateTimeFormatter, dateFormatter);
 
			LocalDate filterBillingDate = parseDate(e.getDBillingDocumentDate(), dateTimeFormatter, dateFormatter);
			return (from == null || filterBillingDate.compareTo(from) >= 0)
					&& (to == null || filterBillingDate.compareTo(to) <= 0)
					&& (companyCode == null || companyCode.contains(e.getDCompanyCode())
							&& (plant == null || plant.contains(e.getDYY1PlantCodeBDH())));
		}).collect(Collectors.toList());

		List<CustWiseBillInDao> filteredHeaderData = custWiseBillIn.parallelStream().filter(e -> {
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate from = parseDate(fromDate, dateTimeFormatter, dateFormatter);
			LocalDate to = parseDate(toDate, dateTimeFormatter, dateFormatter);
			LocalDate filterBillingDate = parseDate(e.getDBillingDocumentDate(), dateTimeFormatter, dateFormatter);
			return (from == null || filterBillingDate.compareTo(from) >= 0)
					&& (to == null || filterBillingDate.compareTo(to) <= 0)
					&& (companyCode == null || companyCode.contains(e.getDCompanyCode()));
		}).collect(Collectors.toList());

		// System.out.println("filteredHeaderData" + filteredHeaderData);
		// System.out.println("filteredAPData" + filteredAPData);

		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
		numberFormat.setGroupingUsed(true);
		numberFormat.setMinimumFractionDigits(2);
		numberFormat.setMaximumFractionDigits(2);

		for (CustWiseBillInDao dbObj : filteredAPData) {

			// filter with date, company code and plant code

			BigDecimal defaultValue = (convertStringToBigDecimal("0.0"));
			String originalDefaultValue = numberFormat.format(defaultValue);

			// costcenter
			String fetchCostCenter = filteredHeaderData.parallelStream().map(CustWiseBillInDao::getDYY1PlantCodeBDH)
					.findFirst().orElse(" ");

			List<CustPlantCodeDao> finalCostCenter = plantCodeApi.parallelStream()
					.filter(e -> e.getDPlant().equalsIgnoreCase(fetchCostCenter)).collect(Collectors.toList());

			String originalCostCenter = finalCostCenter.parallelStream().map(CustPlantCodeDao::getDPlantName)
					.findFirst().orElse(" ");

			dbObj.setCostCenterPlant(originalCostCenter);

			// DealerName
			String fetchDealerName = filteredHeaderData.parallelStream().map(CustWiseBillInDao::getDCustomerName)
					.findFirst().orElse(" ");

			dbObj.setDealername(fetchDealerName);

			// Location
			String fetchLocation = filteredHeaderData.parallelStream().map(CustWiseBillInDao::getDCustomerName)
					.findFirst().orElse(" ");
			String fetchLocation2 = filteredHeaderData.parallelStream().map(CustWiseBillInDao::getDDistrictName)
					.findFirst().orElse(" ");

			dbObj.setLocation(fetchLocation + " " + fetchLocation2);

			// Zone
			String fetchZone = filteredHeaderData.parallelStream().map(CustWiseBillInDao::getDRegion).findFirst()
					.orElse(" ");

			List<RegionDao> filterRegion = regionApiDetails().parallelStream()
					.filter(e -> e.getDRegion().equalsIgnoreCase(fetchZone)).collect(Collectors.toList());

			String originalRegionData = filterRegion.parallelStream().map(RegionDao::getDRegionName).findAny()
					.orElse("");

			dbObj.setZone(originalRegionData);

			// Brand

			// fetching billing document from custwiseBilliIn First filter

			// String fetchBillingDocument =
			// filteredAPData.parallelStream().map(CustWiseBillInDao::getDBillingDocument)
			// .findFirst().orElse(" ");
			String fetchBillingDocument = dbObj.getDBillingDocument();
			// System.out.println("fetchBillingDocument" + fetchBillingDocument);

			// pass billing document into custwiseBrandWise API
			List<CustWiseItemDao> filterwithBillingDocument = custWiseBrandWiseItem.parallelStream()
					.filter(e -> e.getBillingDocument().equalsIgnoreCase(fetchBillingDocument))
					.collect(Collectors.toList());

			String fetchMaterialGroup = filterwithBillingDocument.parallelStream()
					.map(CustWiseItemDao::getMaterialGroup).findFirst().orElse("");

			String fetchProductType = filterwithBillingDocument.parallelStream().map(CustWiseItemDao::getProductGroup)
					.findFirst().orElse("");

			String fetchBrand = custMaterialGroup.parallelStream()
					.filter(e -> e.getDMaterialGroup().equalsIgnoreCase(fetchMaterialGroup)
							&& e.getDMaterialGroup().equalsIgnoreCase(fetchProductType))
					.map(CustMaterialGroupDao::getDMaterialGroupName).findFirst().orElse(" ");

			dbObj.setBrand(fetchBrand);

			// pairQuantitySales

			// get billing document from custwiseBrandWise API

			String getBillingDocumentFromFilter = filterwithBillingDocument.parallelStream()
					.map(CustWiseItemDao::getBillingDocument).findFirst().orElse("");

			// get materialgroup and billing document from multidbitem filter api

			String fetchMaterialGroupForPQ = filterwithBillingDocument.parallelStream()
					.map(CustWiseItemDao::getMaterialGroup).findFirst().orElse(" ");

			String fetchBillingDocumentForPQ = filterwithBillingDocument.parallelStream()
					.map(CustWiseItemDao::getBillingDocument).findFirst().orElse(" ");

			List<MultiDbItemDao> resultPairQuantity = multiDbItemCrApi.parallelStream()
					.filter(e -> e.getProductGroup().equalsIgnoreCase(fetchMaterialGroupForPQ)
							&& e.getBillingDocument().equalsIgnoreCase(fetchBillingDocumentForPQ))
					.collect(Collectors.toList());

			// String finalPairQuantity =
			// resultPairQuantity.parallelStream().map(MultiDbItemDao::getYy1Pairqty4BDIy).findFirst().orElse("");

			String finalPairQuantity = resultPairQuantity.parallelStream().map(item -> item.getYy1Pairqty4BDI()) 
					.findFirst().orElse("");

//			String fetchPairQuantityforSales = multiDbItemCrApi.parallelStream()
//					.filter(e -> e.getProductGroup().equalsIgnoreCase(fetchMaterialGroupForPQ)
//							&& e.getBillingDocument().equalsIgnoreCase(fetchBillingDocumentForPQ))
//					.map(MultiDbItemDao::getYy1Pairqty4BDI).findFirst().orElse(" ");

			// System.out.println("PairQuantity" + finalPairQuantity);

			BigDecimal finalPQ = (convertStringToBigDecimal(finalPairQuantity) != null)
					? convertStringToBigDecimal(finalPairQuantity)
					: BigDecimal.ZERO;

			String originalPairQuantityData = (finalPQ.compareTo(BigDecimal.ZERO) == 0) ? "0.00"
					: numberFormat.format(finalPQ);

			dbObj.setPairQty_sales(originalPairQuantityData);
			dbObj.setPairQty_credit(originalPairQuantityData);

			// QuantitySales

			String getBillingDocumentTypeFilter = filterwithBillingDocument.parallelStream()
					.map(CustWiseItemDao::getBillingDocumentType).findFirst().orElse("");
			
			String getCancelBillingType = filterwithBillingDocument.parallelStream()
					.map(CustWiseItemDao ::getBillingDocumentIsCancelled).findFirst().orElse("");

			if (getBillingDocumentTypeFilter.equalsIgnoreCase("F2") && getCancelBillingType.equalsIgnoreCase("false") ) {

				List<CustWiseItemDao> fetchBillingDocumentNumber = custWiseBrandWiseApi.parallelStream()
						.filter(e -> e.getBillingDocument().equalsIgnoreCase(getBillingDocumentFromFilter))
						.collect(Collectors.toList());

				String fetchQuantitySales = fetchBillingDocumentNumber.parallelStream()
						.map(CustWiseItemDao::getBillingQuantity).findFirst().orElse("");

				BigDecimal finalQuantitySales = (convertStringToBigDecimal(fetchQuantitySales) != null)
						? convertStringToBigDecimal(fetchQuantitySales)
						: BigDecimal.ZERO;

				String originalQuantitySales = (finalQuantitySales.compareTo(BigDecimal.ZERO) == 0) ? "0.00"
						: numberFormat.format(finalQuantitySales);

				
				dbObj.setQuantity_sales(originalQuantitySales);
				dbObj.setQuantity_credit(originalDefaultValue);

			}

			else if (getBillingDocumentTypeFilter.equalsIgnoreCase("G2") && getBillingDocumentTypeFilter.equalsIgnoreCase("CBRE") && getCancelBillingType.equalsIgnoreCase("false") ) {

				List<CustWiseItemDao> fetchBillingDocumentNumberCredit = custWiseBrandWiseApi.parallelStream()
						.filter(e -> e.getBillingDocument().equalsIgnoreCase(getBillingDocumentFromFilter))
						.collect(Collectors.toList());

				String fetchQuantityCredit = fetchBillingDocumentNumberCredit.parallelStream()
						.map(CustWiseItemDao::getBillingQuantity).findFirst().orElse("");

				BigDecimal finalQuantityCredit = (convertStringToBigDecimal(fetchQuantityCredit) != null)
						? convertStringToBigDecimal(fetchQuantityCredit)
						: BigDecimal.ZERO;

				String originalQuantityCredit = (finalQuantityCredit.compareTo(BigDecimal.ZERO) == 0) ? "0.00"
						: numberFormat.format(finalQuantityCredit);

				dbObj.setQuantity_credit(originalQuantityCredit);
				dbObj.setQuantity_sales(originalDefaultValue);

			}
			String originalValueBefoDiscSalesZpro = "";
			String originalValueBefoDiscCredit = "";
			BigDecimal finalValueBefoDiscSalesZpro = BigDecimal.ZERO;
			BigDecimal finalValueBefoDiscCredit = BigDecimal.ZERO;

			// Value Before Discount
			String getBillingDocumentTypeFilterFromCustBillIn = dbObj.getDBillingDocumentType();

			if (getBillingDocumentTypeFilterFromCustBillIn.equalsIgnoreCase("F2") && getCancelBillingType.equalsIgnoreCase("false") ) {

				List<CustWiseZproDao> fetchBillingDocumentNumberZpro = custWiseZpro.parallelStream()
						.filter(e -> e.getDBillingDocument().equalsIgnoreCase(fetchBillingDocument))
						.collect(Collectors.toList());

				String fetchValueBefoDiscSalesZpro = fetchBillingDocumentNumberZpro.parallelStream()
						.map(CustWiseZproDao::getDConditionBaseValue).findFirst().orElse("");

				finalValueBefoDiscSalesZpro = (convertStringToBigDecimal(fetchValueBefoDiscSalesZpro) != null)
						? convertStringToBigDecimal(fetchValueBefoDiscSalesZpro)
						: BigDecimal.ZERO;

				originalValueBefoDiscSalesZpro = (finalValueBefoDiscSalesZpro.compareTo(BigDecimal.ZERO) == 0) ? "0.00"
						: numberFormat.format(finalValueBefoDiscSalesZpro);

				// System.out.println("originalValueBefoDiscSalesZpro" +
				// originalValueBefoDiscSalesZpro);

				dbObj.setValueBefDisc_sales(originalValueBefoDiscSalesZpro);
				dbObj.setValueBefDisc_credit(originalDefaultValue);
			}

			else if (getBillingDocumentTypeFilterFromCustBillIn.equalsIgnoreCase("G2")  && getBillingDocumentTypeFilter.equalsIgnoreCase("CBRE") && getCancelBillingType.equalsIgnoreCase("false") ) {

				List<CustWiseZproDao> fetchBillingDocumentNumber = custWiseZpro.parallelStream()
						.filter(e -> e.getDBillingDocument().equalsIgnoreCase(fetchBillingDocument))
						.collect(Collectors.toList());

				String fetchValueBefoDiscCredit = fetchBillingDocumentNumber.parallelStream()
						.map(CustWiseZproDao::getDConditionBaseValue).findFirst().orElse("");

				finalValueBefoDiscCredit = (convertStringToBigDecimal(fetchValueBefoDiscCredit) != null)
						? convertStringToBigDecimal(fetchValueBefoDiscCredit)
						: BigDecimal.ZERO;

				originalValueBefoDiscCredit = (finalValueBefoDiscCredit.compareTo(BigDecimal.ZERO) == 0) ? "0.00"
						: numberFormat.format(finalValueBefoDiscCredit);

				// System.out.println("originalValueBefoDiscCredit" +
				// originalValueBefoDiscCredit);

				dbObj.setValueBefDisc_credit(originalValueBefoDiscCredit);
				dbObj.setValueBefDisc_sales(originalDefaultValue);
			}

			else {
				dbObj.setValueBefDisc_sales(originalDefaultValue);
				dbObj.setValueBefDisc_credit(originalDefaultValue);
			}

			// Line Discount

			String originalLineDiscSalesZlid = "";
			String originalLineCreditZlid = "";
			BigDecimal finalLineDiscSalesZlid = BigDecimal.ZERO;
			BigDecimal finalLineCreditZlid = BigDecimal.ZERO;

			if (getBillingDocumentTypeFilterFromCustBillIn.equalsIgnoreCase("F2") && getCancelBillingType.equalsIgnoreCase("false")) {

				List<CusWiseZlidDao> fetchBillingDocumentNumber = cusWiseZlid.parallelStream()
						.filter(e -> e.getDBillingDocument().equalsIgnoreCase(fetchBillingDocument))
						.collect(Collectors.toList());

//				String fetchLineDiscSalesZlid = fetchBillingDocumentNumber.parallelStream()
//						.map(CusWiseZlidDao::getDZLIDValue).findFirst().orElse("");

				String fetchLineDiscSalesZlid = "";
				if (fetchBillingDocumentNumber != null && !fetchBillingDocumentNumber.isEmpty()) {
					fetchLineDiscSalesZlid = fetchBillingDocumentNumber.parallelStream().filter(Objects::nonNull) 
							.map(CusWiseZlidDao::getDZLIDValue).filter(Objects::nonNull).findFirst().orElse("");
				}

				finalLineDiscSalesZlid = (convertStringToBigDecimal(fetchLineDiscSalesZlid) != null)
						? convertStringToBigDecimal(fetchLineDiscSalesZlid)
						: BigDecimal.ZERO;

				originalLineDiscSalesZlid = (finalLineDiscSalesZlid.compareTo(BigDecimal.ZERO) == 0) ? "0.00"
						: numberFormat.format(finalLineDiscSalesZlid);

				dbObj.setLineDisc_sales(originalLineDiscSalesZlid);
			}

			else if (getBillingDocumentTypeFilterFromCustBillIn.equalsIgnoreCase("G2")  && getBillingDocumentTypeFilter.equalsIgnoreCase("CBRE") && getCancelBillingType.equalsIgnoreCase("false")) {

				List<CusWiseZlidDao> fetchBillingDocumentNumber = cusWiseZlid.parallelStream()
						.filter(e -> e.getDBillingDocument().equalsIgnoreCase(fetchBillingDocument))
						.collect(Collectors.toList());

//				String fetchLineDiscCreditZlid = fetchBillingDocumentNumber.parallelStream()
//						.map(CusWiseZlidDao::getDZLIDValue).findFirst().orElse("");

				String fetchLineDiscCreditZlid = "";
				if (fetchBillingDocumentNumber != null && !fetchBillingDocumentNumber.isEmpty()) {
					fetchLineDiscCreditZlid = fetchBillingDocumentNumber.parallelStream().filter(Objects::nonNull)
							.map(CusWiseZlidDao::getDZLIDValue).filter(Objects::nonNull) 
							.findFirst().orElse("");
				}

				finalLineCreditZlid = (convertStringToBigDecimal(fetchLineDiscCreditZlid) != null)
						? convertStringToBigDecimal(fetchLineDiscCreditZlid)
						: BigDecimal.ZERO;

				originalLineCreditZlid = (finalLineCreditZlid.compareTo(BigDecimal.ZERO) == 0) ? "0.00"
						: numberFormat.format(finalLineCreditZlid);

				dbObj.setLineDisc_credit(originalLineCreditZlid);
				dbObj.setLineDisc_sales(originalDefaultValue);
			}

			else {
				dbObj.setLineDisc_sales(originalDefaultValue);
				dbObj.setLineDisc_credit(originalDefaultValue);
			}

			// Discount

			String originalDiscSales = "";
			String originalDiscCredit = "";
			BigDecimal finalDiscSales = BigDecimal.ZERO;
			BigDecimal finalDiscCredit = BigDecimal.ZERO;

			if (getBillingDocumentTypeFilterFromCustBillIn.equalsIgnoreCase("F2") && getCancelBillingType.equalsIgnoreCase("false")) {

				List<CustomerWiseZhidDao> fetchBillingDocumentNumber = customerWiseZhid.parallelStream()
						.filter(e -> e.getDBillingDocument().equalsIgnoreCase(fetchBillingDocument))
						.collect(Collectors.toList());

				String fetchDiscSales = fetchBillingDocumentNumber.parallelStream()
						.map(CustomerWiseZhidDao::getDConditionAmount).findFirst().orElse("");

				finalDiscSales = (convertStringToBigDecimal(fetchDiscSales) != null)
						? convertStringToBigDecimal(fetchDiscSales)
						: BigDecimal.ZERO;

				originalDiscSales = (finalDiscSales.compareTo(BigDecimal.ZERO) == 0) ? "0.00"
						: numberFormat.format(finalDiscSales);

				dbObj.setDiscount_sales(originalDiscSales);
				dbObj.setDiscount_credit(originalDefaultValue);

			}

			else if (getBillingDocumentTypeFilterFromCustBillIn.equalsIgnoreCase("G2")  && getBillingDocumentTypeFilter.equalsIgnoreCase("CBRE") && getCancelBillingType.equalsIgnoreCase("false")) {

				List<CustomerWiseZhidDao> fetchBillingDocumentNumber = customerWiseZhid.parallelStream()
						.filter(e -> e.getDBillingDocument().equalsIgnoreCase(fetchBillingDocument))
						.collect(Collectors.toList());

				String fetchDiscCredit = fetchBillingDocumentNumber.parallelStream()
						.map(CustomerWiseZhidDao::getDConditionAmount).findFirst().orElse("");

				finalDiscCredit = (convertStringToBigDecimal(fetchDiscCredit) != null)
						? convertStringToBigDecimal(fetchDiscCredit)
						: BigDecimal.ZERO; 

				originalDiscCredit = (finalDiscCredit.compareTo(BigDecimal.ZERO) == 0) ? "0.00"
						: numberFormat.format(finalDiscCredit);

				dbObj.setDiscount_credit(originalDiscCredit);
				dbObj.setDiscount_sales(originalDefaultValue);
			}

			else {
				dbObj.setDiscount_sales(originalDefaultValue);
				dbObj.setDiscount_credit(originalDefaultValue);
			}

			// Freight Values

			if (getBillingDocumentTypeFilterFromCustBillIn.equalsIgnoreCase("F2") && getCancelBillingType.equalsIgnoreCase("false")) {

				List<CustWiseYbhdDao> fetchBillingDocumentNumber = custWiseYbhd.parallelStream()
						.filter(e -> e.getDBillingDocument().equalsIgnoreCase(fetchBillingDocument))
						.collect(Collectors.toList());

//				String fetchValueBefoDiscSales = fetchBillingDocumentNumber.parallelStream()
//						.map(CustWiseYbhdDao::getDYBHDValue).findFirst().orElse("");

				String fetchValueBefoDiscSales = "";
				if (fetchBillingDocumentNumber != null && !fetchBillingDocumentNumber.isEmpty()) {
					fetchValueBefoDiscSales = fetchBillingDocumentNumber.parallelStream().filter(Objects::nonNull)
							.map(CustWiseYbhdDao::getDYBHDValue).filter(Objects::nonNull)
							.findFirst().orElse(""); 
				}

				BigDecimal finalValueBefoDiscSales = (convertStringToBigDecimal(fetchBillingDocument) != null)
						? convertStringToBigDecimal(fetchValueBefoDiscSales)
						: BigDecimal.ZERO;

				String originalValueBefoDiscSales = (finalValueBefoDiscSales.compareTo(BigDecimal.ZERO) == 0) ? "0.00"
						: numberFormat.format(finalValueBefoDiscSales);

				if (originalValueBefoDiscSales.contains("-")) {
					dbObj.setFreightnegative_sales(originalValueBefoDiscSales);
					dbObj.setFreightnegative_credit(originalDefaultValue);
				} else {
					dbObj.setFreightpositive_sales(originalValueBefoDiscSales);
					dbObj.setFreightpositive_credit(originalDefaultValue);
				}
			}

			else if (getBillingDocumentTypeFilterFromCustBillIn.equalsIgnoreCase("G2") && getBillingDocumentTypeFilter.equalsIgnoreCase("CBRE") && getCancelBillingType.equalsIgnoreCase("false")) {

				List<CustWiseYbhdDao> fetchBillingDocumentNumber = custWiseYbhd.parallelStream()
						.filter(e -> e.getDBillingDocument().equalsIgnoreCase(getBillingDocumentFromFilter))
						.collect(Collectors.toList());

//				String fetchValueBefoDiscCredit = fetchBillingDocumentNumber.parallelStream()
//						.map(CustWiseYbhdDao::getDYBHDValue).findFirst().orElse("");

				String fetchValueBefoDiscCredit = "";
				if (fetchBillingDocumentNumber != null && !fetchBillingDocumentNumber.isEmpty()) {
					fetchValueBefoDiscCredit = fetchBillingDocumentNumber.parallelStream().filter(Objects::nonNull) 
																													
							.map(CustWiseYbhdDao::getDYBHDValue).filter(Objects::nonNull) 
																							
							.findFirst().orElse(""); 
				}

				BigDecimal finalValueBefoDiscSales = (convertStringToBigDecimal(fetchValueBefoDiscCredit) != null)
						? convertStringToBigDecimal(fetchValueBefoDiscCredit)
						: BigDecimal.ZERO;

				String originalValueBefoDiscSales = (finalValueBefoDiscSales.compareTo(BigDecimal.ZERO) == 0) ? "0.00"
						: numberFormat.format(finalValueBefoDiscSales);

				if (originalValueBefoDiscSales.contains("-")) {
					dbObj.setFreightnegative_credit(originalValueBefoDiscSales);
					dbObj.setFreightnegative_sales(originalDefaultValue);
				} else {
					dbObj.setFreightpositive_credit(originalValueBefoDiscSales);
					dbObj.setFreightpositive_sales(originalDefaultValue);
				}
			} 
			
			else {
				dbObj.setFreightnegative_sales(originalDefaultValue);
				dbObj.setFreightpositive_sales(originalDefaultValue);
				dbObj.setFreightnegative_credit(originalDefaultValue);
				dbObj.setFreightpositive_credit(originalDefaultValue);
			}

			// Tax Amount

			String originalTaxAmountSales = "";
			String originalTaxAmountCredit = "";
			BigDecimal finalTaxAmountSales = BigDecimal.ZERO;
			BigDecimal finalTaxAmountCredit = BigDecimal.ZERO;

			if (getBillingDocumentTypeFilterFromCustBillIn.equalsIgnoreCase("F2") && getCancelBillingType.equalsIgnoreCase("false")) {
				String fetchTaxAmount = dbObj.getDTotalTaxAmount();

				finalTaxAmountSales = (convertStringToBigDecimal(fetchTaxAmount) != null)
						? convertStringToBigDecimal(fetchTaxAmount)
						: BigDecimal.ZERO;

				originalTaxAmountSales = (finalTaxAmountSales.compareTo(BigDecimal.ZERO) == 0) ? "0.00"
						: numberFormat.format(finalTaxAmountSales);

				dbObj.setTotaltax_sales(originalTaxAmountSales);
				dbObj.setTotaltax_credit(originalDefaultValue);

			}

			else if (getBillingDocumentTypeFilterFromCustBillIn.equalsIgnoreCase("G2") && getBillingDocumentTypeFilter.equalsIgnoreCase("CBRE") && getCancelBillingType.equalsIgnoreCase("false")) {

				String fetchTaxAmount = dbObj.getDTotalTaxAmount();

				finalTaxAmountCredit = (convertStringToBigDecimal(fetchTaxAmount) != null)
						? convertStringToBigDecimal(fetchTaxAmount)
						: BigDecimal.ZERO;

				originalTaxAmountCredit = (finalTaxAmountCredit.compareTo(BigDecimal.ZERO) == 0) ? "0.00"
						: numberFormat.format(finalTaxAmountCredit);

				dbObj.setTotaltax_credit(originalTaxAmountCredit);
				dbObj.setTotaltax_sales(originalDefaultValue);
			}

			else {
				dbObj.setTotaltax_sales(originalDefaultValue);
				dbObj.setTotaltax_credit(originalDefaultValue);
			}

			// Doc Type
			List<CustItemCategoryDao> filtercategoryList = custItemCategoryList.parallelStream()
					.filter(e -> e.getDBillingDocument().equalsIgnoreCase(fetchBillingDocument))
					.collect(Collectors.toList());

			// System.out.println("filtercategoryList" + filtercategoryList);

			String originalCategory = filtercategoryList.parallelStream()
					.map(CustItemCategoryDao::getDSalesDocumentItemCategoryName).findFirst().orElse("");

			// System.out.println("originalCategory" + originalCategory);

			dbObj.setDocType_credit(originalCategory);

			// valueAfterDiscount for sales

			BigDecimal finalvalueAfterDiscountSales = BigDecimal.ZERO;

			BigDecimal finalvalueAfterDiscountcredit = BigDecimal.ZERO;

			String originalvalueAfterDiscountSales = "";
			String originalvalueAfterDiscountCredit = "";

			if (getBillingDocumentTypeFilterFromCustBillIn.equalsIgnoreCase("F2") && getCancelBillingType.equalsIgnoreCase("false")) {

				finalvalueAfterDiscountSales = finalValueBefoDiscSalesZpro.subtract(finalLineDiscSalesZlid)
						.subtract(finalDiscSales);

				originalvalueAfterDiscountSales = (finalvalueAfterDiscountSales.compareTo(BigDecimal.ZERO) == 0)
						? "0.00"
						: numberFormat.format(finalvalueAfterDiscountSales);

				dbObj.setValueAfterDisc_sales(originalvalueAfterDiscountSales);
				dbObj.setValueAfterDisc_credit(originalDefaultValue);
			}
			// valueAfterDiscount for Credit

			// String valueAfterDiscountCredit = originalValueBefoDiscSalesZpro +
			// originalLineDiscSalesZlid;
			else if (getBillingDocumentTypeFilterFromCustBillIn.equalsIgnoreCase("G2") && getBillingDocumentTypeFilter.equalsIgnoreCase("CBRE") && getCancelBillingType.equalsIgnoreCase("false")) {

				finalvalueAfterDiscountcredit = finalValueBefoDiscCredit.subtract(finalLineCreditZlid)
						.subtract(finalDiscCredit);

				originalvalueAfterDiscountCredit = (finalvalueAfterDiscountcredit.compareTo(BigDecimal.ZERO) == 0)
						? "0.00"
						: numberFormat.format(finalvalueAfterDiscountcredit);

				dbObj.setValueAfterDisc_credit(originalvalueAfterDiscountCredit);
				dbObj.setValueAfterDisc_sales(originalDefaultValue);
			} else {
				dbObj.setValueAfterDisc_sales(originalDefaultValue);
				dbObj.setValueAfterDisc_credit(originalDefaultValue);
			}

			// Value with tax Sales

			if (getBillingDocumentTypeFilterFromCustBillIn.equalsIgnoreCase("F2") && getCancelBillingType.equalsIgnoreCase("false")) {
				BigDecimal finalValuewithTaxSales = finalvalueAfterDiscountSales.add(finalTaxAmountSales);

				String originalnalValuewithTaxSales = (finalValuewithTaxSales.compareTo(BigDecimal.ZERO) == 0) ? "0.00"
						: numberFormat.format(finalValuewithTaxSales);

				dbObj.setValue_with_tax_sales(originalnalValuewithTaxSales);
				dbObj.setValue_with_tax_credit(originalDefaultValue);

			}
			// Value with tax Sales
			else if (getBillingDocumentTypeFilterFromCustBillIn.equalsIgnoreCase("G2") && getBillingDocumentTypeFilter.equalsIgnoreCase("CBRE") && getCancelBillingType.equalsIgnoreCase("false")) {
				BigDecimal finalValuewithTaxCredit = finalvalueAfterDiscountcredit.add(finalTaxAmountCredit);

				String originalnalValuewithTaxCredit = (finalValuewithTaxCredit.compareTo(BigDecimal.ZERO) == 0)
						? "0.00"
						: numberFormat.format(finalValuewithTaxCredit);

				dbObj.setValue_with_tax_credit(originalnalValuewithTaxCredit);
				dbObj.setValue_with_tax_sales(originalDefaultValue);
			} else {
				dbObj.setValue_with_tax_sales(originalDefaultValue);
				dbObj.setValue_with_tax_credit(originalDefaultValue);
			}
		}

		Map<String, Map<String, List<CustWiseBillInDao>>> datas = filteredAPData.parallelStream()
				.collect(Collectors.groupingBy(CustWiseBillInDao::getDCompanyCode, // Group by Company Code
						Collectors.groupingBy(CustWiseBillInDao::getDYY1PlantCodeBDH, // Group by Plant
								Collectors.mapping(dao -> {
									CustWiseBillInDao result = new CustWiseBillInDao();
													
									// Populate result by aggregating fields from dao
									result.setCostCenterPlant(dao.getCostCenterPlant());
									result.setDealername(dao.getDealername());
									result.setLocation(dao.getLocation());
									result.setZone(dao.getZone());
									result.setBrand(dao.getBrand());
									result.setPairQty_sales(dao.getPairQty_sales());
									result.setPairQty_credit(dao.getPairQty_credit());
									result.setQuantity_sales(dao.getQuantity_sales());
									result.setQuantity_credit(dao.getQuantity_credit());
									result.setValueBefDisc_sales(dao.getValueBefDisc_sales());
									result.setValueBefDisc_credit(dao.getValueBefDisc_credit());
									result.setLineDisc_sales(dao.getLineDisc_sales());
									result.setLineDisc_credit(dao.getLineDisc_credit());
									result.setDiscount_sales(dao.getDiscount_sales());
									result.setDiscount_credit(dao.getDiscount_credit());
									result.setFreightnegative_sales(dao.getFreightnegative_sales());
									result.setFreightpositive_sales(dao.getFreightpositive_sales());
									result.setFreightnegative_credit(dao.getFreightnegative_credit());
									result.setFreightpositive_credit(dao.getFreightpositive_credit());
									result.setTotaltax_sales(dao.getTotaltax_sales());
									result.setDocType_credit(dao.getDocType_credit());
									result.setTotaltax_credit(dao.getTotaltax_credit());
									result.setValue_with_tax_credit(dao.getValue_with_tax_credit());
									result.setValue_with_tax_sales(dao.getValue_with_tax_sales());
									result.setValueAfterDisc_credit(dao.getValueAfterDisc_credit());
									result.setValueAfterDisc_sales(dao.getValueAfterDisc_sales());
									return result;
								}, Collectors.toList()) // Collect each item in a List
						)));

		return datas;
	}

	// DateConversion
	private LocalDate parseDate(String dateStr, DateTimeFormatter dateTimeFormatter, DateTimeFormatter dateFormatter) {
		if (dateStr == null) {
			return null;
		}
		try {
			return LocalDate.parse(dateStr, dateTimeFormatter);
		} catch (DateTimeParseException e) {
			return LocalDate.parse(dateStr, dateFormatter);
		}
	}

	public static String convertDate(String input) {
		// Define the input date format (with time)
		DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		// Parse the input date string into LocalDateTime
		LocalDateTime dateTime = LocalDateTime.parse(input, inputFormat);
		// Define the output date format (yy-MM-dd)
		DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		// Format the LocalDateTime into the desired output format
		return dateTime.format(outputFormat);
	}

	private BigDecimal convertStringToBigDecimal(String amount) {
		if (amount == null || amount.trim().isEmpty()) {
			return BigDecimal.ZERO;
		}
		try {
			// Replace any non-numeric characters, except decimal point and negative sign
			String sanitizedAmount = amount.trim().replaceAll("[^0-9.-]", "");
			return new BigDecimal(sanitizedAmount);
		} catch (Exception e) {
			e.printStackTrace();

			return BigDecimal.ZERO;
		}
	}

}
