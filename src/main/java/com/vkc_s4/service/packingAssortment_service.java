//package com.vkc_s4.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.vkc_s4.entity.packingAssortment;
//import com.vkc_s4.repo.packingAssortmentRepository;
//
//@Service
//public class packingAssortment_service {
//	
//	@Autowired
//	packingAssortmentRepository packingassortmentRepository;
//	
//	public String save(packingAssortment packingassortment) {
//		packingassortmentRepository.save(packingassortment);
//		return "success";
//		
//	}
//	
//	public List<packingAssortment> getAll(){
//		return packingassortmentRepository.findAll();
//	}
//	
//	
//	
//	
//}
