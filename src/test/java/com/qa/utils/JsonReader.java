package com.qa.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.List;

public class JsonReader {

    @SneakyThrows
    public static List<HashMap<String, String>> getJsonDataAsMap(String path) {
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(TestResourceLoader.getResource(path),
                new TypeReference<List<HashMap<String, String>>>() {
                });
        return data;
    }
}
