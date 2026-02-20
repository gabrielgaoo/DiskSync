package com.br.integration.domain.service.albumService;

import com.br.integration.domain.dto.AlbumDTO;
import com.br.integration.domain.dto.AlbumDTODetails;
import com.br.integration.domain.exception.albumException.AlbumNotFoundException;
import com.br.integration.domain.exception.albumException.AlbumSearchException;
import com.br.integration.domain.service.albumService.albumStrategy.albumMapperStrategy.AlbumMapperStrategy;
import com.br.integration.domain.service.albumService.albumTemplate.FetchTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class AlbumService {

    private static final String SPOTIFY_ALBUM_BASE = "https://api.spotify.com/v1/albums/";
    private static final String SPOTIFY_SEARCH_BASE = "https://api.spotify.com/v1/search";

    private final FetchTemplate fetchTemplate;
    private final AlbumMapperStrategy<JsonNode, AlbumDTODetails> detailsMapper;
    private final AlbumMapperStrategy<JsonNode, List<AlbumDTO>> listMapper;

    public AlbumService(FetchTemplate fetchTemplate,
                        AlbumMapperStrategy<JsonNode, AlbumDTODetails> detailsMapper,
                        AlbumMapperStrategy<JsonNode, List<AlbumDTO>> listMapper) {
        this.fetchTemplate = fetchTemplate;
        this.detailsMapper = detailsMapper;
        this.listMapper = listMapper;
    }

    public AlbumDTODetails getAlbumId(String albumId) {
        try {
            URI uri = URI.create(SPOTIFY_ALBUM_BASE + albumId);
            return fetchTemplate.execute(uri, detailsMapper::map);
        } catch (Exception e) {
            throw new AlbumNotFoundException(albumId);
        }
    }

    public List<AlbumDTO> searchAlbum(String query) {
        try {
            String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
            URI uri = URI.create(SPOTIFY_SEARCH_BASE + "?q=" + encodedQuery + "&type=album");
            return fetchTemplate.execute(uri, listMapper::map);
        } catch (Exception e) {
            throw new AlbumSearchException("Erro ao buscar álbuns. Tente novamente mais tarde.", e);
        }
    }
}
