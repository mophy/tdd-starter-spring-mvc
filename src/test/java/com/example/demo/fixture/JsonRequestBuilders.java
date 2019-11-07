package com.example.demo.fixture;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class JsonRequestBuilders {

    public static MockHttpServletRequestBuilder postJson(String url, String body) {
        return post(url).contentType(MediaType.APPLICATION_JSON).content(body);
    }

    public static MockHttpServletRequestBuilder postJson(String url, Object body) {
        ObjectMapper om = new ObjectMapper();
        String json;
        try {
            json = om.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            json = e.getMessage();
        }
        return postJson(url, json);
    }

}
