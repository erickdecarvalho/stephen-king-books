package br.com.erick.stephenkingbooks.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            JsonNode rootNode = mapper.readTree(json).get("data");
            String dataJson = mapper.writeValueAsString(rootNode);
            return mapper.readValue(dataJson, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
