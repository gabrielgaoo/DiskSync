package com.br.integration.domain.dto;

public record AlbumDTODetails(
        String id,
        String name,
        String artist,
        String releaseDate,
        String imageUrl,
        String externalUrl,
        int popularity,
        int trackCount,
        double price
) {
}
