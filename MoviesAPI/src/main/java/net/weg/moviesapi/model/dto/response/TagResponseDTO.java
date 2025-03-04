package net.weg.moviesapi.model.dto.response;

import net.weg.moviesapi.model.entity.User;

public record TagResponseDTO (
        String name,
        UserResponseDTO user
) {
}
