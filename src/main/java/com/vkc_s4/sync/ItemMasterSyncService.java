//package com.vkc_s4.sync;
//
//import java.io.IOException;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Description;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//import com.mashape.unirest.http.HttpResponse;
//import com.mashape.unirest.http.exceptions.UnirestException;
//import com.vkc_s4.apiEntity.ProductDescription;
//import com.vkc_s4.apiEntity.itemMasterApi;
//import com.vkc_s4.entity.itemMaster;
//import com.vkc_s4.repo.itemMaster_Repository;
//import com.vkc_s4.service.itemMaster_Service;
//
//@Service
//public class ItemMasterSyncService {
//
//	@Autowired
//	itemMaster_Service itemMasterService;
//	@Autowired
//	itemMaster_Repository itemMasterRepo;
//
//	@Scheduled(fixedDelay = 10000)
//	@Description(value="Initiate the Schedular to Start the Prediction Invoices Insertion!!")
//	public int postApi() throws UnirestException, IOException {
//
//		System.out.println("Item Master Sync Initate" + new Date());
//		
//		List<itemMaster> filterItemMaster = itemMasterRepo.findAll().stream()
//				.filter(e -> e.getStatus().equalsIgnoreCase("pending")).collect(Collectors.toList());
//
//		String url = "https://my409401-api.s4hana.cloud.sap/sap/opu/odata4/sap/api_product/srvd_a2x/sap/product/0002/Product";
//		String username = "APIUSER";
//		String password = "yQbDKShaVHVtgKBFFqaUGEnXdSSDFuDTD7fTeP~B";
//
//		for (itemMaster itemMaster : filterItemMaster) {
//			itemMasterApi itemMasterApi = new itemMasterApi();
//			List<ProductDescription> listDescription = new ArrayList<>();
//			ProductDescription description = new ProductDescription();
//			itemMasterApi.setProduct(itemMaster.getMaterialNumber());
//			itemMasterApi.setProductType("ZCHE");
//			itemMasterApi.setIndustrySector("M");
//			itemMasterApi.setBaseUnit("EA");
//			itemMasterApi.setBaseISOUnit("EA");
//			itemMasterApi.setProductGroup("A001");
////			itemMasterApi.setColourCode(itemMaster.getColourcode());
////			itemMasterApi.setSizeCategory(itemMaster.getSizeCategory());
////			itemMasterApi.setSizeCombination(itemMaster.getSizeCombination());
////			itemMasterApi.setMrpIndicator(itemMaster.getMRPindicator());
////			itemMasterApi.setNumberOfPairs(itemMaster.getNumberofpairs());
////			
//			description.setProduct(itemMaster.getMaterialNumber());
//			
//			description.setLanguage("EN");
//			description.setProductdescription(itemMaster.getMaterialType());
//			listDescription.add(description);
//			itemMasterApi.setProductdescription(listDescription);
//
//			//Repost
//			if (itemMasterService.convertObjecttoJsonString(itemMasterApi) != null
//					|| itemMasterService.convertObjecttoJsonString(itemMasterApi) != "") {
//
//				HttpResponse<String> response = itemMasterService.ApiCallForPost(url, username, password,
//						itemMasterService.itemMasterGetToken(),
//						itemMasterService.convertObjecttoJsonString(itemMasterApi));
//				System.out.println(response.getStatus());
//				System.out.println(response.getBody());
//				System.out.println(response.getStatusText());
//
//				if (response.getStatus() <= 201) {
//					UpdateStatus(itemMaster,"Success",null);
//				} else {
//					System.out.println(response.getBody());
//					System.out.println(response.getStatusText());
//					UpdateStatus(itemMaster,"Failed",response.getBody());
//				}
//
//			}
//
//		}
//		return 1;
//	}
//	
//	
//	@Description(value="Update the Sync Status!!")
//	public void UpdateStatus(itemMaster itemMaster ,String status,String error) {
//		itemMaster itemObj = itemMasterRepo.getById(itemMaster.getId());
//		
//		itemObj.setStatus(status);
//		itemObj.setSyncStatus(status);
//		itemObj.setSyncError(error);
//		
//		itemMasterRepo.save(itemObj);
//	}
//	
//}
