package com.vkc_s4.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.vkc_s4.master.MasterCustomerGroupProperties;
import com.vkc_s4.master.MasterCustomerGroupTextHeader;
import com.vkc_s4.master.MasterGroupSubHeaderText;
import com.vkc_s4.master.MasterHeaderRoundOff;
import com.vkc_s4.master.MasterRegionHeaderDAO;
import com.vkc_s4.master.MasterRegionProperties;
import com.vkc_s4.master.MasterRoundOffProperties;

import lombok.RequiredArgsConstructor;

@Service

public class ThirdPartyApiCall {
	@Autowired
	private UtilsService altrocksUtils;

	
	
	
	
	
	/**
	 * YY1_AR_INVOICE_BILL_13_CDS
	 */
	
	
/**
 * YY1_VKC_REGION_CDS
 * @return
 * @throws UnirestException
 * @throws JsonMappingException
 * @throws JsonProcessingException
 */
	

	/**
	 * Date format 
	 * @param dateStr
	 * @param dateTimeFormatter
	 * @param dateFormatter
	 * @return
	 */
	public LocalDate parseDate(String dateStr, DateTimeFormatter dateTimeFormatter, DateTimeFormatter dateFormatter) {
		if (dateStr == null) {
			return null;
		}
		try {
			return LocalDate.parse(dateStr, dateTimeFormatter);
		} catch (DateTimeParseException e) {
			return LocalDate.parse(dateStr, dateFormatter);
		}
	}





	/**
	 * MasterRegion Properties
	 * @return
	 * @throws UnirestException
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */



	
	/**
	 * Master Customer Group Text
	 */
	public List<MasterCustomerGroupProperties> getMasterCustomerGroupText() throws UnirestException, JsonMappingException, JsonProcessingException {
		String masterCustomerText ="https://"+ altrocksUtils.port+"-"+"api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERACCGRPTEXT_CDS/YY1_customeraccgrptext";
		HttpResponse<String> response = altrocksUtils.ApiCall(masterCustomerText, altrocksUtils.apiUserName, altrocksUtils.apiPassword);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody());
		List<MasterCustomerGroupProperties> data = null;
		if(entryNodeArray !=null && !entryNodeArray.isEmpty())
		{
			List<MasterCustomerGroupTextHeader> entryNodes = mapper.reader()
					.forType(mapper.getTypeFactory().constructCollectionType(List.class, MasterCustomerGroupTextHeader.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}
		return data;
	}

	
	
	
	
	
	/**
	 * Master RoundOff Text
	 */
	public List<MasterRoundOffProperties> getMasterRoundOffDatas() throws UnirestException, JsonMappingException, JsonProcessingException {
		String masterRoundOff ="https://"+ altrocksUtils.port+"-"+"api.s4hana.cloud.sap/sap/opu/odata/sap/YY1_CUSTOMERWISEZPRO_API_CDS/YY1_CUSTOMERWISEZPRO_API";
		HttpResponse<String> response = altrocksUtils.ApiCall(masterRoundOff, altrocksUtils.apiUserName, altrocksUtils.apiPassword);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode entryNodeArray = altrocksUtils.XmlToJsonConversion(response.getBody());
		List<MasterRoundOffProperties> data = null;
		if(entryNodeArray !=null && !entryNodeArray.isEmpty())
		{
			List<MasterHeaderRoundOff> entryNodes = mapper.reader()
					.forType(mapper.getTypeFactory().constructCollectionType(List.class, MasterHeaderRoundOff.class))
					.readValue(entryNodeArray.toString());
			data = entryNodes.stream().map(e -> e.getContent().getProperties()).collect(Collectors.toList());
		}
		return data;
	}
	

}
