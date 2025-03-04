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

    private MovieTagRepository movieTag;

    @Override
    public MovieTagResponseDTO createMovieTag(MovieTagRequestDTO movieMovieTagRequestDTO) {
        return null;
    }

    @Override
    public MovieTagResponseDTO putMovieTag(MovieTagRequestDTO movieMovieTagRequestDTO, Integer id) {
        return null;
    }

    @Override
    public MovieTagResponseDTO deleteMovieTag(Integer id) {
        return null;
    }

    @Override
    public Page<MovieTagResponseDTO> getMovieTag(Pageable pageable) {
        return null;
    }

    @Override
    public MovieTagResponseDTO findMovieTag(Integer id) {
        return null;
    }

    @Override
    public MovieTag findMovieTagEntity(Integer id) {
        return null;
    }
}
