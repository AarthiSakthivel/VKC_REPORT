//package com.vkc_s4.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.vkc_s4.entity.sizeCombination;
//import com.vkc_s4.service.MrpIndicator_service;
//import com.vkc_s4.service.sizeCombination_service;
//
//@Controller
//public class sizeCombination_controller {
//	
//	@Autowired
//	sizeCombination_service sizecombination_service;
//	
//	@GetMapping("/sizecombination_Form")
//	public String form() {//this method return sizecombination html page
//		return"sizecombination";
//	}
//	
////	@PostMapping("/sizecombination_save")
////	public String save(@ModelAttribute sizeCombination sizeComb) {
////		sizecombination_service.save(sizeComb);
////		return "sizecombination";
////		
////	}
////	
//	@GetMapping("/sizecombination_getAll_controller")
//	public String getAll(){
////		model.addAttribute("sizecombination",sizecombination_service.getAll());
//		return "sizecombination_viewall";
//	}
//	
//	
//}
