package com.br.integration.domain.dto;

public record AlbumDTO(String id,
                       String name,
                       String artist,
                       String releaseDate,
                       String imageUrl,
                       String externalUrl
) {
}
