package com.br.integration.controller;

import com.br.integration.domain.dto.AlbumDTO;
import com.br.integration.domain.dto.AlbumDTODetails;
import com.br.integration.domain.service.albumService.AlbumService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Álbum", description = "Busca e detalhes de álbuns (Spotify)")
@RequiredArgsConstructor
@RestController
@RequestMapping("/album")
public class AlbumController {

    private final AlbumService albumService;

    @Operation(summary = "Buscar álbuns", description = "Busca álbuns na Spotify pelo termo informado")
    @GetMapping("/search")
    public ResponseEntity<List<AlbumDTO>> searchAlbum(@Parameter(description = "Termo de busca") @RequestParam(name = "q") String query) {
        List<AlbumDTO> albums = albumService.searchAlbum(query);
        return ResponseEntity.ok(albums);
    }

    @Operation(summary = "Obter álbum por ID", description = "Retorna os detalhes de um álbum pelo ID da Spotify")
    @GetMapping("/{albumId}")
    public ResponseEntity<AlbumDTODetails> getAlbumId(@Parameter(description = "ID do álbum na Spotify") @PathVariable String albumId) {
        AlbumDTODetails album = albumService.getAlbumId(albumId);
        return ResponseEntity.ok(album);
    }
}