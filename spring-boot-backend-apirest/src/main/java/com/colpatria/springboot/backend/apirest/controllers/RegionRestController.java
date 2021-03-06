package com.colpatria.springboot.backend.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.colpatria.springboot.backend.apirest.models.services.IRegionService;

@EnableCircuitBreaker
@RestController
@RequestMapping("/api/clientes")
public class RegionRestController {
	
	@Autowired
	IRegionService regionService;
	
	@Bean
	  public RestTemplate rest(RestTemplateBuilder builder) {
	    return builder.build();
	  }
	
	@Secured({"ROLE_USER"})
	@GetMapping("/regiones")
	public ResponseEntity<?> getAllRegions(){
		return new ResponseEntity<>(regionService.getRegions(), HttpStatus.OK);		
	}

}
