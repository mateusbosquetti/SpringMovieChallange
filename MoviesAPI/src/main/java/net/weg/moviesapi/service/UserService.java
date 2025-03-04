package net.weg.moviesapi.service;

import lombok.AllArgsConstructor;
import net.weg.moviesapi.exception.UserNotFoundException;
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
        User user = userRequestDTO.toEntity();
        user = persisteChanges(user);
        return user.toDto();
    }

    @Override
    public UserResponseDTO putUser(UserRequestDTO userRequestDTO, Integer id) {
        findUserEntity(id);

        User user = userRequestDTO.toEntity();
        user.setId(id);
        user = persisteChanges(user);
        return user.toDto();
    }

    @Override
    public UserResponseDTO deleteUser(Integer id) {
        User user = findUserEntity(id);
        repository.deleteById(id);
        return user.toDto();
    }

    @Override
    public Page<UserResponseDTO> getUser(Pageable pageable) {
        return repository.findAll(pageable).map(User::toDto);
    }

    @Override
    public UserResponseDTO findUser(Integer id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuário DTO não encontrado!")).toDto();
    }

    @Override
    public User findUserEntity(Integer id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuário Entidade não encontrado!"));
    }

    @Override
    public User persisteChanges(User user) {
        return repository.save(user);
    }
}
