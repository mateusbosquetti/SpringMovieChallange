package net.weg.moviesapi.model.dto.request;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.weg.moviesapi.model.entity.Movie;
import net.weg.moviesapi.model.entity.User;

public record MovieTagRequestDTO(
        @NotNull Integer movie_id,
        @NotNull Integer tag_id
) {
}
