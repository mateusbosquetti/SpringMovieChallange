package net.weg.moviesapi.model.dto.request;

import jakarta.persistence.EnumType;
import jakarta.validation.constraints.NotBlank;
import net.weg.moviesapi.model.entity.User;
import net.weg.moviesapi.model.enums.ThemePreferenceEnum;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record UserRequestDTO(
        @NotBlank String name,
        @NotBlank @Length(min = 11, max = 11, message = "CPF deve conter 11 caracteres") String document
) {
    public User toEntity() {
        return User.builder()
                .name(this.name)
                .document(this.document)
                .created_at(LocalDateTime.now())
                .theme(ThemePreferenceEnum.LIGHT)
                .build();
    }
}
