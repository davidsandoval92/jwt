package com.colpatria.springboot.backend.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colpatria.springboot.backend.apirest.models.services.IRegionService;

@RestController
@RequestMapping("api/regiones")
public class RegionRestController {
	
	@Autowired
	IRegionService regionService;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllRegions(){
		return new ResponseEntity<>(regionService.findAll(), HttpStatus.OK);		
	}

}
