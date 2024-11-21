package com.vkc_s4.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.vkc_s4.master.MasterCompanyCodePropertiesDAO;
import com.vkc_s4.master.MasterMaterialGroupPropertiesDAO;
import com.vkc_s4.master.MasterMaterialTypePropertiesDAO;
import com.vkc_s4.master.MasterPlantPropertiesDAO;
import com.vkc_s4.master.MasterService;
import com.vkc_s4.master.MasterStorageLocationPropertiesDAO;

@Service
public class UtilsService {

	@Autowired
	MasterService masterService;

	@Value("${app.api.port}")
	public String port;

	@Value("${app.api.username}")
	public String apiUserName;

	@Value("${app.api.password}")
	public String apiPassword;

	@Autowired
	MasterSyncService syncService;

	@Autowired
	UtilsService Utils;

	@Description(value = "Convert XML to Json Format !!")
	public JsonNode XmlToJsonConversion(String data) throws JsonMappingException, JsonProcessingException {
		JSONObject json = XML.toJSONObject(data);
		String jsonString2 = json.toString(4);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(jsonString2);
		JsonNode entryNodeArray = rootNode.path("feed").path("entry"); // .path("feed")
		return entryNodeArray;
	}

	@Description(value = "API Authentication")
	public HttpResponse<String> ApiCall(String apiUrl, String username, String password) throws UnirestException {
		HttpResponse<String> response = Unirest.get(apiUrl).basicAuth(username, password).asString();
		return response;
	}

	@Description(value = "Seprated Comma")
	public List<String> getStringListSepratedByComma(String objList) {
		List<String> finalObjList = new ArrayList<>();
		if (!objList.isEmpty()) {
			String[] selectionList = objList.split(",");
			for (String obj : selectionList) {
				finalObjList.add(obj);
			}
		}
		return finalObjList;
	}

	public static <T, R> R getValueOrDefault(List<T> list, Predicate<T> filterCondition, Function<T, R> mapper,
			R defaultValue) {
		return Optional.ofNullable(list).flatMap(l -> l.stream().filter(filterCondition).map(mapper).findFirst())
				.orElse(defaultValue);
	}

//	@Description(value = "Convert XML to Json Format !!")
//	public JsonNode XmlToJsonConversion(String data) throws JsonMappingException, JsonProcessingException {
//		JSONObject json = XML.toJSONObject(data);
//		String jsonString2 = json.toString(4);
//
//		ObjectMapper mapper = new ObjectMapper();
//		JsonNode rootNode = mapper.readTree(jsonString2);
//		JsonNode entryNodeArray = rootNode.path("feed").path("entry"); // .path("feed")
//		return entryNodeArray;
//	}

	@Description(value = "Convert XML to Json Format !!")
	public JsonNode XmlToJsonConversionTestContent(String data) throws JsonMappingException, JsonProcessingException {
		JSONObject json = XML.toJSONObject(data);
		String jsonString2 = json.toString(4);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(jsonString2);
		JsonNode entryNodeArray = rootNode.path("feed").path("entry"); // .path("feed")
		return entryNodeArray;
	}

	public HttpResponse<String> ApiCallForPost(String apiUrl, String username, String password, String csrfToken,
			String body) throws UnirestException {
		HttpResponse<String> response = Unirest.post(apiUrl).basicAuth(username, password)
				.header("Content-Type", "application/json").header("x-csrf-token", csrfToken).body(body).asString();
		return response;
	}

	public static String extractErrorMessage(String data) throws JsonMappingException, JsonProcessingException {
		// Convert XML to JSON
		JSONObject json = XML.toJSONObject(data);
		String jsonString = json.toString(4);

		// Parse JSON string to JsonNode
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(jsonString);

		// Navigate to the error.message node
		JsonNode messageNode = rootNode.path("error").path("message").path("content");

		// Extract the message content
//   System.out.println("messageNode"+messageNode);

		String message = messageNode.asText();
//   System.out.println("Message"+message);
//   System.out.println("Message"+message);

		return message;
	}
//
//	public HttpResponse<String> ApiCall(String apiUrl, String username, String password) throws UnirestException {
//		HttpResponse<String> response = Unirest.get(apiUrl).basicAuth(username, password).asString();
//		return response;
//	}

	public static String formatThousandsSeprator(BigDecimal value) {
		if (value == null) {
			value = BigDecimal.ZERO;
		}
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
		numberFormat.setMaximumFractionDigits(2);
		numberFormat.setMinimumFractionDigits(2);

		return numberFormat.format(value);

	}

//	  public static String formatWithThousandsSeparator(BigDecimal bigDecimal) {
//	        return formatWithThousandsSeparator(BigDecimal.valueOf(bigDecimal));
//	    }
	public static double roundToTwoDecimalPlaces(double value) {
		return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}

