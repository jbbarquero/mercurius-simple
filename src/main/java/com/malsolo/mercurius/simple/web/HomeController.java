package com.malsolo.mercurius.simple.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malsolo.mercurius.simple.infrastructure.actuate.MeasureService;

@RestController
public class HomeController {

	private final MeasureService measureService;

	@Autowired
	public HomeController(MeasureService service) {
		this.measureService = service;
	}

	@RequestMapping("/home")
	public String home() {
		this.measureService.call();
		return "Home";
	}
}
