package com.colpatria.springboot.backend.apirest.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.colpatria.springboot.backend.apirest.RegionesApplication;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:applicationtest.properties")
@SpringBootTest(classes = RegionesApplication.class)
@AutoConfigureMockMvc
public class RegionRestControllerTest {

	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;

	@InjectMocks
	private RegionRestController regionRestController;

	private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

	@Before
	public void setup() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}

	@Test
	public void getAllRegionsBD() throws Exception {
		mvc.perform(get("/api/regiones/all").contentType(CONTENT_TYPE)
				.accept(CONTENT_TYPE)).andDo(print())
				.andExpect(jsonPath("$", hasSize(8))).andExpect(status().isOk());
	}

}
