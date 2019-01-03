package com.colpatria.springboot.backend.apirest.testdatabuilder;

import java.util.Date;

import com.colpatria.springboot.backend.apirest.models.entity.Cliente;

public class ClienteTestDataBuilder {

	private static final Long ID = 12345L;
	private static final String NOMBRE = "David";
	private static final String APELLIDO = "Sandoval";
	private static final String EMAIL = "david.sandoval@ceiba.com.co";
	private static final Date CREATE_AT = new Date();

	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	private Date createAt;

	public ClienteTestDataBuilder() {
		this.id = ID;
		this.nombre = NOMBRE;
		this.apellido = APELLIDO;
		this.email = EMAIL;
		this.createAt = CREATE_AT;

	}

	public ClienteTestDataBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	public ClienteTestDataBuilder withNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ClienteTestDataBuilder withApellido(String apellido) {
		this.apellido = apellido;
		return this;
	}

	public ClienteTestDataBuilder withEmail(String email) {
		this.email = email;
		return this;
	}

	public ClienteTestDataBuilder withCreateAt(Date createAt) {
		this.createAt = createAt;
		return this;
	}

	public Cliente build() {
		Cliente cliente = new Cliente(this.id, this.nombre, this.apellido, this.email, this.createAt);
		return cliente;

	}
}
