package net.weg.moviesapi.service;

import lombok.AllArgsConstructor;
import net.weg.moviesapi.interfaces.MovieInterface;
import net.weg.moviesapi.model.dto.request.MovieRequestDTO;
import net.weg.moviesapi.model.dto.request.MovieRequestDTO;
import net.weg.moviesapi.model.dto.response.MovieResponseDTO;
import net.weg.moviesapi.model.dto.response.MovieResponseDTO;
import net.weg.moviesapi.model.entity.Movie;
import net.weg.moviesapi.model.entity.Movie;
import net.weg.moviesapi.repository.MovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieService implements MovieInterface {

    private MovieRepository repository;

    private UserService userService;

    @Override
    public MovieResponseDTO createMovie(MovieRequestDTO movieRequestDTO) {
        Movie movie = movieRequestDTO.toEntity(userService);
        movie = persisteChanges(movie);
        return movie.toDto();
    }

    @Override
    public MovieResponseDTO putMovie(MovieRequestDTO movieRequestDTO, String name) {
        Movie oldMovie = findMovieEntity(name);

        Movie movie = movieRequestDTO.toEntity(userService);
        movie.setId(oldMovie.getId());
        movie = persisteChanges(movie);
        return movie.toDto();
    }

    @Override
    public MovieResponseDTO deleteMovie(String name) {
        Movie movie = findMovieEntity(name);
        repository.deleteById(movie.getId());
        return movie.toDto();
    }

    @Override
    public Page<MovieResponseDTO> getMovie(Pageable pageable) {
        return repository.findAll(pageable).map(Movie::toDto);
    }

    @Override
    public MovieResponseDTO findMovie(String name) {
        return repository.findByName(name).orElseThrow(() -> new RuntimeException("Movie DTO não encontrado!")).toDto();
    }

    @Override
    public Movie findMovieEntity(String name) {
        return repository.findByName(name).orElseThrow(() -> new RuntimeException("Movie Entidade não encontrado!"));
    }

    @Override
    public Movie persisteChanges(Movie movie) {
        return repository.save(movie);
    }
}
