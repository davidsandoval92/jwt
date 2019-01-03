package com.colpatria.springboot.backend.testdatabuilder;

import com.colpatria.springboot.backend.apirest.models.entity.Region;

public class RegionTestDataBuilder {

	private static final Long ID = new Long(100);
	private static final String NOMBRE = "Polo Norte";

	private Long id;
	private String nombre;

	public RegionTestDataBuilder() {
		this.id = ID;
		this.nombre = NOMBRE;
	}

	public RegionTestDataBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	public RegionTestDataBuilder withNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public Region build() {
		Region region = new Region(this.id, this.nombre);
		return region;
	}

}