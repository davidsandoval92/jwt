package com.colpatria.springboot.backend.apirest.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.http.MediaType;

import com.colpatria.springboot.backend.apirest.SpringBootBackendApirestApplication;
import com.colpatria.springboot.backend.apirest.models.entity.Region;
import com.colpatria.springboot.backend.apirest.models.services.IRegionService;
import com.colpatria.springboot.backend.testdatabuilder.RegionTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootBackendApirestApplication.class)
@AutoConfigureMockMvc
public class RegionRestControllerTest {
	
	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;
	
	@MockBean
	private IRegionService regionService;

	@InjectMocks
	private RegionRestController regionRestController;
	
	private String TOKEN = "";
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}
	
	@Test
	 @WithMockUser(username = "admin", roles = {"USER", "ROLE_USER"})
	//@WithMockUser(roles={"ROLE_USER"})
//	@Test(expected = AuthenticationCredentialsNotFoundException.class)
	public void getAllRegions() throws Exception{
		List<Region> regiones = new ArrayList<Region>();
		Region regionUno = new RegionTestDataBuilder().build();
		Region regionDos = new RegionTestDataBuilder().withId(new Long(101)).withNombre("Polo Sur").build();
		regiones.add(regionUno);
		regiones.add(regionDos);
		when(regionService.findAll()).thenReturn(regiones);
		
		mvc.perform(get("/api/clientes/regiones")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
//				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].id", is(regionUno.getId())))
//				.andExpect(jsonPath("$[0].name", is(regionUno.getNombre())));
	}


}
