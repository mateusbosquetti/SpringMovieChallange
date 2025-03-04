package net.weg.moviesapi.service;

import lombok.AllArgsConstructor;
import net.weg.moviesapi.interfaces.UserInterface;
import net.weg.moviesapi.model.dto.request.UserRequestDTO;
import net.weg.moviesapi.model.dto.response.UserResponseDTO;
import net.weg.moviesapi.model.entity.User;
import net.weg.moviesapi.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserInterface {

    private UserRepository repository;

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        return null;
    }

    @Override
    public UserResponseDTO putUser(UserRequestDTO userRequestDTO, Integer id) {
        return null;
    }

    @Override
    public UserResponseDTO deleteUser(Integer id) {
        return null;
    }

    @Override
    public Page<UserResponseDTO> getUser(Pageable pageable) {
        return null;
    }

    @Override
    public UserResponseDTO findUser(Integer id) {
        return null;
    }

    @Override
    public User findUserEntity(Integer id) {
        return null;
    }
}
