//package com.vkc_s4.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.vkc_s4.entity.MrpIndicator;
//import com.vkc_s4.service.MrpIndicator_service;
//
//@Controller
//public class MrpIndicator_controller {
//
//	@Autowired
//	MrpIndicator_service mrpIndicator_service;//MRPIndicator service method
//	
//	@GetMapping("/mrpIndicator_form")
//	public String form() {//this is call the mrpindicator form
//		return "mrpIndcator";
//	}
//	
//	@PostMapping("/mrpIndicator_Save")
//	public String save(@ModelAttribute MrpIndicator mrpIndi) {//MRPIndicator save method
//		System.out.println(mrpIndi);
//		mrpIndicator_service.save(mrpIndi);
//		return "mrpIndcator";
//	}
//	
//	@GetMapping("/mrpIndicator_getAll")
//	public String getAll(Model model) {//MRPIndicator getAll method
//		model.addAttribute("mrpIndicator",mrpIndicator_service.getAll());
//		return "mrpIndicator_viewall";
//	}
//}
