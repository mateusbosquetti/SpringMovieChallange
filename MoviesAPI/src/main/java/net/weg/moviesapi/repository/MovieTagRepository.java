package net.weg.moviesapi.repository;

import net.weg.moviesapi.model.entity.MovieTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTagRepository extends JpaRepository<MovieTag, Integer> {
}
