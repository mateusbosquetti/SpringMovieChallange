package net.weg.moviesapi.controller;

import lombok.AllArgsConstructor;
import net.weg.moviesapi.model.dto.request.MovieRequestDTO;
import net.weg.moviesapi.model.dto.response.MovieResponseDTO;
import net.weg.moviesapi.service.MovieService;
import net.weg.moviesapi.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {

    private MovieService service;

    @PostMapping
    public ResponseEntity<MovieResponseDTO> postMovie(@RequestBody @Validated MovieRequestDTO movieRequestDTO) {
        return new ResponseEntity<>(service.createMovie(movieRequestDTO), HttpStatus.OK);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<MovieResponseDTO> putMovie(@RequestBody @Validated MovieRequestDTO movieRequestDTO, @PathVariable(name = "uuid") UUID movie_uuid) {
        return new ResponseEntity<>(service.putMovie(movieRequestDTO, movie_uuid), HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<MovieResponseDTO> deleteMovie(@PathVariable(name = "uuid") UUID movie_uuid) {
        return new ResponseEntity<>(service.deleteMovie(movie_uuid), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<MovieResponseDTO> findMovie(@PathVariable(name = "uuid") UUID movie_uuid) {
        return new ResponseEntity<>(service.findMovie(movie_uuid), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<MovieResponseDTO>> getMovie(Pageable pageable) {
        return new ResponseEntity<>(service.getMovie(pageable), HttpStatus.OK);
    }

}
