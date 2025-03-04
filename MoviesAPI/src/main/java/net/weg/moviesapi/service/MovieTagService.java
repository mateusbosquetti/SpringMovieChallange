package net.weg.moviesapi.service;

import lombok.AllArgsConstructor;
import net.weg.moviesapi.interfaces.MovieTagInterface;
import net.weg.moviesapi.model.dto.request.MovieTagRequestDTO;
import net.weg.moviesapi.model.dto.response.MovieTagResponseDTO;
import net.weg.moviesapi.model.entity.MovieTag;
import net.weg.moviesapi.repository.MovieTagRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieTagService implements MovieTagInterface {

    private MovieTagRepository repository;
    private MovieService movieService;
    private TagService tagService;

    @Override
    public MovieTagResponseDTO createMovieTag(MovieTagRequestDTO movieTagRequestDTO) {
        MovieTag movieTag = movieTagRequestDTO.toEntity(movieService, tagService);
        movieTag = persisteChanges(movieTag);
        return movieTag.toDto();
    }

    @Override
    public MovieTagResponseDTO putMovieTag(MovieTagRequestDTO movieTagRequestDTO, Integer id) {
        findMovieTagEntity(id);

        MovieTag movieTag = movieTagRequestDTO.toEntity(movieService, tagService);
        movieTag.setId(id);
        movieTag = persisteChanges(movieTag);
        return movieTag.toDto();
    }

    @Override
    public MovieTagResponseDTO deleteMovieTag(Integer id) {
        MovieTag movieTag = findMovieTagEntity(id);
        repository.deleteById(id);
        return movieTag.toDto();
    }

    @Override
    public Page<MovieTagResponseDTO> getMovieTag(Pageable pageable) {
        return repository.findAll(pageable).map(MovieTag::toDto);
    }

    @Override
    public MovieTagResponseDTO findMovieTag(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Movie Tag DTO não encontrado!")).toDto();
    }

    @Override
    public MovieTag findMovieTagEntity(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Movie Tag Entidade não encontrado!"));
    }

    @Override
    public MovieTag persisteChanges(MovieTag movieTag) {
        return repository.save(movieTag);
    }
}
