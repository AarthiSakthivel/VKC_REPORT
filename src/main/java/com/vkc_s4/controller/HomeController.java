package com.vkc_s4.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@Value("${app.message}")
	public String message;

	
	@ResponseBody
	@GetMapping(value={"","/"})
	public String ReportStarterMessage() {
		return "VKC-S4 Reports !! " + message +" Environment!!";
		
	}
	
	
	
}
