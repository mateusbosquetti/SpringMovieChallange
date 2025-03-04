package net.weg.moviesapi.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;
import java.util.UUID;

public record MovieRequestDTO(
        @NotBlank String name,
        @NotNull LocalTime duration,
        @NotNull Integer rate,
        @NotNull Integer user_id
) {
}
