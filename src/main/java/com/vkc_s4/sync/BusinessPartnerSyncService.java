//package com.vkc_s4.sync;
//
//import java.io.IOException;
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.json.JSONObject;
//import org.json.XML;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Description;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.mashape.unirest.http.HttpResponse;
//import com.mashape.unirest.http.exceptions.UnirestException;
//import com.vkc_s4.businesspartner.businessPartnerApi;
//import com.vkc_s4.businesspartner.businessPartnerEntity;
//import com.vkc_s4.businesspartner.businessPartnerRepository;
//import com.vkc_s4.businesspartner.businessPartnerService;
//import com.vkc_s4.utils.utilService;
//
//@Service
//public class BusinessPartnerSyncService {
//
//	@Autowired
//	businessPartnerRepository businessPartnerRepository;
//
//	@Autowired
//	businessPartnerService businessPartnerService;
//	
//	@Autowired
//	utilService Utils;
//
//	@Scheduled(fixedDelay = 10000)
//	public int postBusinessPartnerApi() throws UnirestException, IOException {
//
//		System.out.println("Business Master Sync Initate" + new Date());
//		
//		List<businessPartnerEntity> businessPartnerEntities = businessPartnerRepository.findAll().stream()
//				.filter(e -> e.getSyncStatus().equalsIgnoreCase("Pending")).collect(Collectors.toList());
//
//		String url = "https://my409401-api.s4hana.cloud.sap/sap/opu/odata/sap/API_BUSINESS_PARTNER/A_BusinessPartner";
//		String username = "CUSTOM_ARJUN_INTEGRATION";
//		String password = "omcWEBVRNilMJxqHdYCpvtFfm5rEtijFV/SKFaxm";
//
//		for (businessPartnerEntity businessPartnerEntity : businessPartnerEntities) {
//
//			businessPartnerApi businessPartnerApi = new businessPartnerApi();
//
//			businessPartnerApi.setBusinessPartner(businessPartnerEntity.getCode());
//			businessPartnerApi.setLastName(businessPartnerEntity.getName());
//			businessPartnerApi.setIsMale(true);
//			businessPartnerApi.setBusinessPartnerCategory("1");
//
//			if (convertObjecttoJsonString(businessPartnerApi) != null
//					|| convertObjecttoJsonString(businessPartnerApi) != "") {
//
//				String token = businessPartnerService.businessMasterGetToken();
//
//				HttpResponse<String> response = Utils.ApiCallForPost(url, username, password, token,
//						convertObjecttoJsonString(businessPartnerApi));
//				
////				System.out.println(response.getStatus());
////				System.out.println(response.getBody());
////				System.out.println(response.getStatusText());
//				
//				if (response.getStatus()<=201) {
//					businessPartnerService.UpdateStatus(businessPartnerEntity, "Success",null );			
//				}else {
//					System.out.println(response.getBody());
//					System.out.println(response.getStatusText());
////					System.out.println();
////					businessPartnerService.extractErrorMessage()
//					
//					businessPartnerService.UpdateStatus(businessPartnerEntity, "Failed", Utils.extractErrorMessage(response.getBody()));
//				}
//				
//
//			}
//
//		}
//
//		return 0;
//
//	}
//
//
//
//	public static String convertObjecttoJsonString(businessPartnerApi api) {
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
//	
//
//}
