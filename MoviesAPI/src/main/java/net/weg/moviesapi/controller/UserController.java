package net.weg.moviesapi.controller;

import lombok.AllArgsConstructor;
import net.weg.moviesapi.model.dto.request.UserRequestDTO;
import net.weg.moviesapi.model.dto.response.UserResponseDTO;
import net.weg.moviesapi.model.entity.User;
import net.weg.moviesapi.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService service;

    @PostMapping
    public ResponseEntity<UserResponseDTO> postUser (@RequestBody UserRequestDTO userRequestDTO) {
        return new ResponseEntity<>(service.createUser(userRequestDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> putUser (@RequestBody UserRequestDTO userRequestDTO, @PathVariable(name = "id") Integer user_id) {
        return new ResponseEntity<>(service.putUser(userRequestDTO, user_id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDTO> deleteUser (@PathVariable(name = "id") Integer user_id) {
        return new ResponseEntity<>(service.deleteUser(user_id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findUser (@PathVariable(name = "id") Integer user_id) {
        return new ResponseEntity<>(service.findUser(user_id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<UserResponseDTO>> getUser (Pageable pageable) {
        return new ResponseEntity<>(service.getUser(pageable), HttpStatus.OK);
    }

}
