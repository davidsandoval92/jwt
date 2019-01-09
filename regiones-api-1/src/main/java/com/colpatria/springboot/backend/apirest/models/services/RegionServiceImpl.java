package com.colpatria.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colpatria.springboot.backend.apirest.models.dao.IRegionDao;
import com.colpatria.springboot.backend.apirest.models.entity.Region;

@Service
public class RegionServiceImpl implements IRegionService {

	@Autowired
	IRegionDao regionDao;
	
	public RegionServiceImpl(IRegionDao regionDao) {
		this.regionDao = regionDao;
	}

	@Override
	public List<Region> findAll() {
		return (List<Region>) regionDao.findAll();
	}

}
