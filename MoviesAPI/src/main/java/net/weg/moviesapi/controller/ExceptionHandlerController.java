package net.weg.moviesapi.controller;

import net.weg.moviesapi.model.dto.response.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(exception = {Exception.class})
    public ResponseEntity<ExceptionResponseDTO> exceptionHandler(Exception e) {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO("Mateus Henrique Bosquetti", e.getMessage(), e.getClass(), LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.BAD_REQUEST);
    }

}
