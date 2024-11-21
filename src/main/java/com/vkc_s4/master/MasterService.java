package com.vkc_s4.master;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.vkc_s4.utils.APIConstants;
import com.vkc_s4.utils.UtilsService;

@Service
//@RestController
public class MasterService {

	@Autowired
//	@Lazy
	UtilsService Utils;

	@Description("Company code  API Consume")
	// @GetMapping(value="/master/companyCode")
	public List<MasterCompanyCodePropertiesDAO> getCompanyCode()
			throws JsonMappingException, JsonProcessingException, UnirestException {
		HttpResponse<String> jsonresponse = Utils.ApiCall("https://" + Utils.port + "-" +APIConstants.masterReport.YY1VKCCompanyCode, Utils.apiUserName,
				Utils.apiPassword);
		JsonNode getJsonValues = Utils.XmlToJsonConversion(jsonresponse.getBody());
		ObjectMapper objectMapper = new ObjectMapper();
		List<MasterCompanyCodeDAO> entryNodesValues = objectMapper.reader()
				.forType(objectMapper.getTypeFactory().constructCollectionType(List.class, MasterCompanyCodeDAO.class))
				.readValue(getJsonValues.toString());

		List<MasterCompanyCodePropertiesDAO> companyCodeList = entryNodesValues.stream()
				.map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		return companyCodeList;

	}

	@Description("Plant  API Consume")
	public List<MasterPlantPropertiesDAO> getPlant()
			throws JsonMappingException, JsonProcessingException, UnirestException {
		HttpResponse<String> jsonresponse = Utils.ApiCall("https://" + Utils.port + "-" +APIConstants.masterReport.YY1VKCPlant, Utils.apiUserName,
				Utils.apiPassword);
		JsonNode getJsonValues = Utils.XmlToJsonConversion(jsonresponse.getBody());
		ObjectMapper objectMapper = new ObjectMapper();
		List<MasterPlantDAO> entryNodesValues = objectMapper.reader()
				.forType(objectMapper.getTypeFactory().constructCollectionType(List.class, MasterPlantDAO.class))
				.readValue(getJsonValues.toString());

		List<MasterPlantPropertiesDAO> plantList = entryNodesValues.stream().map(e -> e.getContent().getProperties()).distinct()
				.collect(Collectors.toList());
		return plantList;

	}

	@Description("material type API Consume")
	public List<MasterMaterialTypePropertiesDAO> getMaterialType()
			throws JsonMappingException, JsonProcessingException, UnirestException {
		HttpResponse<String> jsonresponse = Utils.ApiCall("https://" + Utils.port + "-" +APIConstants.masterReport.YY1VKCProductType,
				Utils.apiUserName, Utils.apiPassword);
		JsonNode getJsonValues = Utils.XmlToJsonConversion(jsonresponse.getBody());
		ObjectMapper objectMapper = new ObjectMapper();
		List<MasterMaterialTypeDAO> entryNodesValues = objectMapper.reader()
				.forType(objectMapper.getTypeFactory().constructCollectionType(List.class, MasterMaterialTypeDAO.class))
				.readValue(getJsonValues.toString());

		List<MasterMaterialTypePropertiesDAO> materialTypeList = entryNodesValues.stream().distinct()
				.map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		return materialTypeList;

	}

	@Description("material Group API Consume")
	// @GetMapping(value="/master/plant")
	public List<MasterMaterialGroupPropertiesDAO> getMaterialGroup()
			throws JsonMappingException, JsonProcessingException, UnirestException {
		HttpResponse<String> jsonresponse = Utils.ApiCall("https://" + Utils.port + "-" +APIConstants.masterReport.YY1VKCProductGroup,
				Utils.apiUserName, Utils.apiPassword);
		JsonNode getJsonValues = Utils.XmlToJsonConversion(jsonresponse.getBody());
		ObjectMapper objectMapper = new ObjectMapper();
		List<MasterMaterialGroupDAO> entryNodesValues = objectMapper.reader()
				.forType(
						objectMapper.getTypeFactory().constructCollectionType(List.class, MasterMaterialGroupDAO.class))
				.readValue(getJsonValues.toString());

		List<MasterMaterialGroupPropertiesDAO> materialgroupList = entryNodesValues.stream().distinct()
				.map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		return materialgroupList;

	}

