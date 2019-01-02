package com.colpatria.springboot.backend.apirest.controllers;


import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.colpatria.springboot.backend.apirest.SpringBootBackendApirestApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootBackendApirestApplication.class)
@AutoConfigureMockMvc
public class ClienteRestControllerTest {

	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;
	
	private String TOKEN = "";
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}
	
	@Test
	public void getAccountByEmployeeIdTest() throws Exception {
				/*mvc.perform(get("/getAccountByEmployeeId").param("employeeId", Integer.toString(account.getEmployee().getId()))
				.with(user("test").password("pass").roles("ADMIN")).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());*/			
		
	}

}
