package com.br.integration.domain.service.albumService.albumTemplate;

import com.br.integration.domain.service.albumService.albumAdapter.ExternalApiClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.util.function.Function;

public abstract class FetchTemplate {

    protected final ExternalApiClient apiClient;
    protected final ObjectMapper objectMapper = new ObjectMapper();

    protected FetchTemplate(ExternalApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public <T> T execute(URI uri, Function<JsonNode, T> mapResponse) throws JsonProcessingException {
        String json = apiClient.get(uri);
        JsonNode root = objectMapper.readTree(json);
        return mapResponse.apply(root);
    }
}
