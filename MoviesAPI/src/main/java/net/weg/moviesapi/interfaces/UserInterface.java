package net.weg.moviesapi.interfaces;

import net.weg.moviesapi.model.dto.request.UserRequestDTO;
import net.weg.moviesapi.model.dto.response.UserResponseDTO;
import net.weg.moviesapi.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterface {
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    public UserResponseDTO putUser(UserRequestDTO userRequestDTO, Integer id);

    public UserResponseDTO deleteUser(Integer id);

    public Page<UserResponseDTO> getUser(Pageable pageable);

    public UserResponseDTO findUser(Integer id);

    public User findUserEntity(Integer id);

    public User persisteChanges(User user);
}
