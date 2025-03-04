package net.weg.moviesapi.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.weg.moviesapi.model.entity.Movie;
import net.weg.moviesapi.service.UserService;

import java.time.LocalTime;
import java.util.UUID;

public record MovieRequestDTO(
        @NotBlank String name,
        @NotNull LocalTime duration,
        @NotNull Integer rate,
        @NotNull Integer user_id
) {
    public Movie toEntity(UserService userService) {
        return Movie.builder()
                .name(this.name)
                .duration(this.duration)
                .rate(this.rate)
                .user(userService.findUserEntity(this.user_id))
                .build();
    }
}
