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
import java.util.Optional;

public class ClienteServiceImplTest {

	@Mock
	private IClienteDao clienteDao;
	
	private ClienteServiceImpl clienteServiceImpl;

	@Before
	public void setup() {
		clienteDao = mock(IClienteDao.class);
		clienteServiceImpl = new ClienteServiceImpl(clienteDao);
	}

	@Test
	public void findAll() {
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
		clientesResponse = (List<Cliente>) clienteServiceImpl.findAll();
		// Assert
		assertEquals(4, clientesResponse.size());
	}

	@Test
	public void findById() {
		// Arrange
		Cliente clienteResponse;
		Cliente cliente = new ClienteTestDataBuilder().withApellido("Homero").build();

		Optional<Cliente> client = Optional.of(cliente);

		when(clienteDao.findById(123L)).thenReturn(client);
		// Act
		clienteResponse = clienteServiceImpl.findById(123L);
		// Assert
		assertEquals("David", clienteResponse.getNombre());
		assertEquals("Homero", clienteResponse.getApellido());
	}

	@Test
	public void save() {
		// Arrange
		Cliente clienteResponse;
		Cliente cliente = new ClienteTestDataBuilder().withApellido("Homero").withEmail("homero@ceiba.com.co").build();

		when(clienteDao.save(cliente)).thenReturn(cliente);
		// Act
		clienteResponse = clienteServiceImpl.save(cliente);
		// Assert
		assertEquals("homero@ceiba.com.co", clienteResponse.getEmail());
		assertEquals("Homero", clienteResponse.getApellido());
	}

}
