package com.colpatria.springboot.backend.apirest.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.colpatria.springboot.backend.apirest.SpringBootBackendApirestApplication;
import com.colpatria.springboot.backend.apirest.models.entity.Region;
import com.colpatria.springboot.backend.apirest.models.services.IRegionService;
import com.colpatria.springboot.backend.apirest.testdatabuilder.RegionTestDataBuilder;

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
	private static final String CLIENT_ID = "angularapp";
	private static final String CLIENT_SECRET = "12345";
	private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

	@Before
	public void setup() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
		TOKEN = this.obtainAccessToken("admin", "12345");
	}

	private String obtainAccessToken(String username, String password) throws Exception {
		final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "password");
		params.add("client_id", CLIENT_ID);
		params.add("username", username);
		params.add("password", password);

		ResultActions result = mvc
				.perform(post("/oauth/token").params(params).with(httpBasic(CLIENT_ID, CLIENT_SECRET))
						.accept(CONTENT_TYPE))
				.andExpect(status().isOk()).andExpect(content().contentType(CONTENT_TYPE));

		String resultString = result.andReturn().getResponse().getContentAsString();

		JacksonJsonParser jsonParser = new JacksonJsonParser();
		return jsonParser.parseMap(resultString).get("access_token").toString();
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
