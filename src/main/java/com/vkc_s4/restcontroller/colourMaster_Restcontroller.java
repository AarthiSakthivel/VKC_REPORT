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
//import com.vkc_s4.entity.colourMaster;
//import com.vkc_s4.service.colourMaster_service;
//
//@RestController
//public class colourMaster_Restcontroller {
//	@Autowired
//	colourMaster_service colourmaster_service;
//
//	@PostMapping("/ColourMastersave")//save the object in the DB
//	public String ColourMastersave(@RequestBody colourMaster colourmaster) {
//		colourmaster.getColourcode().toUpperCase();
//		System.out.println(colourmaster);
//		colourmaster_service.save(colourmaster);
//		return "sucess";
//	}
//	
//	@GetMapping("/ColourMaster_getAll")//get all the data in the database
//	public List<colourMaster>ColourMaster_getAll(){
//		return colourmaster_service.getAll();
//	}
//}
