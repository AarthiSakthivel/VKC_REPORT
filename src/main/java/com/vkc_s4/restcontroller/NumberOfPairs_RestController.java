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
//import com.vkc_s4.entity.numberOfPairs;
//import com.vkc_s4.service.numberOfPairs_service;
//
//@RestController
//public class NumberOfPairs_RestController {
//
//	@Autowired
//	numberOfPairs_service numberofPairs_service;
//	
//	
//	@PostMapping("/numberOfPairs_save")
//	public String numberOfPairs_save(@RequestBody numberOfPairs numberofPairs) {
//		System.out.println(numberofPairs);
//		numberofPairs_service.save(numberofPairs);
//		return "success";
//	}
//	
//	@GetMapping("/numberofPairs_getAll_restController")
//	public List<numberOfPairs>numberofPairs_getAll(){
//		return numberofPairs_service.getAll();
//	}
//	
//}
