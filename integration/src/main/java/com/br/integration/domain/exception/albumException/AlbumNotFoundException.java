package com.br.integration.domain.exception.albumException;

public class AlbumNotFoundException extends RuntimeException {

    public AlbumNotFoundException(String albumId) {
        super("Álbum não encontrado com o ID informado: " + albumId);
    }
}
