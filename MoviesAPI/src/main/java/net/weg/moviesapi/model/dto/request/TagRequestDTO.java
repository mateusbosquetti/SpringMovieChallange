package net.weg.moviesapi.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.weg.moviesapi.model.entity.Tag;
import net.weg.moviesapi.model.entity.User;
import net.weg.moviesapi.service.UserService;

public record TagRequestDTO(
        @NotBlank String name,
        @NotNull Integer user_id
) {
    public Tag toEntity(UserService userService) {
        return Tag.builder()
                .name(this.name)
                .user(userService.findUserEntity(this.user_id))
                .build();
    }
}
