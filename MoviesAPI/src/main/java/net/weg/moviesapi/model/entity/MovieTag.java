package net.weg.moviesapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.moviesapi.model.dto.response.MovieTagResponseDTO;

import java.util.UUID;

@Builder
@Entity
@Table(name = "movie_tag")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;


    public MovieTagResponseDTO toDto() {
        return new MovieTagResponseDTO(
                id,
                movie.toDto(),
                tag.toDto()
        );
    }
}