	public static BigDecimal roundToTwoDecimalPlaces(BigDecimal value) {
		if (value == null) {
			value = BigDecimal.ZERO;
		}
		return value.setScale(2, RoundingMode.HALF_UP);
	}

//*****************************************************************************************
	// \*Veera*\
//CompanyCode
	public List<String> companyCodeSeparatedComma(String companyCode)
			throws JsonMappingException, JsonProcessingException, UnirestException {
		// Company Code
		List<String> companyCodeObjList;
		if (companyCode.contains("All")) {
			List<MasterCompanyCodePropertiesDAO> companyCodeList = masterService.getCompanyCode();
			companyCodeObjList = new ArrayList<>();
			if (companyCodeList != null && !companyCodeList.isEmpty()) {
				for (MasterCompanyCodePropertiesDAO companyCodeObj : companyCodeList) {
					companyCodeObjList.add(companyCodeObj.getDCompanyCode());
				}
			}
		} else {
			companyCodeObjList = getStringListSepratedByComma(companyCode);
		}

		return companyCodeObjList;
	}

	// --------------------------------------------------------------------------
	// Plant Code
	public List<String> plantCodeSeparatedComma(String plantCode)
			throws JsonMappingException, JsonProcessingException, UnirestException {
		List<String> plantCodeObjList;
		if (plantCode.contains("All")) {
			List<MasterPlantPropertiesDAO> plantCodeList = masterService.getPlant();
			plantCodeObjList = new ArrayList<>();
			if (plantCodeList != null && !plantCodeList.isEmpty()) {
				for (MasterPlantPropertiesDAO masterPlant : plantCodeList) {
					plantCodeObjList.add(masterPlant.getDPlant());
				}
			}
		} else {
			plantCodeObjList = getStringListSepratedByComma(plantCode);
		}
		return plantCodeObjList;
	}

	// --------------------------------------------------------------------------
	// MaterialType
	public List<String> materialTypeSeparatedComma(String materialType)
			throws JsonMappingException, JsonProcessingException, UnirestException {
		List<String> materialTypeObjList;
		if (materialType.contains("All")) {
			List<MasterMaterialTypePropertiesDAO> materialTypeLists = masterService.getMaterialType();
			materialTypeObjList = new ArrayList<>();
			if (materialTypeLists != null && !materialTypeLists.isEmpty()) {
				for (MasterMaterialTypePropertiesDAO masterWareHouse : materialTypeLists) {
					materialTypeObjList.add(masterWareHouse.getDProductType());
				}
			}
		} else {
			materialTypeObjList = getStringListSepratedByComma(materialType);
		}
		return materialTypeObjList;

	}

	// --------------------------------------------------------------------------
	// MaterialGroup
	public List<String> materialGroupSeparatedComma(String materialGroup)
			throws JsonMappingException, JsonProcessingException, UnirestException {
		List<String> materialGroupsObjList;
		if (materialGroup.contains("All")) {
			List<MasterMaterialGroupPropertiesDAO> meterialGroupsLists = masterService.getMaterialGroup();
			materialGroupsObjList = new ArrayList<>();
			if (meterialGroupsLists != null && !meterialGroupsLists.isEmpty()) {
				for (MasterMaterialGroupPropertiesDAO masterMaterialGroup : meterialGroupsLists) {
					materialGroupsObjList.add(masterMaterialGroup.getDMaterialGroup());
				}
			}
		} else {
			materialGroupsObjList = getStringListSepratedByComma(materialGroup);
		}
		return materialGroupsObjList;
	}

	// --------------------------------------------------------------------------


	// --------------------------------------------------------------------------
//Ware House
	public List<String> wareHouseSeparatedComma(String wareHouses) throws JsonMappingException, JsonProcessingException, UnirestException {

		// Ware House
		List<String> wareHousesObjList;
		if (wareHouses.contains("All")) {
			List<MasterStorageLocationPropertiesDAO> wareHouseLists = masterService.getStorageLocation();
			wareHousesObjList = new ArrayList<>();
			if (wareHouseLists != null && !wareHouseLists.isEmpty()) {
				for (MasterStorageLocationPropertiesDAO masterWareHouse : wareHouseLists) {
					wareHousesObjList.add(masterWareHouse.getDStorageLocation());
				}
			}
		} else {
			wareHousesObjList = Utils.getStringListSepratedByComma(wareHouses);
		}
		return wareHousesObjList;
	}
	
	// --------------------------------------------------------------------------	
	
//Add From Date Plus One day 	

	public Date AddFromDatePlusOneDay(Date fromDateStr) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fromDateStr);
		calendar.add(Calendar.DAY_OF_MONTH, +1);
		Date fromDatePlusOneDay = calendar.getTime();

		return fromDatePlusOneDay;
	}
	// Add To Date Plus Two day

	public Date AddToDatePlusTwoDays(Date toDateStr) {

		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(toDateStr);
		calendar1.add(Calendar.DAY_OF_MONTH, +2);
		Date toDatePlusOneDay = calendar1.getTime();

		return toDatePlusOneDay;
	}

	// --------------------------------------------------------------------------
	public String AppendPlusOneDayToDate(String dateStr) {
		// String dateString = "2023-09-21";

		// Parse the original string to a LocalDate
		LocalDate localDate = LocalDate.parse(dateStr);

		// Add one day to the LocalDate
		LocalDate nextDay = localDate.plusDays(1);

		// Convert the LocalDate to a Date
		java.util.Date date = Date.from(nextDay.atStartOfDay(ZoneId.systemDefault()).toInstant());

		// Format the resulting date as a string (optional)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// String formattedDate = sdf.format(date);

		return sdf.format(date);
	}

}
