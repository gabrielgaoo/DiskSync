package com.br.integration.domain.service.albumService.albumAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class SpotifyApiClientImpl implements ExternalApiClient {

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private String accessToken;

    @Override
    public String get(URI uri) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken != null ? accessToken.trim() : "");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(uri, HttpMethod.GET, entity, String.class).getBody();
    }
}
