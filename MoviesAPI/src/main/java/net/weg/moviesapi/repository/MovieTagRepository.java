package net.weg.moviesapi.repository;

import net.weg.moviesapi.model.dto.request.MovieTagRequestDTO;
import net.weg.moviesapi.model.dto.response.MovieTagResponseDTO;
import net.weg.moviesapi.model.entity.MovieTag;
import net.weg.moviesapi.model.entity.MovieTag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTagRepository extends JpaRepository<MovieTag, Integer> {
    public MovieTagResponseDTO createMovieTag (MovieTagRequestDTO movieMovieTagRequestDTO);
    public MovieTagResponseDTO putMovieTag (MovieTagRequestDTO movieMovieTagRequestDTO, Integer id);
    public MovieTagResponseDTO deleteMovieTag (Integer id);
    public Page<MovieTagResponseDTO> getMovieTag (Pageable pageable);
    public MovieTagResponseDTO findMovieTag (Integer id);
    public MovieTag findMovieTagEntity (Integer id);
}
