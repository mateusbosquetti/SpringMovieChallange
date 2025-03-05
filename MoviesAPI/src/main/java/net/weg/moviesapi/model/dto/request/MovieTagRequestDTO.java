package net.weg.moviesapi.model.dto.request;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.weg.moviesapi.model.entity.Movie;
import net.weg.moviesapi.model.entity.MovieTag;
import net.weg.moviesapi.model.entity.User;
import net.weg.moviesapi.service.MovieService;
import net.weg.moviesapi.service.TagService;

import java.util.UUID;

public record MovieTagRequestDTO(
        @NotNull UUID movie_id,
        @NotNull Integer tag_id
) {
    public MovieTag toEntity(MovieService movieService, TagService tagService) {
        return MovieTag.builder()
                .movie(movieService.findMovieEntity(this.movie_id))
                .tag(tagService.findTagEntity(this.tag_id))
                .build();
    }
}
