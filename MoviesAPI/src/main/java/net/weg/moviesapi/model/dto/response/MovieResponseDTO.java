package net.weg.moviesapi.model.dto.response;

import net.weg.moviesapi.model.entity.Tag;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public record MovieResponseDTO(
        UUID id,
        String name,
        LocalTime duration,
        Integer rate,
        List<Tag> tagList,
        UserResponseDTO user
) {
}
