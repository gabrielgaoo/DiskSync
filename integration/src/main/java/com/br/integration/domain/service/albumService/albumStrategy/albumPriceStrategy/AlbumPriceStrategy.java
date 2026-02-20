package com.br.integration.domain.service.albumService.albumStrategy.albumPriceStrategy;

@FunctionalInterface
public interface AlbumPriceStrategy {

    double calculate(int popularity, int trackCount);
}
