package net.weg.moviesapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.moviesapi.model.dto.response.MovieResponseDTO;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Builder
@Entity
@Table(name = "movie")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private LocalTime duration;

    @Column(nullable = false)
    private Integer rate;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    public MovieResponseDTO toDto() {
        return new MovieResponseDTO(
                this.id,
                this.name,
                this.duration,
                this.rate,
                this.user.toDto()
        );
    }
}
