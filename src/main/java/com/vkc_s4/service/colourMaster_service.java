//package com.vkc_s4.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.vkc_s4.entity.colourMaster;
//import com.vkc_s4.repo.colorMasterRepository;
//
//@Service
//public class colourMaster_service {
//
//	@Autowired
//	colorMasterRepository colourmasterRepository;
//	
//	public String save(colourMaster colourmaster) {
//		colourmasterRepository.save(colourmaster);
//		return "Success";
//	}
//	
//	public List<colourMaster> getAll(){
//		return colourmasterRepository.findAll();
//	}
//}
