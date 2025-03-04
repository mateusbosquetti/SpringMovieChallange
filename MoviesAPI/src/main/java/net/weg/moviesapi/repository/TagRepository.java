package net.weg.moviesapi.repository;

import net.weg.moviesapi.model.dto.request.TagRequestDTO;
import net.weg.moviesapi.model.dto.response.TagResponseDTO;
import net.weg.moviesapi.model.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {



}
