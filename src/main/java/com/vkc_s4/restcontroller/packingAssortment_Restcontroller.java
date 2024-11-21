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
//import com.vkc_s4.entity.packingAssortment;
//import com.vkc_s4.service.packingAssortment_service;
//
//@RestController
//public class packingAssortment_Restcontroller {
//	
//	@Autowired
//	packingAssortment_service packingassortment_service;
//	
//	@PostMapping("/packingassortment_save_restcontroller")
//	public String packingassortment_save(@RequestBody packingAssortment packingassortment) {
//		System.out.println(packingassortment);
//		packingassortment_service.save(packingassortment);
//		return "success";
//	}
//	
//	
//	
//	@GetMapping("packingassortment_getAll_restcontroller")
//	public List<packingAssortment>packingassortment_getAll(){
//		return packingassortment_service.getAll();
//	}
//}
