package com.colpatria.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.colpatria.springboot.backend.apirest.models.entity.Region;

public interface IRegionDao extends CrudRepository<Region, Long>{

}
