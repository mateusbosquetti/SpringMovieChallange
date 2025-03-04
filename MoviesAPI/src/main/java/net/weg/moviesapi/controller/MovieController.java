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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {

    private MovieService service;

    @PostMapping
    public ResponseEntity<MovieResponseDTO> postMovie(@RequestBody MovieRequestDTO movieRequestDTO) {
        return new ResponseEntity<>(service.createMovie(movieRequestDTO), HttpStatus.OK);
    }

    @PutMapping("/{name}")
    public ResponseEntity<MovieResponseDTO> putMovie(@RequestBody MovieRequestDTO movieRequestDTO, @PathVariable(name = "name") String movie_name) {
        return new ResponseEntity<>(service.putMovie(movieRequestDTO, movie_name), HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<MovieResponseDTO> deleteMovie(@PathVariable(name = "name") String movie_name) {
        return new ResponseEntity<>(service.deleteMovie(movie_name), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<MovieResponseDTO> findMovie(@PathVariable(name = "name") String movie_name) {
        return new ResponseEntity<>(service.findMovie(movie_name), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<MovieResponseDTO>> getMovie(Pageable pageable) {
        return new ResponseEntity<>(service.getMovie(pageable), HttpStatus.OK);
    }

}
