package org.selenium.pom.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {
    public static <T> T deserializeJson(String filepath, Class<T> T)  {
        InputStream is = JacksonUtils.class.getClassLoader().getResourceAsStream(filepath);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(is,T);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
