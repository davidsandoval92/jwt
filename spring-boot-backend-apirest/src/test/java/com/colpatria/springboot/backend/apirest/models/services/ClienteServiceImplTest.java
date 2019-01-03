package com.colpatria.springboot.backend.apirest.models.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.colpatria.springboot.backend.apirest.models.dao.IClienteDao;
import com.colpatria.springboot.backend.apirest.models.entity.Cliente;
import com.colpatria.springboot.backend.apirest.testdatabuilder.ClienteTestDataBuilder;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

public class ClienteServiceImplTest {

	@Mock
	private IClienteDao clienteDao;

	@Before
	public void setup() {
		clienteDao = mock(IClienteDao.class);
	}

	@Test
	public void obtenerClientes() {
		// Arrange
		List<Cliente> clientesResponse = new ArrayList<>();
		Cliente cliente1 = new ClienteTestDataBuilder().withId(123L).build();
		Cliente cliente2 = new ClienteTestDataBuilder().withId(456L).build();
		Cliente cliente3 = new ClienteTestDataBuilder().withId(789L).build();
		Cliente cliente4 = new ClienteTestDataBuilder().build();
		clientesResponse.add(cliente1);
		clientesResponse.add(cliente2);
		clientesResponse.add(cliente3);
		clientesResponse.add(cliente4);
		when(clienteDao.findAll()).thenReturn(clientesResponse);
		// Act
		clientesResponse = (List<Cliente>) clienteDao.findAll();
		// Assert
		assertEquals(4, clientesResponse.size());
	}

}
