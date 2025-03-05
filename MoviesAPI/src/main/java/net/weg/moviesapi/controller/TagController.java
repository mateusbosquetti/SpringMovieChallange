package net.weg.moviesapi.controller;

import lombok.AllArgsConstructor;
import net.weg.moviesapi.model.dto.request.TagRequestDTO;
import net.weg.moviesapi.model.dto.response.TagResponseDTO;
import net.weg.moviesapi.service.TagService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
@AllArgsConstructor
public class TagController {

    private TagService service;

    @PostMapping
    public ResponseEntity<TagResponseDTO> postTag (@RequestBody @Validated TagRequestDTO tagRequestDTO) {
        return new ResponseEntity<>(service.createTag(tagRequestDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TagResponseDTO> putTag (@RequestBody @Validated TagRequestDTO tagRequestDTO, @PathVariable(name = "id") Integer tag_id) {
        return new ResponseEntity<>(service.putTag(tagRequestDTO, tag_id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TagResponseDTO> deleteTag (@PathVariable(name = "id") Integer tag_id) {
        return new ResponseEntity<>(service.deleteTag(tag_id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagResponseDTO> findTag (@PathVariable(name = "id") Integer tag_id) {
        return new ResponseEntity<>(service.findTag(tag_id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<TagResponseDTO>> getTag (Pageable pageable) {
        return new ResponseEntity<>(service.getTag(pageable), HttpStatus.OK);
    }
    
}
