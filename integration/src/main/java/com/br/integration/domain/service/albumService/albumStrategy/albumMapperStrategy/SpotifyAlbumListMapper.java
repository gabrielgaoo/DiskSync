package com.br.integration.domain.service.albumService.albumStrategy.albumMapperStrategy;

import com.br.integration.domain.dto.AlbumDTO;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpotifyAlbumListMapper implements AlbumMapperStrategy<JsonNode, List<AlbumDTO>> {

    private final AlbumDTOMapper albumDTOMapper;

    public SpotifyAlbumListMapper(AlbumDTOMapper albumDTOMapper) {
        this.albumDTOMapper = albumDTOMapper;
    }

    @Override
    public List<AlbumDTO> map(JsonNode response) {
        JsonNode items = response.path("albums").path("items");
        List<AlbumDTO> albums = new ArrayList<>();
        for (JsonNode item : items) {
            albums.add(albumDTOMapper.map(item));
        }
        return albums;
    }
}
