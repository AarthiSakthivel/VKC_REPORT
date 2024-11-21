//package com.vkc_s4.restcontroller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.vkc_s4.entity.sizeCombination;
//import com.vkc_s4.service.sizeCombination_service;
//
//@RestController
//public class sizeCombination_RestController {
//	
//	@Autowired
//	sizeCombination_service sizecombination_service;
//	
//	@PostMapping("/sizecombination_save")
//	public String sizeCombinationsave(@RequestBody sizeCombination sizecombination) {
//		System.out.println(sizecombination);
//		sizecombination_service.save(sizecombination);
//		return "Success";
//	}
//	
//	@GetMapping("/sizecombination_getAll_restController")//get all the data in the database
//	public List<sizeCombination>sizeCombination_getall(){
//		return sizecombination_service.getAll();
//	}
//}
