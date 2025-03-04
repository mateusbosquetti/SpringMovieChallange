package net.weg.moviesapi.model.dto.response;

import net.weg.moviesapi.model.enums.ThemePreferenceEnum;

import java.time.LocalDateTime;

public record UserResponseDTO(
        Integer id,
        String name,
        String document,
        LocalDateTime created_at,
        ThemePreferenceEnum theme
) {
}
