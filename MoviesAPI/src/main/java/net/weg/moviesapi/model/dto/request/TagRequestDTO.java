package net.weg.moviesapi.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.weg.moviesapi.model.entity.User;

public record TagRequestDTO(
        @NotBlank String name,
        @NotNull Integer user_id
) {
}
