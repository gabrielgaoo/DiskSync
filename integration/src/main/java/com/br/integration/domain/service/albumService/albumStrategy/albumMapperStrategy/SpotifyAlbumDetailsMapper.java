package com.br.integration.domain.service.albumService.albumStrategy.albumMapperStrategy;

import com.br.integration.domain.dto.AlbumDTODetails;
import com.br.integration.domain.service.albumService.albumStrategy.albumPriceStrategy.AlbumPriceStrategy;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

@Component
public class SpotifyAlbumDetailsMapper implements AlbumMapperStrategy<JsonNode, AlbumDTODetails> {

    private final AlbumDTODetailsMapper albumDTODetailsMapper;
    private final AlbumPriceStrategy priceStrategy;

    public SpotifyAlbumDetailsMapper(AlbumDTODetailsMapper albumDTODetailsMapper,
                                     AlbumPriceStrategy priceStrategy) {
        this.albumDTODetailsMapper = albumDTODetailsMapper;
        this.priceStrategy = priceStrategy;
    }

    @Override
    public AlbumDTODetails map(JsonNode response) {
        int popularity = AlbumJsonNodeReader.popularity(response);
        int trackCount = AlbumJsonNodeReader.trackCount(response);
        double price = priceStrategy.calculate(popularity, trackCount);
        return albumDTODetailsMapper.map(response, price);
    }
}
