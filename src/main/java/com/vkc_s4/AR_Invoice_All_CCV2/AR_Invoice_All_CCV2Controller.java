package com.vkc_s4.AR_Invoice_All_CCV2;

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

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value = "/vkc/reports")
@RequiredArgsConstructor
public class AR_Invoice_All_CCV2Controller {

	
	
	@Autowired 
	AR_Invoice_All_CCV2Service  aR_Invoice_All_CCV2Service;
	
	@GetMapping(value = { "/ar-invoice-inallcc"})
	public String getReport(Model model) throws Exception {
		
		List<AR_Invoice_All_CompanyCodeDao> companyCodes =  aR_Invoice_All_CCV2Service.getCompanyCodeApiDetails();
		List<AR_Invoice_All_PlantCodeDao> plantCodes = aR_Invoice_All_CCV2Service.getPlantCodeApiDetails();
		
		model.addAttribute("companyCode", companyCodes);
		model.addAttribute("plantcode", plantCodes);	
		return "AR_Invoice_ALL_CC"; 

	}
	
	@GetMapping(value = {"/ar-invoice-inallcc/filter"})
    public String getFilterDataReport (@RequestParam(defaultValue = "") String fromDate,
			@RequestParam(defaultValue = "") String toDate, Model model,
			@RequestParam(defaultValue = "") String companyCode, @RequestParam(defaultValue = "") String plant) throws Exception {
		
		try {
			
			List<AR_Invoice_All_CompanyCodeDao> companyCodesList =  aR_Invoice_All_CCV2Service.getCompanyCodeApiDetails();
			List<AR_Invoice_All_PlantCodeDao> plantCodesList = aR_Invoice_All_CCV2Service.getPlantCodeApiDetails();
		
		model.addAttribute("fromDate", fromDate); 
		model.addAttribute("toDate", toDate);
		
		Map<String, Map<String, List<AR_Invoice_13_Dao>>> dataFilter = aR_Invoice_All_CCV2Service.datefilter(fromDate, toDate,
		        companyCode, plant);

		List<AR_Invoice_13_Dao> primaryItemList = new ArrayList<>();
		for (Map<String, List<AR_Invoice_13_Dao>> innerMap : dataFilter.values()) {
		    for (List<AR_Invoice_13_Dao> daoList : innerMap.values()) {
		        primaryItemList.addAll(daoList); // Add all AR_Invoice_13_Dao objects from each list
		    }
		}
		//System.out.println("dateFilter : "+dateFilter);
		model.addAttribute("filteredList", dataFilter);
		model.addAttribute("companyCode", companyCodesList);
		model.addAttribute("plant", plantCodesList);
		model.addAttribute("primaryItemList", primaryItemList);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return "AR_Invoice_ALL_CC";
    } 
	
	@PostMapping("/getPlantCodewiseDetails")
	public ResponseEntity<List<AR_Invoice_All_PlantCodeDao>> getPlants(@RequestBody List<String> companyCodes)
			throws Exception {

		if (companyCodes == null || companyCodes.isEmpty()) {
			return ResponseEntity.ok(List.of()); // Return an empty list if no company codes are provided
		}

		List<AR_Invoice_All_PlantCodeDao> plantList = aR_Invoice_All_CCV2Service.getPlantCodeApiDetails();

		// Filter plants based on company codes
		List<AR_Invoice_All_PlantCodeDao> filteredPlants = plantList.stream()
				.filter(plant -> companyCodes.contains(plant.getDCompanyCode())).collect(Collectors.toList());

		// System.out.println("Filtered Plants: " + filteredPlants);
		return ResponseEntity.ok(filteredPlants);
	} 
}
