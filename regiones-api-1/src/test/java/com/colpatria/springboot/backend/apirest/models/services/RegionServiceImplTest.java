package com.colpatria.springboot.backend.apirest.models.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.colpatria.springboot.backend.apirest.models.dao.IRegionDao;
import com.colpatria.springboot.backend.apirest.models.entity.Region;
import com.colpatria.springboot.backend.apirest.testdatabuilder.RegionTestDataBuilder;

public class RegionServiceImplTest {
	@Mock
	private IRegionDao regionDao;
	
	private RegionServiceImpl regionService;
	
	@Before
	public void setup() {
		regionDao = mock(IRegionDao.class);
		regionService = new RegionServiceImpl(regionDao);
	}
	
	@Test
	public void findAll() {
		List<Region> response = new ArrayList<Region>();
		List<Region> regiones = new ArrayList<Region>();
		Region regionUno = new RegionTestDataBuilder().build();
		Region regionDos = new RegionTestDataBuilder().withId(101).withNombre("Polo Sur").build();
		regiones.add(regionUno);
		regiones.add(regionDos);
		when(regionDao.findAll()).thenReturn(regiones);
		
		response = regionService.findAll();
		
		assertEquals(regiones.size(), response.size());
	}

}
