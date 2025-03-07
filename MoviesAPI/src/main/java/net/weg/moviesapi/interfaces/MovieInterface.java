package net.weg.moviesapi.interfaces;

import net.weg.moviesapi.model.dto.request.MovieRequestDTO;
import net.weg.moviesapi.model.dto.response.MovieResponseDTO;
import net.weg.moviesapi.model.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovieInterface {
    public MovieResponseDTO createMovie(MovieRequestDTO movieMovieRequestDTO);

    public MovieResponseDTO putMovie(MovieRequestDTO movieMovieRequestDTO, UUID uuid);

    public MovieResponseDTO deleteMovie(UUID uuid);

    public Page<MovieResponseDTO> getMovie(Pageable pageable);

    public MovieResponseDTO findMovie(UUID uuid);

    public Movie findMovieEntity(UUID uuid);
    public Movie persisteChanges(Movie movie);
}
