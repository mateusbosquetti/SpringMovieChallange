package net.weg.moviesapi.repository;

import net.weg.moviesapi.model.dto.request.MovieTagRequestDTO;
import net.weg.moviesapi.model.dto.response.MovieTagResponseDTO;
import net.weg.moviesapi.model.entity.MovieTag;
import net.weg.moviesapi.model.entity.MovieTag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTagRepository extends JpaRepository<MovieTag, Integer> {

}
