package com.colpatria.springboot.backend.apirest.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.colpatria.springboot.backend.apirest.SpringBootBackendApirestApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootBackendApirestApplication.class)
@AutoConfigureMockMvc
@TestPropertySource( locations = "classpath:applicationtest.properties")
public class ClienteRestControllerTest {

	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;
	
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

        // @formatter:off

        ResultActions result = mvc.perform(post("/oauth/token")
                               .params(params)
                               .with(httpBasic(CLIENT_ID, CLIENT_SECRET))
                               .accept(CONTENT_TYPE))
                               .andExpect(status().isOk())
                               .andExpect(content().contentType(CONTENT_TYPE));        
        

        String resultString = result.andReturn().getResponse().getContentAsString();

        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(resultString).get("access_token").toString();
    }
	@Test
    public void given_clientes_without_token() throws Exception {
		mvc.perform(get("/clientes")).andExpect(status().isUnauthorized());
    }
	
	@Test
    public void given_clientes_ok() throws Exception {      

        // @formatter:off        
        mvc.perform(get("/api/clientes")
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(CONTENT_TYPE)              
                .accept(CONTENT_TYPE))      
        		.andDo(print())
        		.andExpect(jsonPath("$", hasSize(12)))
                .andExpect(status().isOk());  
    }
}
