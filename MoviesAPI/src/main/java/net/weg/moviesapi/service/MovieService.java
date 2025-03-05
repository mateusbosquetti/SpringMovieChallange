package net.weg.moviesapi.service;

import lombok.AllArgsConstructor;
import net.weg.moviesapi.exception.MovieNotFoundException;
import net.weg.moviesapi.interfaces.MovieInterface;
import net.weg.moviesapi.model.dto.request.MovieRequestDTO;
import net.weg.moviesapi.model.dto.request.MovieRequestDTO;
import net.weg.moviesapi.model.dto.request.MovieRequestDTO;
import net.weg.moviesapi.model.dto.response.MovieResponseDTO;
import net.weg.moviesapi.model.dto.response.MovieResponseDTO;
import net.weg.moviesapi.model.dto.response.MovieResponseDTO;
import net.weg.moviesapi.model.entity.Movie;
import net.weg.moviesapi.model.entity.Movie;
import net.weg.moviesapi.model.entity.Movie;
import net.weg.moviesapi.model.entity.User;
import net.weg.moviesapi.repository.MovieRepository;
import net.weg.moviesapi.repository.MovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
    public MovieResponseDTO putMovie(MovieRequestDTO movieRequestDTO, UUID uuid) {
        Movie oldMovie = findMovieEntity(uuid);

        Movie movie = movieRequestDTO.toEntity(userService);
        movie.setId(uuid);
        movie = persisteChanges(movie);
        return movie.toDto();
    }

    @Override
    public MovieResponseDTO deleteMovie(UUID uuid) {
        Movie movie = findMovieEntity(uuid);
        repository.deleteById(uuid);
        return movie.toDto();
    }

    @Override
    public Page<MovieResponseDTO> getMovie(Pageable pageable) {
        return repository.findAll(pageable).map(Movie::toDto);
    }

    @Override
    public MovieResponseDTO findMovie(UUID uuid) {
        return repository.findById(uuid).orElseThrow(() -> new MovieNotFoundException("Usuário DTO não encontrado!")).toDto();
    }

    @Override
    public Movie findMovieEntity(UUID uuid) {
        return repository.findById(uuid).orElseThrow(() -> new MovieNotFoundException("Usuário Entidade não encontrado!"));
    }

    @Override
    public Movie persisteChanges(Movie movie) {
        return repository.save(movie);
    }
}
