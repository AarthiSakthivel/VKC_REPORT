package com.vkc_s4.CustWiseBrandWiseReport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vkc_s4.AR_Invoice_All_CCV2.AR_Invoice_13_Dao;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value = "/vkc/reports")
@RequiredArgsConstructor
public class CustWiseBrandWiseReportController {

	@Autowired CustomWiseBrandWiseService customWiseBrandWiseService ;
	
	@GetMapping(value = { "/sales-creditmemo"}) 
	public String getReport(Model model) throws Exception {
	List<CustCompanyCodeDao> companyCodes = customWiseBrandWiseService.CustCompanyCodeApiDetails();
	List<CustPlantCodeDao> plantCodes = customWiseBrandWiseService.custPlantCodeApiDetails();
	List<CustMaterialTypeDao> materialType = customWiseBrandWiseService.custMaterialTypeApiDetails();
	List<CustMaterialGroupDao> materialGroup = customWiseBrandWiseService.custMaterialGroupApiDetails();
	
	model.addAttribute("companyCode", companyCodes);
	model.addAttribute("plantcode", plantCodes);
	model.addAttribute("materialTypes", materialType);
	model.addAttribute("materialGroups", materialGroup);		
			
	return "Brandwisesalesandcredit.html"; 

}
	@GetMapping(value = {"/sales-creditmemo/filter"})
    public String getFilterDataReport (@RequestParam(defaultValue = "") String fromDate,
			@RequestParam(defaultValue = "") String toDate, Model model,
			@RequestParam(defaultValue = "") String companyCode, @RequestParam(defaultValue = "") String plant,
			@RequestParam(defaultValue = "") String materialType, @RequestParam(defaultValue = "") String materialGroup) throws Exception {
		
		try {
		List<CustWiseBillInDao> getmMltiDbItemWisecreditnote = customWiseBrandWiseService.custWiseBillingAPIDetails();	
		List<CustCompanyCodeDao> companyCodeList = customWiseBrandWiseService.CustCompanyCodeApiDetails();
		List<CustPlantCodeDao> plantList = customWiseBrandWiseService.custPlantCodeApiDetails();
		List<CustMaterialTypeDao> materialTypelist = customWiseBrandWiseService.custMaterialTypeApiDetails();
		List<CustMaterialGroupDao> materialGrouplist = customWiseBrandWiseService.custMaterialGroupApiDetails();
		
		model.addAttribute("fromDate", fromDate); 
		model.addAttribute("toDate", toDate);
		
		Map<String, Map<String, List<CustWiseBillInDao>>> dateFilter = customWiseBrandWiseService.datefilter(fromDate, toDate,
				companyCode, plant, materialType, materialGroup);
		
		List<CustWiseBillInDao> primaryItemList = new ArrayList<>();
		for (Map<String, List<CustWiseBillInDao>> innerMap : dateFilter.values()) {
		    for (List<CustWiseBillInDao> daoList : innerMap.values()) {
		        primaryItemList.addAll(daoList); // Add all AR_Invoice_13_Dao objects from each list
		    }
		}
		//System.out.println("dateFilter : "+dateFilter);
		model.addAttribute("filterList", dateFilter);
		model.addAttribute("companyCode", companyCodeList);
		model.addAttribute("plant", plantList);
		model.addAttribute("materialType", materialTypelist);
		model.addAttribute("materialGroup", materialGrouplist);
		model.addAttribute("primaryItemList", primaryItemList);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return "Brandwisesalesandcredit.html";
    }	
	@PostMapping("/getPlantwiseDetails")
	public ResponseEntity<List<CustPlantCodeDao>> getPlants(@RequestBody List<String> companyCodes)
			throws Exception {

		if (companyCodes == null || companyCodes.isEmpty()) {
			return ResponseEntity.ok(List.of()); // Return an empty list if no company codes are provided
		}

		List<CustPlantCodeDao> plantList = customWiseBrandWiseService.custPlantCodeApiDetails();
 
		// Filter plants based on company codes
		List<CustPlantCodeDao> filteredPlants = plantList.stream()
				.filter(plant -> companyCodes.contains(plant.getDCompanyCode())).collect(Collectors.toList());

		// System.out.println("Filtered Plants: " + filteredPlants);
		return ResponseEntity.ok(filteredPlants);
	}
	
//	@PostMapping("/getMaterialGroupDetails")
//	public ResponseEntity<List<CustMaterialGroupDao>> getMaterialGroup(@RequestBody List<String> companyCodes, @RequestBody List<String> plantCodes)
//			throws Exception {
//
//		if ((companyCodes == null || companyCodes.isEmpty()) || (plantCodes == null || plantCodes.isEmpty())) {
//			return ResponseEntity.ok(List.of()); // Return an empty list if no company codes are provided
//		}
//
//		List<CustMaterialGroupDao> materialGroupList = customWiseBrandWiseService.custMaterialGroupApiDetails();
// 
//		// Filter plants based on company codes
//		List<CustMaterialGroupDao> filteredMaterialGroup = materialGroupList.stream()
//				.filter(plant -> companyCodes.contains(plant.getDCompanyCode())).collect(Collectors.toList());
//
//		// System.out.println("Filtered Plants: " + filteredPlants);
//		return ResponseEntity.ok(filteredMaterialGroup);
//	}
	
}
