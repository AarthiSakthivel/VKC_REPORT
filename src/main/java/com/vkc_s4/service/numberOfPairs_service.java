//package com.vkc_s4.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.vkc_s4.entity.numberOfPairs;
//import com.vkc_s4.repo.numberOfPairsRepository;
//
//@Service
//public class numberOfPairs_service {
//
//	@Autowired
//	numberOfPairsRepository numberofPairsRepository;
//	
//	public String save(numberOfPairs numberofPairs) {
//		numberofPairsRepository.save(numberofPairs);
//		return "sucess";
//	}
//	
//	public List<numberOfPairs> getAll(){
//		return numberofPairsRepository.findAll();
//	}
//}
