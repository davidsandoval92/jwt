package com.colpatria.springboot.backend.apirest.models.services;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RegionServiceImpl implements IRegionService {

	private final RestTemplate restTemplate;

	public RegionServiceImpl(RestTemplate rest) {
		this.restTemplate = rest;
	}

	@HystrixCommand(fallbackMethod = "reliable")
	public String getRegions() {
		URI uri = URI.create("http://localhost:8082/api/regiones/all");
		return this.restTemplate.getForObject(uri, String.class);
	}

	public String reliable() {
		System.out.println("Entro al servicio de respaldo");
		URI uri = URI.create("http://localhost:8083/api/regiones/all");
		return this.restTemplate.getForObject(uri, String.class);
		//return "metodo de respaldo";
	}

}
