package com.colpatria.springboot.backend.apirest.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ToolsUtils {
	public String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
