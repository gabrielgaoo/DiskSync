package com.br.integration.domain.exception.albumException;

public class AlbumSearchException extends RuntimeException {

    public AlbumSearchException(String message) {
        super(message);
    }

    public AlbumSearchException(String message, Throwable cause) {
        super(message, cause);
    }
}
