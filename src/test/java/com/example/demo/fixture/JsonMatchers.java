package com.example.demo.fixture;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.util.AssertionErrors.assertEquals;

public class JsonMatchers {

    public static <T> ResultMatcher contentIsJson(Class<T> type, Object expected, String... ignoredProperties) {
        return result -> {
            assertEquals("Content type", APPLICATION_JSON_VALUE, result.getResponse().getContentType());
            assertThat("Response content", deserializeBody(type, result), samePropertyValuesAs(expected, ignoredProperties));
        };
    }

    private static <T> Object deserializeBody(Class<T> type, MvcResult result) throws Exception {
        String body = result.getResponse().getContentAsString();
        ObjectMapper om = new ObjectMapper();
        return om.readValue(body, type);
    }

}
