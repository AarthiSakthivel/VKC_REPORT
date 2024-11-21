//package com.vkc_s4.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.vkc_s4.entity.sizeCombination;
//import com.vkc_s4.repo.sizeCombinationRepository;
//
//@Service
//public class sizeCombination_service {
//	
//	@Autowired
//	sizeCombinationRepository sizecombinationRepository;
//	
//	public String save(sizeCombination sizeComb) {
//		sizecombinationRepository.save(sizeComb);
//		return "success";
//	}
//	
//	public List<sizeCombination> getAll(){
//		return sizecombinationRepository.findAll();
//	}
//
//}
