package com.br.integration.domain.service.albumService.albumStrategy.albumMapperStrategy;

@FunctionalInterface
public interface AlbumMapperStrategy<I, T> {

    T map(I response);
}
