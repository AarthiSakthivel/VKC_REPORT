//package com.vkc_s4.restcontroller;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.mashape.unirest.http.HttpResponse;
//import com.mashape.unirest.http.exceptions.UnirestException;
//import com.vkc_s4.apiEntity.ProductDescription;
//import com.vkc_s4.apiEntity.itemMasterApi;
//import com.vkc_s4.entity.itemMaster;
//import com.vkc_s4.repo.itemMaster_Repository;
//import com.vkc_s4.service.itemMaster_Service;
//
//@RestController
////@RequestMapping("/master/inventory")
//public class itemMaster_Restcontroller {
//    @Autowired
//	itemMaster_Service itemMaster_Service;
//	@Autowired
//	itemMaster_Repository master_Repository;
//	
//	@PostMapping("/submitAll")
//	public itemMaster submitAll(@RequestBody itemMaster itemmaster) {
//		
//		System.out.println(itemmaster.getMaterialNumber().trim().length());	
////		master_Repository.save(itemmaster);
//		return itemmaster;
//	}
//	@PostMapping("/postApi")
//	public int postApi() throws UnirestException, IOException {
//		
//		List<itemMaster> filterItemMaster=master_Repository.findAll().stream().filter(e -> e.getStatus().equalsIgnoreCase("pending")).collect(Collectors.toList());
//		
//		String url="https://my409401-api.s4hana.cloud.sap/sap/opu/odata4/sap/api_product/srvd_a2x/sap/product/0002/Product";
//		String username="APIUSER";
//		String password="yQbDKShaVHVtgKBFFqaUGEnXdSSDFuDTD7fTeP~B";
//		
//		
//		for (itemMaster itemMaster : filterItemMaster) {
//			System.out.println(itemMaster);
//			itemMasterApi itemMasterApi=new itemMasterApi();
//			List<ProductDescription>listDescription=new ArrayList<>();
//			ProductDescription description=new ProductDescription();
//			itemMasterApi.setProduct(itemMaster.getMaterialNumber());
//			itemMasterApi.setProductType("ZCHE");
//			itemMasterApi.setIndustrySector("M");
//			itemMasterApi.setBaseUnit("EA");
//			itemMasterApi.setBaseISOUnit("EA");
//			itemMasterApi.setProductGroup("A001");
//			itemMasterApi.setYY1_Colurcode_PRD(itemMaster.getColourcode());
//			description.setProduct(itemMaster.getMaterialNumber());
//			description.setLanguage("EN");
//			description.setProductdescription(itemMaster.getMaterialType());
//			listDescription.add(description);
//			itemMasterApi.setProductdescription(listDescription);
//			
////			System.out.println(itemMasterApi);
//			
//			if (itemMaster_Service.convertObjecttoJsonString(itemMasterApi)!=null || itemMaster_Service.convertObjecttoJsonString(itemMasterApi)!="") {
//				
//				HttpResponse<String>response=itemMaster_Service.ApiCallForPost(url, username, password,itemMaster_Service.itemMasterGetToken() , itemMaster_Service.convertObjecttoJsonString(itemMasterApi));
//				System.out.println(response.getStatusText());
//				
//				if (response.getStatus()==201 ||response.getStatus()==200) {
//					itemMaster.setStatus("Success");
//					itemMaster.setSyncStatus("Success");
//					itemMaster_Service.updateItemMaster(itemMaster);
//				}else {
//					System.out.println("Error");
//				}
//				
//				
////				System.out.println();
//			}
//			
//		}
//		return 1;
//	}
//}
