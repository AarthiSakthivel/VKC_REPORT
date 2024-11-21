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
//import com.vkc_s4.entity.MrpIndicator;
//import com.vkc_s4.service.MrpIndicator_service;
//
//@RestController
//public class MrpIndicator_RestController {
//	@Autowired
//	MrpIndicator_service Mrpindicator_service;
//	
//	
//	@PostMapping("/mrpindicator_save")//save the data to the DB using Ajax
//	public String mrpindicator_save(@RequestBody MrpIndicator Mrpindicator) {
//		System.out.println(Mrpindicator);
//		Mrpindicator_service.save(Mrpindicator);
//		return null;
//	}
//	
//	
//	@GetMapping("/mrpindicator_getAll_restController")//get all the data in the DB
//	public List<MrpIndicator>Mrpindicator_getAll_restController(){	
//		return Mrpindicator_service.getAll();
//	}
//}
