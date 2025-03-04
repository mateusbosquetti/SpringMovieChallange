package net.weg.moviesapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.moviesapi.model.dto.response.UserResponseDTO;
import net.weg.moviesapi.model.enums.ThemePreferenceEnum;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String document; //CPF

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ThemePreferenceEnum theme;

    @OneToMany(mappedBy = "user")
    private List<Movie> movieList;

    @OneToMany(mappedBy = "user")
    private List<Tag> movieTagList;

    public UserResponseDTO toDto() {
        return new UserResponseDTO(
                this.id,
                this.name,
                this.document,
                this.created_at,
                this.theme
        );
    }
}
