package com.colpatria.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colpatria.springboot.backend.apirest.models.entity.Cliente;
import com.colpatria.springboot.backend.apirest.models.entity.Region;
import com.colpatria.springboot.backend.apirest.models.services.IRegionService;

@RestController
@RequestMapping("/api/clientes")
public class RegionRestController {
	
	@Autowired
	IRegionService regionService;
	
	@Secured({"ROLE_USER"})
	@GetMapping("/regiones")
	public ResponseEntity<?> getAllRegions(){
		return new ResponseEntity<>(regionService.findAll(), HttpStatus.OK);		
	}

}
