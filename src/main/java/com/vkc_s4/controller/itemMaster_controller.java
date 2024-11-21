package com.vkc_s4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class itemMaster_controller {
	
	
	@GetMapping("/itemmaster")
	public String home() {
		return "itemMasterPractice";
	}
}