	@Description("Storage Location Group API Consume")
	// @GetMapping(value="/master/plant")
	public List<MasterStorageLocationPropertiesDAO> getStorageLocation()
			throws JsonMappingException, JsonProcessingException, UnirestException {
		HttpResponse<String> jsonresponse = Utils.ApiCall("https://" + Utils.port + "-" +APIConstants.masterReport.YY1VKCStorageLocation,
				Utils.apiUserName, Utils.apiPassword);
		JsonNode getJsonValues = Utils.XmlToJsonConversion(jsonresponse.getBody());
		ObjectMapper objectMapper = new ObjectMapper();
		List<MasterStorageLocationDAO> entryNodesValues = objectMapper.reader().forType(
				objectMapper.getTypeFactory().constructCollectionType(List.class, MasterStorageLocationDAO.class))
				.readValue(getJsonValues.toString());

		List<MasterStorageLocationPropertiesDAO> materialgroupList = entryNodesValues.stream().distinct()
				.map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		return materialgroupList;

	}

	
	
	@Description(value = "Region API Consume")
	public List<RegionPropertiesDAO> regionConsume()
			throws UnirestException, JsonMappingException, JsonProcessingException {
		HttpResponse<String> jsonresponse = Utils.ApiCall(
				"https://" + Utils.port + "-" + APIConstants.masterReport.YY1VKCRegion, Utils.apiUserName,
				Utils.apiPassword);

		if (jsonresponse == null) {
			throw new RuntimeException("API call failed: response is null");
		}
		if (jsonresponse.getStatus() != 200) {
			throw new RuntimeException("API call failed with status code: " + jsonresponse.getStatus());
		}

		JsonNode getJsonValues = Utils.XmlToJsonConversion(jsonresponse.getBody());
		ObjectMapper objectMapper = new ObjectMapper();
		List<RegionDAO> entryNodesValues = objectMapper.reader()
				.forType(objectMapper.getTypeFactory().constructCollectionType(List.class, RegionDAO.class))
				.readValue(getJsonValues.toString());
		List<RegionPropertiesDAO> regionList = entryNodesValues.stream().map(e -> e.getContent().getProperties()).distinct()
				.collect(Collectors.toList());

		return regionList;

	}
	
	
	@Description(value = "Customer Group API Consume")
	public List<MasterCustomerGroupPropertiesDAO> customerGroupConsume()
			throws UnirestException, JsonMappingException, JsonProcessingException {
		HttpResponse<String> jsonresponse = Utils.ApiCall(
				"https://" + Utils.port + "-" + APIConstants.masterReport.YY1VKCCustomerGroup, Utils.apiUserName,
				Utils.apiPassword);

		if (jsonresponse == null) {
			throw new RuntimeException("API call failed: response is null");
		}
		if (jsonresponse.getStatus() != 200) {
			throw new RuntimeException("API call failed with status code: " + jsonresponse.getStatus());
		}

		JsonNode getJsonValues = Utils.XmlToJsonConversion(jsonresponse.getBody());
		ObjectMapper objectMapper = new ObjectMapper();
		List<MasterCustomerGroupDAO> entryNodesValues = objectMapper.reader()
				.forType(objectMapper.getTypeFactory().constructCollectionType(List.class, MasterCustomerGroupDAO.class))
				.readValue(getJsonValues.toString());
		List<MasterCustomerGroupPropertiesDAO> regionList = entryNodesValues.stream().map(e -> e.getContent().getProperties()).distinct()
				.collect(Collectors.toList());

		return regionList;

	}
	
	

}
