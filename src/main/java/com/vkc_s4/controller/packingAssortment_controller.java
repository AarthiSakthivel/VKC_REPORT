//package com.vkc_s4.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.vkc_s4.entity.packingAssortment;
//import com.vkc_s4.service.packingAssortment_service;
//
//@Controller
//public class packingAssortment_controller {
//
//	@Autowired
//	packingAssortment_service packingassortment_service;
//	
//	@GetMapping("/packingassortment_form")
//	public String form() {//this method return packingassortment html page
//		return "packingassortment";
//		
//	}
//	
//	
//	
//	@PostMapping("/packingassortment_save")
//	public String save(@ModelAttribute packingAssortment packingassortment) {//this method save the packingassortment object in the DB
//		packingassortment_service.save(packingassortment);
//		return "packingassortment";
//	}
//	
//	@GetMapping("/packingassortment_getAll")
//	public String getAll(Model model) {//this method getAll packingassortment object in the DB
//		model.addAttribute("packingassortment",packingassortment_service.getAll());
//		return "packingassortment_viewall";
//	}
//	
//	
//	
//}
