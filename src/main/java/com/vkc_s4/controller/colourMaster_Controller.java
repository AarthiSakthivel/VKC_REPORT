//package com.vkc_s4.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.vkc_s4.entity.colourMaster;
//import com.vkc_s4.repo.colorMasterRepository;
//import com.vkc_s4.service.colourMaster_service;
//
//@Controller
//public class colourMaster_Controller {
//	
//	@Autowired
//	colourMaster_service colourmaster_service;
//	
//	// controller returns html page
//	@GetMapping("/")
//	public String sample() {
//		return "colourMaster";//this call the coloumaster form page
//	}
//	
////	@PostMapping("/save")
////	public String save(@ModelAttribute colourMaster colMas) {
////		System.out.println(colMas);
////		colourmaster_service.save(colMas);
////		return "colourMaster";
////	}
//	@GetMapping("/getAll")
//	public String getAll() {
////		System.out.println(colourmaster_service.getAll());
////		List<colourMaster>colourmaster=colourmaster_service.getAll();
////		model.addAttribute("colourmaster",colourmaster);
//		return "colourmaster_viewall";
//	}
//}
