//package com.vkc_s4.service;
//
//import java.util.List;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.vkc_s4.entity.MrpIndicator;
//
//import com.vkc_s4.repo.MrpIndicatorRepository;
//
//@Service
//public class MrpIndicator_service {
//
//	@Autowired
//	MrpIndicatorRepository mrpIndicatorRepository;
//	
//	public String save(MrpIndicator mrpIndi) {
//		mrpIndicatorRepository.save(mrpIndi);
//		return "Success";
//	}
//	
//	public List<MrpIndicator> getAll(){
//		return mrpIndicatorRepository.findAll();
//	}
//	
//	
//}
