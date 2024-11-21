//package com.vkc_s4.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.vkc_s4.entity.numberOfPairs;
//import com.vkc_s4.service.numberOfPairs_service;
//
//@Controller
//public class numberOfPairs_controller {
//	
//	@Autowired
//	numberOfPairs_service numberofPairs_service;
//	
//	@GetMapping("/numberofPairs_form")
//	public String form() { //this method return numberofPairs html page
//		return"numberOfPairs";
//		
//	}
//	
//	
//	@PostMapping("/numberofPairs_save")
//	public String save(@ModelAttribute numberOfPairs numberofPairs) {//Save numberofPairs method
//		System.out.println(numberofPairs);
//		numberofPairs_service.save(numberofPairs);
//		return "numberOfPairs";
//	}
//	
//	@GetMapping("/numberofPairs_getAll")
//	public String getAll() {//getAll Object numberofPairs method
//		/* model.addAttribute("numberOfPairs",numberofPairs_service.getAll()); */
//		return "numberOfPairs_viewall";//retrun numberOfPairs_viewall html page
//	}
//
//}
