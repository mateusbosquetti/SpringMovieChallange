package net.weg.moviesapi.interfaces;

import net.weg.moviesapi.model.dto.request.MovieTagRequestDTO;
import net.weg.moviesapi.model.dto.response.MovieTagResponseDTO;
import net.weg.moviesapi.model.entity.Movie;
import net.weg.moviesapi.model.entity.MovieTag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTagInterface {
    public MovieTagResponseDTO createMovieTag (MovieTagRequestDTO movieMovieTagRequestDTO);
    public MovieTagResponseDTO putMovieTag (MovieTagRequestDTO movieMovieTagRequestDTO, Integer id);
    public MovieTagResponseDTO deleteMovieTag (Integer id);
    public Page<MovieTagResponseDTO> getMovieTag (Pageable pageable);
    public MovieTagResponseDTO findMovieTag (Integer id);
    public MovieTag findMovieTagEntity (Integer id);
    public MovieTag persisteChanges(MovieTag movieTag);

}
