package com.sharebaseinc.web.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/")
	public String index(){
		
		
		return "{ \"sample\" : \"2\" }";
	}

}
