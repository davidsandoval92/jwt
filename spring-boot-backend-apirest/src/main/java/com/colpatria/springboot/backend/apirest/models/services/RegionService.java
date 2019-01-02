package com.colpatria.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.colpatria.springboot.backend.apirest.models.dao.IRegionDao;
import com.colpatria.springboot.backend.apirest.models.entity.Region;

@Service
public class RegionService implements IRegionService {

	@Autowired
	IRegionDao regionDao;

	@Override
	@Transactional(readOnly = true)
	public List<Region> findAll() {
		return (List<Region>) regionDao.findAll();
	}

}
