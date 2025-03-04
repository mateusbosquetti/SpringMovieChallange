package net.weg.moviesapi.service;

import lombok.AllArgsConstructor;
import net.weg.moviesapi.interfaces.MovieInterface;
import net.weg.moviesapi.model.dto.request.MovieRequestDTO;
import net.weg.moviesapi.model.dto.response.MovieResponseDTO;
import net.weg.moviesapi.model.entity.Movie;
import net.weg.moviesapi.repository.MovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieService implements MovieInterface {

    private MovieRepository repository;

    @Override
    public MovieResponseDTO createMovie(MovieRequestDTO movieMovieRequestDTO) {
        return null;
    }

    @Override
    public MovieResponseDTO putMovie(MovieRequestDTO movieMovieRequestDTO, String name) {
        return null;
    }

    @Override
    public MovieResponseDTO deleteMovie(String name) {
        return null;
    }

    @Override
    public Page<MovieResponseDTO> getMovie(Pageable pageable) {
        return null;
    }

    @Override
    public MovieResponseDTO findMovie(Integer id) {
        return null;
    }

    @Override
    public Movie findMovieEntity(Integer id) {
        return null;
    }
}
