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
//import com.vkc_s4.entity.sizeCategory;
//import com.vkc_s4.service.sizeCategory_service;
//
//@Controller
//public class sizeCategory_controller {
//	
//	@Autowired
//	sizeCategory_service sizecategory_service;
//	
//	@GetMapping("sizeCategory_form")
//	public String form() {//this method return sizecategory html page
//		return "sizecategory";
//	}
//	
////	@PostMapping("/sizeCategory_Save")
////	public String save(@ModelAttribute sizeCategory sizecat) {
////		sizecategory_service.save(sizecat);
////		return "sizecategory";
////	}
//	
//	@GetMapping("/sizeCategory_getAll_Controller")
//	public String getAll() {
////		model.addAttribute("sizecategory",sizecategory_service.getAll());
//		return "sizecategory_viewall";
//	}
//	
//}
