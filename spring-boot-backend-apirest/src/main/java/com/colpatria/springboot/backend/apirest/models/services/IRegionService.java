package com.colpatria.springboot.backend.apirest.models.services;

import java.util.List;

import com.colpatria.springboot.backend.apirest.models.entity.Region;

public interface IRegionService {

	public List<Region> findAll();
}
