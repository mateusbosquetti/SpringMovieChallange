package net.weg.moviesapi.model.dto.response;

import net.weg.moviesapi.model.entity.Movie;
import net.weg.moviesapi.model.entity.User;

public record MovieTagResponseDTO(
        Integer id,
        MovieResponseDTO movie,
        TagResponseDTO tag
) {
}
