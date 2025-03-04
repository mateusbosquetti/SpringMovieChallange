package net.weg.moviesapi.repository;

import net.weg.moviesapi.model.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
