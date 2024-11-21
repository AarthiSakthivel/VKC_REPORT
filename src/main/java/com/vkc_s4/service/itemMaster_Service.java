//package com.vkc_s4.service;
//
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.xml.XmlMapper;
//import com.mashape.unirest.http.HttpResponse;
//import com.mashape.unirest.http.Unirest;
//import com.mashape.unirest.http.exceptions.UnirestException;
//import com.vkc_s4.apiEntity.itemMasterApi;
//import com.vkc_s4.entity.itemMaster;
//import com.vkc_s4.repo.ItemMasterRepository;
//
//@Service
//public class itemMaster_Service {
//
//	@Autowired
//	ItemMasterRepository itemMasterRepository;
//
//	public String itemMasterSave(itemMaster master) {
//		itemMaster ItemMasterObj = itemMasterRepository.save(master);
//		System.out.println(ItemMasterObj);
//		return ItemMasterObj.getArticlenumber();
//	}
//
//	public String itemMasterGetToken() throws UnirestException, IOException {
//
//		String url = "https://my409401-api.s4hana.cloud.sap/sap/opu/odata4/sap/api_product/srvd_a2x/sap/product/0002/Product";
//		String username = "APIUSER";
//		String password = "yQbDKShaVHVtgKBFFqaUGEnXdSSDFuDTD7fTeP~B";
////		String response = Unirest.get(url).basicAuth(username, password)
////		.header("x-csrf-token","fetch");
//
//		HttpResponse<String> response = Unirest.get(url).basicAuth(username, password).header("x-csrf-token", "fetch")
//				.asString();
//		String Token = response.getHeaders().getFirst("x-csrf-token");
//
//		return Token;
//	}
//
//	public JsonNode ConvertXmlToJson(String response) throws IOException {
//
//		XmlMapper xmlMapper = new XmlMapper();
//		JsonNode mapper = xmlMapper.readTree(response);
//		JsonNode resApi = mapper.path("entry");
//
//		System.out.println(resApi);
//
//		return resApi;
//	}
//
//	public HttpResponse<String> ApiCallForPost(String apiUrl, String username, String password, String csrfToken,
//			String body) throws UnirestException {
//		HttpResponse<String> response = Unirest.post(apiUrl).basicAuth(username, password).header("Content-Type", "application/json")
//				.header("x-csrf-token", csrfToken).body(body).asString();
//		return response;
//	}
//
//	public String convertObjecttoJsonString(itemMasterApi api) {
//
//		ObjectMapper mapper = new ObjectMapper();
//		
////		System.out.println(api);
//		try {
//			String json = mapper.writeValueAsString(api);
//			System.out.println(json);
//			return json;
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	public String updateItemMaster(itemMaster master) {
//		if (itemMasterRepository.existsById(master.getId())) {
//			itemMasterRepository.save(master);
//		}
//		return null;
//	}
//
//}
