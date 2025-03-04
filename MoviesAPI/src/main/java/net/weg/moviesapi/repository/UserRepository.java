package net.weg.moviesapi.repository;

import net.weg.moviesapi.model.dto.request.UserRequestDTO;
import net.weg.moviesapi.model.dto.response.UserResponseDTO;
import net.weg.moviesapi.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
