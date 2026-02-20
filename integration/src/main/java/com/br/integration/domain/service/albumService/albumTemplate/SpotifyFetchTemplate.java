package com.br.integration.domain.service.albumService.albumTemplate;

import com.br.integration.domain.service.albumService.albumAdapter.ExternalApiClient;
import org.springframework.stereotype.Component;

@Component
public class SpotifyFetchTemplate extends FetchTemplate {

    public SpotifyFetchTemplate(ExternalApiClient apiClient) {
        super(apiClient);
    }
}
