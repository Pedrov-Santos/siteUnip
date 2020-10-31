package com.unip.pim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
	
	@RequestMapping
	private String home() {
		
		return "Home";
	}

	@RequestMapping(value = "/acao")
	private String acoes() {
		
		return "Acaoes";
	}
	
	@RequestMapping(value = "/somos")
	private String quemSomos() {
		
		return "QuemSomos";
	}
}
