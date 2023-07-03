package com.pada.learnproject.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {
    public static byte[] convertObjectToJsonBytes(Object object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsBytes(object);
    }
}
