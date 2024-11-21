package com.vkc_s4.AR_Invoice_All_CCV2;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.vkc_s4.CustWiseBrandWiseReport.MultiDbItemDao;
import com.vkc_s4.utils.UtilsService;
import com.vkc_s4.utils.methodsUtilsService;

@Service
public class AR_Invoice_All_CCV2Service {
	@Autowired
	methodsUtilsService altrocksUtils;

	@Autowired
	UtilsService Utils;

	public List<AR_Invoice_All_CompanyCodeDao> getCompanyCodeApiDetails() throws Exception {
		String CompanyCodeApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_VKCCOMPANYCODE_CDS/YY1_VKCCompanyCode";

		HttpResponse<String> response = altrocksUtils.ApiCall(CompanyCodeApi, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<AR_Invoice_All_CompanyCodeDao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<AR_Invoice_All_CompanyCodeHeaderDao> entryNodes = mapper.reader().forType(mapper.getTypeFactory()
					.constructCollectionType(List.class, AR_Invoice_All_CompanyCodeHeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<AR_Invoice_All_CompanyCodeDao> getCompanyCode = data;

		return getCompanyCode;
	}

	public List<AR_Invoice_All_PlantCodeDao> getPlantCodeApiDetails() throws Exception {
		String PlantCodeApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_VKCPLANT_CDS/YY1_VKCPlant";

		HttpResponse<String> response = altrocksUtils.ApiCall(PlantCodeApi, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<AR_Invoice_All_PlantCodeDao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<AR_Invoice_All_PlantCodeHeaderDao> entryNodes = mapper.reader().forType(mapper.getTypeFactory()
					.constructCollectionType(List.class, AR_Invoice_All_PlantCodeHeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<AR_Invoice_All_PlantCodeDao> getPlantCode = data;

		return getPlantCode;
	}

	public List<AR_Invoice_13_Dao> getARInvoice13ApiDetails() throws Exception {
		String invoice13Api = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_AR_INVOICE_13_CDS/YY1_AR_Invoice_13";

		HttpResponse<String> response = altrocksUtils.ApiCall(invoice13Api, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<AR_Invoice_13_Dao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<AR_Invoice_13_HeaderDao> entryNodes = mapper.reader()
					.forType(mapper.getTypeFactory().constructCollectionType(List.class, AR_Invoice_13_HeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<AR_Invoice_13_Dao> getInvoice13Api = data;

		return getInvoice13Api;

	}

	public List<AR_Invoice_Bill_13_Dao> getARInvoiceBill13ApiDetails() throws Exception {
		String invoiceBill13Api = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_AR_INVOICE_BILL_13_CDS/YY1_AR_Invoice_Bill_13";

		HttpResponse<String> response = altrocksUtils.ApiCall(invoiceBill13Api, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<AR_Invoice_Bill_13_Dao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<AR_Invoice_Bill_13_HeaderDao> entryNodes = mapper.reader().forType(
					mapper.getTypeFactory().constructCollectionType(List.class, AR_Invoice_Bill_13_HeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<AR_Invoice_Bill_13_Dao> getInvoiceBill13Api = data;

		return getInvoiceBill13Api;
	}

	public List<AR_Invoice_All_RegionDao> getRegionApiDetails() throws Exception {
		String regionApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_VKC_REGION_CDS/YY1_VKC_Region";

		HttpResponse<String> response = altrocksUtils.ApiCall(regionApi, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<AR_Invoice_All_RegionDao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<AR_Invoice_All_RegionHeaderDao> entryNodes = mapper.reader().forType(
					mapper.getTypeFactory().constructCollectionType(List.class, AR_Invoice_All_RegionHeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<AR_Invoice_All_RegionDao> getregionApi = data;

		return getregionApi;
	}

	public List<AR_Invoice_Base_PriceDao> getBasePriceApiDetails() throws Exception {
		String basePriceApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_AR_BILL_BASE_PRICE_CDS/YY1_AR_Bill_Base_Price";

		HttpResponse<String> response = altrocksUtils.ApiCall(basePriceApi, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<AR_Invoice_Base_PriceDao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<AR_Invoice_Base_PriceHeaderDao> entryNodes = mapper.reader().forType(
					mapper.getTypeFactory().constructCollectionType(List.class, AR_Invoice_Base_PriceHeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<AR_Invoice_Base_PriceDao> getBasePriceApi = data;

		return getBasePriceApi;
	}

	public List<AR_Invoice_Bill_DiscountDao> getBillDiscountApiDetails() throws Exception {
		String billDiscountApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_AR_BILL_DISCOUNT_CDS/YY1_AR_Bill_Discount";

		HttpResponse<String> response = altrocksUtils.ApiCall(billDiscountApi, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<AR_Invoice_Bill_DiscountDao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<AR_Invoice_Bill_DiscountHeaderDao> entryNodes = mapper.reader().forType(mapper.getTypeFactory()
					.constructCollectionType(List.class, AR_Invoice_Bill_DiscountHeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<AR_Invoice_Bill_DiscountDao> getBillDiscountApi = data;

		return getBillDiscountApi;
	}

	public List<AR_Invoice_HeadDiscountDao> getHeaderDiscountApiDetails() throws Exception {
		String headerDiscountApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_AR_BILL_HEAD_DISCOUNT_CDS/YY1_AR_Bill_Head_Discount";

		HttpResponse<String> response = altrocksUtils.ApiCall(headerDiscountApi, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<AR_Invoice_HeadDiscountDao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<AR_Invoice_HeadDiscountHeaderDao> entryNodes = mapper.reader().forType(
					mapper.getTypeFactory().constructCollectionType(List.class, AR_Invoice_HeadDiscountHeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<AR_Invoice_HeadDiscountDao> getHeaderDiscountApi = data;

		return getHeaderDiscountApi;
	}

	public List<AR_Bill_Freight_Dao> getBillfreightApiDetails() throws Exception {
		String billfreightApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_AR_BILL_FREIGHT_CDS/YY1_AR_Bill_Freight";

		HttpResponse<String> response = altrocksUtils.ApiCall(billfreightApi, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<AR_Bill_Freight_Dao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<AR_Bill_Freight_HeaderDao> entryNodes = mapper.reader().forType(
					mapper.getTypeFactory().constructCollectionType(List.class, AR_Bill_Freight_HeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<AR_Bill_Freight_Dao> getBillfreightApi = data;

		return getBillfreightApi;
	}

	public List<AR_Bill_Roudoff_Dao> getBillroudoffApiDetails() throws Exception {
		String billRoudoffApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_AR_BILL_ROUDOFF_CDS/YY1_AR_Bill_Roudoff";

		HttpResponse<String> response = altrocksUtils.ApiCall(billRoudoffApi, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<AR_Bill_Roudoff_Dao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<AR_Bill_Roudoff_HeaderDao> entryNodes = mapper.reader().forType(
					mapper.getTypeFactory().constructCollectionType(List.class, AR_Bill_Roudoff_HeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<AR_Bill_Roudoff_Dao> getBillRoudoffApi = data;

		return getBillRoudoffApi;
	}

	public List<AR_BILL_CGST_Dao> getBillCgstApiDetails() throws Exception {
		String billCgstApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_AR_BILL_CGST_CDS/YY1_AR_BILL_CGST";

		HttpResponse<String> response = altrocksUtils.ApiCall(billCgstApi, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<AR_BILL_CGST_Dao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<AR_BILL_CGST_HeaderDao> entryNodes = mapper.reader()
					.forType(mapper.getTypeFactory().constructCollectionType(List.class, AR_BILL_CGST_HeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<AR_BILL_CGST_Dao> getBillCgstApi = data;

		return getBillCgstApi;
	}

	public List<AR_BILL_SGST_Dao> getBillSgstApiDetails() throws Exception {
		String billSgstApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_AR_BILL_SGST_CDS/YY1_AR_BILL_SGST";

		HttpResponse<String> response = altrocksUtils.ApiCall(billSgstApi, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<AR_BILL_SGST_Dao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<AR_BILL_SGST_HeaderDao> entryNodes = mapper.reader()
					.forType(mapper.getTypeFactory().constructCollectionType(List.class, AR_BILL_SGST_HeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<AR_BILL_SGST_Dao> getBillSgstApi = data;

		return getBillSgstApi;
	}

	public List<AR_Bill_IGST_Dao> getBillIgstApiDetails() throws Exception {
		String billIgstApi = "https://" + Utils.port + "-"
				+ "api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_AR_BILL_IGST_CDS/YY1_AR_Bill_IGST";

		HttpResponse<String> response = altrocksUtils.ApiCall(billIgstApi, Utils.apiUserName, Utils.apiPassword);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody().toString());
		List<AR_Bill_IGST_Dao> data = null;
		// Validating the Blank Data
		if (entryNodeArray.toString() != null || !"".equals(entryNodeArray.toString())) {
			List<AR_Bill_IGST_HeaderDao> entryNodes = mapper.reader()
					.forType(mapper.getTypeFactory().constructCollectionType(List.class, AR_Bill_IGST_HeaderDao.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}

		List<AR_Bill_IGST_Dao> getBillIgstApi = data;

		return getBillIgstApi;
	}

	public Map<String, Map<String, List<AR_Invoice_13_Dao>>> datefilter(String fromDate, String toDate,
			String companyCode, String plant) throws Exception {

		List<AR_Invoice_13_Dao> invoice13Api = this.getARInvoice13ApiDetails();
		List<AR_Invoice_Bill_13_Dao> invoice13BillApi = this.getARInvoiceBill13ApiDetails();
		List<AR_Invoice_All_PlantCodeDao> getPlantCodeApi = this.getPlantCodeApiDetails();
		List<AR_Invoice_All_CompanyCodeDao> getCompanyCodeApi = this.getCompanyCodeApiDetails();
		List<AR_Invoice_Bill_DiscountDao> getBillDiscountApi = this.getBillDiscountApiDetails();
		List<AR_Invoice_All_RegionDao> getRegionApi = this.getRegionApiDetails();
		List<AR_Invoice_Base_PriceDao> getBasePriceApi = this.getBasePriceApiDetails();
		List<AR_Invoice_HeadDiscountDao> getHeaderDiscountApi = this.getHeaderDiscountApiDetails();
		List<AR_Bill_Freight_Dao> getFreightDaoApi = this.getBillfreightApiDetails();
		List<AR_BILL_CGST_Dao> getCgstApi = this.getBillCgstApiDetails();
		List<AR_Bill_IGST_Dao> getIgstApi = this.getBillIgstApiDetails();
		List<AR_BILL_SGST_Dao> getSgstApi = this.getBillSgstApiDetails();
		List<AR_Bill_Roudoff_Dao> getRoundOffApi = this.getBillroudoffApiDetails();

		// List<AR_Invoice_13_Dao> headerFilter = invoice13Api.stream().filter()

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate from = parseDate(fromDate, dateTimeFormatter, dateFormatter);
		LocalDate to = parseDate(toDate, dateTimeFormatter, dateFormatter);
		List<AR_Invoice_13_Dao> filteredAPData = invoice13Api.parallelStream().filter(e -> {
			LocalDate billingDate = parseDate(e.getPostingDate(), dateTimeFormatter, dateFormatter);
			return (from == null || billingDate.compareTo(from) >= 0) && (to == null || billingDate.compareTo(to) <= 0)
					&& (companyCode == null || companyCode.contains(e.getCompanyCode()))
					&& (plant == null || plant.contains(e.getPlant1()))
					&& ("RV".equals(e.getAccountingDocumentType()) && "S".equals(e.getDebitCreditCode()))
					 && ("01".equals(e.getPostingKey()));
		}).collect(Collectors.toList());

		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
		numberFormat.setGroupingUsed(true);
		numberFormat.setMinimumFractionDigits(2);
		numberFormat.setMaximumFractionDigits(2);

		//System.out.println("filter" + filteredAPData);

		for (AR_Invoice_13_Dao obj : filteredAPData) {

			//System.out.println("Filtered Data" + filteredAPData);

			// InternalNumber1

			String originalFilterForInternalNumber = (obj.getAccountingDocument() != null) ? obj.getAccountingDocument()
					: "";

			obj.setInternalNumber(originalFilterForInternalNumber);

			// InternalNumber2

			String originalInternalNumber2 = (obj.getAccountingDocument() != null) ? obj.getAccountingDocument() : "";
			obj.setInternalNumber2(originalInternalNumber2);
			// InvDate3

			String postingDate = obj.getPostingDate();
			if (postingDate != null && !postingDate.isEmpty()) {
				try {
					LocalDateTime localDateTime = LocalDateTime.parse(postingDate);
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					String formattedDate = localDateTime.format(formatter);
					obj.setInvDate(formattedDate);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// InvLine4

			String filterWithBill13 = (obj.getBillingDocument() != null) ? obj.getBillingDocument() : "";

			String originalGetInvLine = invoice13BillApi.parallelStream()
					.filter(e -> e.getBillingDocument().equalsIgnoreCase(filterWithBill13))
					.map(AR_Invoice_Bill_13_Dao::getBillingDocumentItem).findFirst().orElse("");

			obj.setInvLine(originalGetInvLine);

			// InvNo5

			String originalInvNo = (obj.getBillingDocument() != null) ? obj.getBillingDocument() : "";
			obj.setInvNo(originalInvNo);

			// RefNo6

			String originalRefNo = invoice13BillApi.parallelStream()
					.filter(e -> e.getBillingDocument().equalsIgnoreCase(filterWithBill13))
					.map(AR_Invoice_Bill_13_Dao::getPurchaseOrderByCustomer).findFirst().orElse("");

			obj.setRefNo(originalRefNo);
									
			// CostCenter7

			String originalCostCenter = (obj.getPlant1() != null) ? obj.getPlant1() : "";
			obj.setCostCenter(originalCostCenter);

			// Code8

			String originalCode = (obj.getCustomer() != null) ? obj.getCustomer() : "";
			obj.setCode(originalCode);

			// CustomerName9

			String originalCustomerName = (obj.getCustomerFullName() != null) ? obj.getCustomerFullName() : "";

			obj.setCustomerName(originalCustomerName);

			// CustomerGroup10

			String originalCustomerGroup = (obj.getCustomerAccountGroup() != null) ? obj.getCustomerAccountGroup() : "";
			obj.setCustomerGroup(originalCustomerGroup);

			// BillTo11

			String street1 = (obj.getStreetName1() != null) ? obj.getStreetName1() : "";
			String City1 = (obj.getCityName1() != null) ? obj.getCityName1() : "";
			String Postal = (obj.getPostalCode1() != null) ? obj.getPostalCode1() : "";
			String Region1 = (obj.getRegion1() != null) ? obj.getRegion1() : "";
			String Country1 = (obj.getCountry1() != null) ? obj.getCountry1() : "";

			String billTo = Stream.of(street1, City1, Postal, Region1, Country1)
					.filter(value -> value != null && !value.isEmpty()).collect(Collectors.joining(", "));
			obj.setBillTo(billTo);

			// CustomerState12

			String getRegion = (obj.getRegion1() != null) ? obj.getRegion1() : "";
			String getCountry = (obj.getCountry1() != null) ? obj.getCountry1() : "";
			String originalCustomerState = getRegionApi.parallelStream()
					.filter(e -> e.getDRegion().equalsIgnoreCase(getRegion)
							&& e.getDCountry().equalsIgnoreCase(getCountry))
					.map(AR_Invoice_All_RegionDao::getDRegionName).findFirst().orElse("");

			obj.setCustomerState(originalCustomerState);

			// Tin13

			String originalTin = (obj.getTaxNumber2() != null) ? obj.getTaxNumber2() : "";
			obj.setTin(originalTin);

			// ShipToAddress14

			String houseNo = (obj.getHouseNumber() != null) ? obj.getHouseNumber() : "";
			String streetName = (obj.getStreetName() != null) ? obj.getStreetName() : "";
			String cityName = (obj.getCityName() != null) ? obj.getCityName() : "";
			String postalCode = (obj.getPostalCode() != null) ? obj.getPostalCode() : "";
			String region = (obj.getRegion() != null) ? obj.getRegion() : "";
			String country = (obj.getCountry() != null) ? obj.getCountry() : "";

			String originalShipToAddress = Stream.of(houseNo, streetName, cityName, postalCode, region, country)
					.filter(value -> value != null && !value.isEmpty()).collect(Collectors.joining(", "));
			obj.setShipToAddress(originalShipToAddress);

			// ShipToState15

			String getShipRegion = (obj.getRegion() != null) ? obj.getRegion() : "";
			String getShipCountry = (obj.getCountry() != null) ? obj.getCountry() : "";

			String originalShipToState = getRegionApi.parallelStream()
					.filter(e -> e.getDRegion().equalsIgnoreCase(getShipRegion)
							&& e.getDCountry().equalsIgnoreCase(getShipCountry))
					.map(AR_Invoice_All_RegionDao::getDRegionName).findFirst().orElse("");

			obj.setShipToState(originalShipToState);

			// GstTypeSales16

			String originalGstTypeSales = (obj.getGstType() != null) ? obj.getGstType() : "";
			obj.setGstTypeSales(originalGstTypeSales);

			// GstTin17

			String originalGstTin = (obj.getTaxNumber3() != null) ? obj.getTaxNumber3() : "";
			obj.setGstTin(originalGstTin);

			// Quantity18

			BigDecimal getQuantityData = (convertStringToBigDecimal(obj.getQuantityInEntryUnit()) != null)
					? convertStringToBigDecimal(obj.getQuantityInEntryUnit())
					: BigDecimal.ZERO;
			String originalQuantityData = numberFormat.format(getQuantityData);
			obj.setQuantity(originalQuantityData);

			// ItemCode19

			String originalItemCode = invoice13BillApi.parallelStream()
					.filter(e -> e.getBillingDocument().equalsIgnoreCase(filterWithBill13))
					.map(AR_Invoice_Bill_13_Dao::getProduct).findFirst().orElse("");

			obj.setItemCode(originalItemCode);

			// ItemName20

			String originalItemName = invoice13BillApi.parallelStream()
					.filter(e -> e.getBillingDocument().equalsIgnoreCase(filterWithBill13))
					.map(AR_Invoice_Bill_13_Dao::getProductDescription).findFirst().orElse("");

			obj.setItemName(originalItemName);

			// HsnCode21

			String getHsnCodeData = invoice13BillApi.parallelStream()
					.filter(e -> e.getBillingDocument().equalsIgnoreCase(filterWithBill13))
					.map(AR_Invoice_Bill_13_Dao::getConsumptionTaxCtrlCode).findFirst().orElse("");

			obj.setHsnCode(getHsnCodeData);

			// MaterialType22

			String getMaterialType = invoice13BillApi.parallelStream()
					.filter(e -> e.getBillingDocument().equalsIgnoreCase(filterWithBill13))
					.map(AR_Invoice_Bill_13_Dao::getProductType).findFirst().orElse("");

			obj.setMaterialType(getMaterialType);

			// ProductCategory23

			String getProductCategory = invoice13BillApi.parallelStream()
					.filter(e -> e.getBillingDocument().equalsIgnoreCase(filterWithBill13))
					.map(AR_Invoice_Bill_13_Dao::getProductCategory).findFirst().orElse("");

			obj.setProductCategory(getProductCategory);

			// GstTaxCategory24

			String getGstTaxCategory = invoice13BillApi.parallelStream()
					.filter(e -> e.getBillingDocument().equalsIgnoreCase(filterWithBill13))
					.map(AR_Invoice_Bill_13_Dao::getGstTaxCat).findFirst().orElse("");

			obj.setGstTaxCategory(getGstTaxCategory);

			// SizeCategory25

			String getSizeCategory = invoice13BillApi.parallelStream()
					.filter(e -> e.getBillingDocument().equalsIgnoreCase(filterWithBill13))
					.map(AR_Invoice_Bill_13_Dao::getYy1SizecategoryPRD).findFirst().orElse("");

			obj.setSizeCategory(getSizeCategory);

			// ItemGroupName26

			String getItemGroupName = invoice13BillApi.parallelStream()
					.filter(e -> e.getBillingDocument().equalsIgnoreCase(filterWithBill13))
					.map(AR_Invoice_Bill_13_Dao::getMaterialGroupName).findFirst().orElse("");

			obj.setItemGroupName(getItemGroupName);

			// PairQty 27

			String getPairQty = invoice13BillApi.parallelStream()
					.filter(e -> e.getBillingDocument().equalsIgnoreCase(filterWithBill13))
					.map(AR_Invoice_Bill_13_Dao::getYy1Pairqty4BDI).findFirst().orElse("");
			
			BigDecimal finalPairQty = ((convertStringToBigDecimal(
					getPairQty) != null)
							? convertStringToBigDecimal(getPairQty)
							: BigDecimal.ZERO)
					.abs();
			String originalPairQty = numberFormat.format(finalPairQty);
			obj.setPairQty(originalPairQty);

			// NofPair 28
			List<AR_Invoice_Bill_13_Dao> getFilter13Bill = invoice13BillApi.parallelStream()
					.filter(e -> e.getBillingDocument().equalsIgnoreCase(filterWithBill13))
					.collect(Collectors.toList());

			BigDecimal getNofPair = getFilter13Bill.parallelStream()
					.map(item -> item.getYy1NumberofpairsPRD() != null
							? convertStringToBigDecimal(item.getYy1NumberofpairsPRD())
							: BigDecimal.ZERO)
					.filter(value -> value.compareTo(BigDecimal.ZERO) != 0) // Ignore zeros
					.findFirst().orElse(BigDecimal.ZERO);

			String originalNofPair = numberFormat.format(getNofPair);
			obj.setNofPair(originalNofPair);

			// Mrp29

			BigDecimal getMrp = getFilter13Bill.parallelStream()
					.map(item -> item.getYy1MRPBDI() != null ? convertStringToBigDecimal(item.getYy1MRPBDI())
							: BigDecimal.ZERO)
					.filter(value -> value.compareTo(BigDecimal.ZERO) != 0) // Ignore zeros
					.findFirst().orElse(BigDecimal.ZERO);

			String originalsMrp = numberFormat.format(getMrp);
			obj.setMrp(originalsMrp);

			// RatePerPair30

			BigDecimal getRatePerPair = getFilter13Bill.parallelStream()
					.map(item -> item.getYy1Pairprice8BDI() != null
							? convertStringToBigDecimal(item.getYy1Pairprice8BDI())
							: BigDecimal.ZERO)
					.filter(value -> value.compareTo(BigDecimal.ZERO) != 0) // Ignore zeros
					.findFirst().orElse(BigDecimal.ZERO);

			String originalsRatePerPair = numberFormat.format(getRatePerPair);
			obj.setRatePerPair(originalsRatePerPair);

			// RatePerCase31

			BigDecimal getRatePerCase = getNofPair.multiply(getRatePerPair);
			String originalRatePerCase = numberFormat.format(getRatePerCase);
			obj.setRatePerCase(originalRatePerCase);

			// BasicValue32

			String filterBillingDocumentItem = getFilter13Bill.parallelStream()
					.map(AR_Invoice_Bill_13_Dao::getBillingDocumentItem).findFirst().orElse("");

			List<AR_Invoice_Base_PriceDao> getBasicValueFilter = getBasePriceApi.parallelStream()
					.filter(e -> e.getDBillingDocument().equalsIgnoreCase(filterWithBill13)
							&& e.getDBillingDocumentItem().equalsIgnoreCase(filterBillingDocumentItem))
					.collect(Collectors.toList());

			BigDecimal getBasicValue = getBasicValueFilter.parallelStream()
					.map(item -> item.getDConditionAmount() != null
							? convertStringToBigDecimal(item.getDConditionAmount())
							: BigDecimal.ZERO)
					.filter(value -> value.compareTo(BigDecimal.ZERO) != 0) // Ignore zeros
					.findFirst().orElse(BigDecimal.ZERO);

			String originalsBasicValue = numberFormat.format(getBasicValue);
			obj.setBasicValue(originalsBasicValue);

			// LineDiscount33

			List<AR_Invoice_Bill_DiscountDao> getLineDiscountFilter = getBillDiscountApi.stream()
					.filter(e -> e.getBillingDocument().equalsIgnoreCase(filterWithBill13)
							&& e.getBillingDocumentItem().equalsIgnoreCase(filterBillingDocumentItem))
					.collect(Collectors.toList());

			BigDecimal getLineDiscount = getLineDiscountFilter.parallelStream()
					.map(item -> item.getConditionAmount() != null
							? convertStringToBigDecimal(item.getConditionAmount())
							: BigDecimal.ZERO)
					.filter(value -> value.compareTo(BigDecimal.ZERO) != 0) // Ignore zeros
					.findFirst().orElse(BigDecimal.ZERO).abs();

			String originalsLineDiscount = numberFormat.format(getLineDiscount);
			obj.setLineDiscount(originalsLineDiscount);

			// HeaderDiscount34

			List<AR_Invoice_HeadDiscountDao> getHeaderDiscountFilter = getHeaderDiscountApi.parallelStream()
					.filter(e -> e.getDBillingDocument().equalsIgnoreCase(filterWithBill13)
							&& e.getDBillingDocumentItem().equalsIgnoreCase(filterBillingDocumentItem))
					.collect(Collectors.toList());

			BigDecimal getHeaderDiscount = getHeaderDiscountFilter.parallelStream()
					.map(item -> item.getDConditionAmount() != null
							? convertStringToBigDecimal(item.getDConditionAmount())
							: BigDecimal.ZERO)
					.filter(value -> value.compareTo(BigDecimal.ZERO) != 0) // Ignore zeros
					.findFirst().orElse(BigDecimal.ZERO);

			String originalHeaderDiscount = numberFormat.format(getHeaderDiscount);
			obj.setHeaderDiscount(originalHeaderDiscount);

			// TotalAfterDiscount35

			BigDecimal getTotalAfterDiscount = getBasicValue.subtract(getLineDiscount).subtract(getHeaderDiscount);
			String originalTotalAfterDiscount = numberFormat.format(getTotalAfterDiscount);
			obj.setTotalAfterDiscount(originalTotalAfterDiscount);

			// Freight36

			List<AR_Bill_Freight_Dao> getFreightFilter = getFreightDaoApi.parallelStream()
					.filter(e -> e.getDBillingDocument().equalsIgnoreCase(filterWithBill13)
							&& e.getDBillingDocumentItem().equalsIgnoreCase(filterBillingDocumentItem))
					.collect(Collectors.toList());

			BigDecimal getFreight = getFreightFilter.parallelStream()
					.map(item -> item.getDConditionAmount() != null
							? convertStringToBigDecimal(item.getDConditionAmount())
							: BigDecimal.ZERO)
					.filter(value -> value.compareTo(BigDecimal.ZERO) != 0) // Ignore zeros
					.findFirst().orElse(BigDecimal.ZERO);

			String originalFreight = numberFormat.format(getFreight);
			obj.setFreight(originalFreight);

			// RoundOff37

			List<AR_Bill_Roudoff_Dao> getRoundOffFilter = getRoundOffApi.parallelStream()
					.filter(e -> e.getBillingDocument().equalsIgnoreCase(filterWithBill13)
							&& e.getBillingDocumentItem().equalsIgnoreCase(filterBillingDocumentItem))
					.collect(Collectors.toList());

			BigDecimal getRoundOff = (getRoundOffFilter.parallelStream()
					.map(item -> item.getConditionAmount() != null
							? convertStringToBigDecimal(item.getConditionAmount())
							: BigDecimal.ZERO)
					.filter(value -> value.compareTo(BigDecimal.ZERO) != 0) // Ignore zeros
					.findFirst().orElse(BigDecimal.ZERO)).abs();

			String originalRoundOff = numberFormat.format(getRoundOff);
			obj.setRoundOff(originalRoundOff);

			// DocumentStatusSales38

			String originalDocumentStatusSales = (obj.getDocumentStatus() != null) ? obj.getDocumentStatus() : "";
			obj.setDocumentStatusSales(originalDocumentStatusSales);

			// DocumentTypeSales39

			String originalDocumentTypeSales = (obj.getDocumentType() != null) ? obj.getDocumentType() : "";
			obj.setDocumentTypeSales(originalDocumentTypeSales);
			
			// TotoalQty
			
			obj.setTotalQty("0.00");

			// NetSales40

			BigDecimal getAmountInCompanyCodeCurrency = ((convertStringToBigDecimal(
					obj.getAmountInCompanyCodeCurrency()) != null)
							? convertStringToBigDecimal(obj.getAmountInCompanyCodeCurrency())
							: BigDecimal.ZERO)
					.abs();
			String formattedAmountInCompanyCodeCurrency = numberFormat.format(getAmountInCompanyCodeCurrency);
//			obj.setBasicValues(totalAmountInCompanyCodeCurrency);
			obj.setNetSales(formattedAmountInCompanyCodeCurrency);

			// Uom41

			String getUom = invoice13BillApi.parallelStream()
					.filter(e -> e.getBillingDocument().equalsIgnoreCase(filterWithBill13))
					.map(AR_Invoice_Bill_13_Dao::getBillingQuantityUnit).findFirst().orElse("");

			obj.setUom(getUom);

			// WhsCode42

			String getWhsCode = invoice13BillApi.parallelStream()
					.filter(e -> e.getBillingDocument().equalsIgnoreCase(filterWithBill13))
					.map(AR_Invoice_Bill_13_Dao::getStorageLocation).findFirst().orElse("");

			obj.setWhsCode(getWhsCode);

			// Remarks43

			String getRemarks = invoice13BillApi.parallelStream()
					.filter(e -> e.getBillingDocument().equalsIgnoreCase(filterWithBill13))
					.map(AR_Invoice_Bill_13_Dao::getBillingDocumentItemText).findFirst().orElse("");

			obj.setRemarks(getRemarks);

			// LineNum44

			String getLineNum = invoice13BillApi.parallelStream()
					.filter(e -> e.getBillingDocument().equalsIgnoreCase(filterWithBill13))
					.map(AR_Invoice_Bill_13_Dao::getBillingDocumentItem).findFirst().orElse("");

			obj.setLineNum(getLineNum);

			// cgst045

			List<AR_BILL_CGST_Dao> getCgstFilter = getCgstApi.parallelStream()
					.filter(e -> e.getBillingDocument().equalsIgnoreCase(filterWithBill13)
							&& e.getBillingDocumentItem().equalsIgnoreCase(filterBillingDocumentItem))
					.collect(Collectors.toList());

			BigDecimal getCgst0 = getCgstFilter.parallelStream()
					.map(item -> item.getCgst0() != null ? convertStringToBigDecimal(item.getCgst0()) : BigDecimal.ZERO)
					.filter(value -> value.compareTo(BigDecimal.ZERO) != 0) // Ignore zeros
					.findFirst().orElse(BigDecimal.ZERO);
			String originalCgst0 = numberFormat.format(getCgst0);
			obj.setCgst0(originalCgst0);

			// cgst25 46

			BigDecimal getCgst25 = getCgstFilter.parallelStream()
					.map(item -> item.getCgst2() != null ? convertStringToBigDecimal(item.getCgst2()) : BigDecimal.ZERO)
					.filter(value -> value.compareTo(BigDecimal.ZERO) != 0) // Ignore zeros
					.findFirst().orElse(BigDecimal.ZERO);
			String originalCgst25 = numberFormat.format(getCgst25);
			obj.setCgst25(originalCgst25);

			// cgst14 47

			BigDecimal getCgst14 = getCgstFilter.parallelStream()
					.map(item -> item.getCgst14() != null ? convertStringToBigDecimal(item.getCgst14())
							: BigDecimal.ZERO)
					.filter(value -> value.compareTo(BigDecimal.ZERO) != 0) // Ignore zeros
					.findFirst().orElse(BigDecimal.ZERO);
			String originalCgst14 = numberFormat.format(getCgst14);
			obj.setCgst14(originalCgst14);

			// cgst6 48

			BigDecimal getCgst6 = getCgstFilter.parallelStream()
					.map(item -> item.getCgst6() != null ? convertStringToBigDecimal(item.getCgst6()) : BigDecimal.ZERO)
					.filter(value -> value.compareTo(BigDecimal.ZERO) != 0) // Ignore zeros
					.findFirst().orElse(BigDecimal.ZERO);
			String originalCgst6 = numberFormat.format(getCgst6);
			obj.setCgst6(originalCgst6);

			// cgst9 49

			BigDecimal getCgst9 = getCgstFilter.parallelStream()
					.map(item -> item.getCgst9() != null ? convertStringToBigDecimal(item.getCgst9()) : BigDecimal.ZERO)
					.filter(value -> value.compareTo(BigDecimal.ZERO) != 0) // Ignore zeros
					.findFirst().orElse(BigDecimal.ZERO);

			String originalCgst9 = numberFormat.format(getCgst9);
			obj.setCgst9(originalCgst9);

			// sgst0 50

			List<AR_BILL_SGST_Dao> getSgstFilter = getSgstApi.parallelStream()
					.filter(e -> e.getBillingDocument().equalsIgnoreCase(filterWithBill13)
							&& e.getBillingDocumentItem().equalsIgnoreCase(filterBillingDocumentItem))
					.collect(Collectors.toList());

			BigDecimal getSgst0 = getSgstFilter.parallelStream()
					.map(item -> item.getSgst0() != null ? convertStringToBigDecimal(item.getSgst0()) : BigDecimal.ZERO)
					.filter(value -> value.compareTo(BigDecimal.ZERO) != 0) // Ignore zeros
					.findFirst().orElse(BigDecimal.ZERO);
			String originalSgst0 = numberFormat.format(getSgst0);
			obj.setSgst0(originalSgst0);

			// sgst25 51

			BigDecimal getSgst25 = getSgstFilter.parallelStream()
					.map(item -> item.getSgst2() != null ? convertStringToBigDecimal(item.getSgst2()) : BigDecimal.ZERO)
					.filter(value -> value.compareTo(BigDecimal.ZERO) != 0) // Ignore zeros
					.findFirst().orElse(BigDecimal.ZERO);

			String originalSgst25 = numberFormat.format(getSgst25);
			obj.setSgst25(originalSgst25);

			// sgst14 52

			BigDecimal getSgst14 = getSgstFilter.parallelStream()
					.map(item -> item.getSgst14() != null ? convertStringToBigDecimal(item.getSgst14())
							: BigDecimal.ZERO)
					.filter(value -> value.compareTo(BigDecimal.ZERO) != 0) // Ignore zeros
					.findFirst().orElse(BigDecimal.ZERO);

			String originalSgst14 = numberFormat.format(getSgst14);
			obj.setSgst14(originalSgst14);

			// sgst6 53

			BigDecimal getSgst6 = getSgstFilter.parallelStream()
					.map(item -> item.getSgst6() != null ? convertStringToBigDecimal(item.getSgst6()) : BigDecimal.ZERO)
					.filter(value -> value.compareTo(BigDecimal.ZERO) != 0) // Ignore zeros
					.findFirst().orElse(BigDecimal.ZERO);

			String originalSgst6 = numberFormat.format(getSgst6);
			obj.setSgst6(originalSgst6);

			// sgst9 54

			BigDecimal getSgst9 = getSgstFilter.parallelStream()
					.map(item -> item.getSgst9() != null ? convertStringToBigDecimal(item.getSgst9()) : BigDecimal.ZERO)
					.filter(value -> value.compareTo(BigDecimal.ZERO) != 0) // Ignore zeros
					.findFirst().orElse(BigDecimal.ZERO);
			String originalSgst9 = numberFormat.format(getSgst9);
			obj.setSgst9(originalSgst9);

			// Igst0 55

			List<AR_Bill_IGST_Dao> getIgstFilter = getIgstApi.parallelStream()
					.filter(e -> e.getDBillingDocument().equalsIgnoreCase(filterWithBill13)
							&& e.getDBillingDocumentItem().equalsIgnoreCase(filterBillingDocumentItem))
					.collect(Collectors.toList());

			BigDecimal getIgst0 = getIgstFilter.parallelStream()
					.map(item -> item.getDIGST0() != null ? convertStringToBigDecimal(item.getDIGST0())
							: BigDecimal.ZERO)
					.filter(value -> value.compareTo(BigDecimal.ZERO) != 0) // Ignore zeros
					.findFirst().orElse(BigDecimal.ZERO);
			String originalIgst0 = numberFormat.format(getIgst0);
			obj.setIgst0(originalIgst0);

			// Igst12 56

//			BigDecimal getIgst12 = getIgstFilter.stream().map(item -> convertStringToBigDecimal(item.getDIGST12()))
//					.reduce(BigDecimal.ZERO, BigDecimal::add);

			BigDecimal getIgst12 = getIgstFilter.parallelStream()
					.map(item -> item.getDIGST12() != null ? convertStringToBigDecimal(item.getDIGST12())
							: BigDecimal.ZERO)
					.filter(value -> value.compareTo(BigDecimal.ZERO) != 0) // Ignore zeros
					.findFirst().orElse(BigDecimal.ZERO);
			String originalIgst12 = numberFormat.format(getIgst12);
			obj.setIgst12(originalIgst12);

			// igst5 57

			BigDecimal getIgst5 = getIgstFilter.parallelStream()
					.map(item -> item.getDIGST5() != null ? convertStringToBigDecimal(item.getDIGST5())
							: BigDecimal.ZERO)
					.filter(value -> value.compareTo(BigDecimal.ZERO) != 0) // Ignore zeros
					.findFirst().orElse(BigDecimal.ZERO);
			String originalIgst5 = numberFormat.format(getIgst5);
			obj.setIgst5(originalIgst5);

			// igst18 58

			BigDecimal getIgst18 = getIgstFilter.parallelStream()
					.map(item -> item.getDIGST18() != null ? convertStringToBigDecimal(item.getDIGST18())
							: BigDecimal.ZERO)
					.filter(value -> value.compareTo(BigDecimal.ZERO) != 0) // Ignore zeros
					.findFirst().orElse(BigDecimal.ZERO);
			String originalIgst18 = numberFormat.format(getIgst18);
			obj.setIgst18(originalIgst18);

			// igst28 59

			BigDecimal getIgst28 = getIgstFilter.parallelStream()
					.map(item -> item.getDIGST28() != null ? convertStringToBigDecimal(item.getDIGST28())
							: BigDecimal.ZERO)
					.filter(value -> value.compareTo(BigDecimal.ZERO) != 0) // Ignore zeros
					.findFirst().orElse(BigDecimal.ZERO);
			String originalIgst28 = numberFormat.format(getIgst28);
			obj.setIgst28(originalIgst28);

		}

		Map<String, Map<String, List<AR_Invoice_13_Dao>>> datas = filteredAPData.parallelStream()
				.collect(Collectors.groupingBy(AR_Invoice_13_Dao::getCompanyCode, // Group by Company Code
						Collectors.groupingBy(AR_Invoice_13_Dao::getPlant, // Group by Plant
								Collectors.mapping(dao -> {
									AR_Invoice_13_Dao result = new AR_Invoice_13_Dao();

									// Populate result by aggregating fields from dao
									result.setInternalNumber(dao.getInternalNumber());
									result.setInternalNumber2(dao.getInternalNumber2());
									result.setInvDate(dao.getInvDate());
									result.setInvLine(dao.getInvLine());
									result.setTotalQty(dao.getTotalQty());
									result.setInvNo(dao.getInvNo());
									result.setRefNo(dao.getRefNo());
									result.setCode(dao.getCode());
									result.setCostCenter(dao.getCostCenter());
									result.setCustomerName(dao.getCustomerName());
									result.setCustomerGroup(dao.getCustomerGroup());
									result.setBillTo(dao.getBillTo());
									result.setCustomerState(dao.getCustomerState());
									result.setTin(dao.getTin());
									result.setShipToAddress(dao.getShipToAddress());
									result.setShipToState(dao.getShipToState());
									result.setGstTypeSales(dao.getGstTypeSales());
									result.setGstTin(dao.getGstTin());
									result.setItemCode(dao.getItemCode());
									result.setItemName(dao.getItemName());
									result.setHsnCode(dao.getHsnCode());
									result.setMaterialType(dao.getMaterialType());
									result.setProductCategory(dao.getProductCategory());
									result.setGstTaxCategory(dao.getGstTaxCategory());
									result.setSizeCategory(dao.getSizeCategory());
									result.setItemGroupName(dao.getItemGroupName());
									result.setLineNum(dao.getLineNum());
									result.setRemarks(dao.getRemarks());
									result.setWhsCode(dao.getWhsCode());
									result.setUom(dao.getUom());
									result.setDocumentStatusSales(dao.getDocumentStatusSales());
									result.setPairQty(dao.getPairQty());
									result.setDocumentTypeSales(dao.getDocumentTypeSales());
									result.setQuantity(dao.getQuantity());
									result.setNofPair(dao.getNofPair());
									result.setMrp(dao.getMrp());
									result.setRatePerPair(dao.getRatePerPair());
									result.setRatePerCase(dao.getRatePerCase());
									result.setBasicValue(dao.getBasicValue());
									result.setLineDiscount(dao.getLineDiscount());
									result.setHeaderDiscount(dao.getHeaderDiscount());
									result.setTotalAfterDiscount(dao.getTotalAfterDiscount());
									result.setFreight(dao.getFreight());
									result.setRoundOff(dao.getRoundOff());
									result.setNetSales(dao.getNetSales());
									result.setCgst0(dao.getCgst0());
									result.setCgst14(dao.getCgst14());
									result.setCgst25(dao.getCgst25());
									result.setCgst6(dao.getCgst6());
									result.setCgst9(dao.getCgst9());
									result.setSgst0(dao.getSgst0());
									result.setSgst14(dao.getSgst14());
									result.setSgst25(dao.getSgst25());
									result.setSgst6(dao.getSgst6());
									result.setSgst9(dao.getSgst9());
									result.setIgst0(dao.getIgst0());
									result.setIgst12(dao.getIgst12());
									result.setIgst18(dao.getIgst18());
									result.setIgst28(dao.getIgst28());
									result.setIgst5(dao.getIgst5());

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

	private BigDecimal convertStringToBigDecimal(String amount) {
		if (amount == null || amount.trim().isEmpty()) {
			return BigDecimal.ZERO;
		}
		try {
			return new BigDecimal(amount.trim());
		} catch (Exception e) {
			e.printStackTrace();
//				utilsLog.error("e,{}", e);
			return BigDecimal.ZERO;
		}
	}
}
