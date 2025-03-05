package net.weg.moviesapi.controller;

import lombok.AllArgsConstructor;
import net.weg.moviesapi.model.dto.request.MovieTagRequestDTO;
import net.weg.moviesapi.model.dto.response.MovieTagResponseDTO;
import net.weg.moviesapi.service.MovieTagService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movietag")
@AllArgsConstructor
public class MovieTagController {

    private MovieTagService service;

    @PostMapping
    public ResponseEntity<MovieTagResponseDTO> postMovieTag (@RequestBody @Validated MovieTagRequestDTO movieTagRequestDTO) {
        return new ResponseEntity<>(service.createMovieTag(movieTagRequestDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieTagResponseDTO> putMovieTag (@RequestBody @Validated MovieTagRequestDTO movieTagRequestDTO, @PathVariable(name = "id") Integer movieTag_id) {
        return new ResponseEntity<>(service.putMovieTag(movieTagRequestDTO, movieTag_id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MovieTagResponseDTO> deleteMovieTag (@PathVariable(name = "id") Integer movieTag_id) {
        return new ResponseEntity<>(service.deleteMovieTag(movieTag_id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieTagResponseDTO> findMovieTag (@PathVariable(name = "id") Integer movieTag_id) {
        return new ResponseEntity<>(service.findMovieTag(movieTag_id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<MovieTagResponseDTO>> getMovieTag (Pageable pageable) {
        return new ResponseEntity<>(service.getMovieTag(pageable), HttpStatus.OK);
    }
    
}
