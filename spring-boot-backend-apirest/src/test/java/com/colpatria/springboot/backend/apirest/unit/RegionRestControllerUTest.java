package com.colpatria.springboot.backend.apirest.unit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.colpatria.springboot.backend.apirest.SpringBootBackendApirestApplication;
import com.colpatria.springboot.backend.apirest.controllers.RegionRestController;
import com.colpatria.springboot.backend.apirest.models.entity.Region;
import com.colpatria.springboot.backend.apirest.models.services.IRegionService;
import com.colpatria.springboot.backend.apirest.testdatabuilder.RegionTestDataBuilder;
import com.colpatria.springboot.backend.apirest.util.TokenGenerator;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:applicationtest.properties")
@SpringBootTest(classes = SpringBootBackendApirestApplication.class)
@AutoConfigureMockMvc
public class RegionRestControllerUTest {

	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;

	@MockBean
	private IRegionService regionService;

	@InjectMocks
	private RegionRestController regionRestController;

	private String TOKEN = "";
	private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

	@Before
	public void setup() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
		TOKEN = TokenGenerator.obtainAccessToken("admin", "12345", mvc);
	}

	@Test
	public void getAllRegions() throws Exception {
		List<Region> regiones = new ArrayList<Region>();
		Region regionUno = new RegionTestDataBuilder().build();
		Region regionDos = new RegionTestDataBuilder().withId(101).withNombre("Polo Sur").build();
		regiones.add(regionUno);
		regiones.add(regionDos);
		when(regionService.findAll()).thenReturn(regiones);

		mvc.perform(get("/api/clientes/regiones").header("Authorization", "Bearer " + TOKEN).contentType(CONTENT_TYPE)
				.accept(CONTENT_TYPE)).andDo(print()).andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].id", is(regionUno.getId()))).andExpect(status().isOk());
	}

	@Test
	public void getAllRegionsUnauthorized() throws Exception {
		List<Region> regiones = new ArrayList<Region>();
		Region regionUno = new RegionTestDataBuilder().build();
		regiones.add(regionUno);
		when(regionService.findAll()).thenReturn(regiones);

		mvc.perform(get("/api/clientes/regiones").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isUnauthorized());
	}

}
