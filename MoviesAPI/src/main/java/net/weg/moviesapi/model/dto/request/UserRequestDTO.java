package net.weg.moviesapi.model.dto.request;

import jakarta.persistence.EnumType;
import jakarta.validation.constraints.NotBlank;
import net.weg.moviesapi.model.enums.ThemePreferenceEnum;
import org.hibernate.validator.constraints.Length;

public record UserRequestDTO(
        @NotBlank String name,
        @NotBlank @Length(min = 11, max = 11, message = "CPF deve conter 11 caracteres") String document
) {
}
