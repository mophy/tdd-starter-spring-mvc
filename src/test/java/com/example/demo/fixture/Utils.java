package com.example.demo.fixture;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.ResultActions;

import java.io.UnsupportedEncodingException;

public class Utils {

    public static <T> T deserializeBody(ResultActions result, Class<T> type) throws UnsupportedEncodingException, JsonProcessingException {
        return new ObjectMapper().readValue(result.andReturn().getResponse().getContentAsString(), type);
    }

}
