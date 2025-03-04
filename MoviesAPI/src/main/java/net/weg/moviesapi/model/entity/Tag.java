package net.weg.moviesapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.moviesapi.model.dto.response.TagResponseDTO;

@Builder
@Entity
@Table(name = "tag")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    public TagResponseDTO toDto() {
        return new TagResponseDTO(
                this.id,
                this.name,
                this.user.toDto()
        );
    }
}
