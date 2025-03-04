package net.weg.moviesapi.model.dto.response;

import java.time.Instant;
import java.time.LocalDateTime;

public record ExceptionResponseDTO(
        String autor,
        String message,
        Class classe,
        LocalDateTime instant
) {
}
