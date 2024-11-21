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
//import com.vkc_s4.entity.sizeCategory;
//import com.vkc_s4.service.sizeCategory_service;
//
//@RestController
//public class sizeCategory_RestController {
//	
//	@Autowired
//	sizeCategory_service sizecategory_service;
//	
//	@PostMapping("/sizeCategory_Save")
//	public String sizeCategory_Save(@RequestBody sizeCategory sizecategory) {
//		System.out.println(sizecategory);
//		sizecategory_service.save(sizecategory);
//		return "sucess";
//	}
//	
//	@GetMapping("/sizeCategory_getAll_RestController")
//	public List<sizeCategory>sizeCategory_getAll(){
//		return sizecategory_service.getAll();
//	}
//	
//}
