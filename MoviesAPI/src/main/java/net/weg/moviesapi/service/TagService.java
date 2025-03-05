package net.weg.moviesapi.service;

import lombok.AllArgsConstructor;
import net.weg.moviesapi.exception.TagNotFoundException;
import net.weg.moviesapi.interfaces.TagInterface;
import net.weg.moviesapi.model.dto.request.TagRequestDTO;
import net.weg.moviesapi.model.dto.request.TagRequestDTO;
import net.weg.moviesapi.model.dto.response.TagResponseDTO;
import net.weg.moviesapi.model.dto.response.TagResponseDTO;
import net.weg.moviesapi.model.entity.Tag;
import net.weg.moviesapi.model.entity.Tag;
import net.weg.moviesapi.repository.TagRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TagService implements TagInterface {

    private TagRepository repository;
    private UserService userService;
    @Override
    public TagResponseDTO createTag(TagRequestDTO tagRequestDTO) {
        Tag tag = tagRequestDTO.toEntity(userService);
        tag = persisteChanges(tag);
        return tag.toDto();
    }

    @Override
    public TagResponseDTO putTag(TagRequestDTO tagRequestDTO, Integer id) {
        findTagEntity(id);

        Tag tag = tagRequestDTO.toEntity(userService);
        tag.setId(id);
        tag = persisteChanges(tag);
        return tag.toDto();
    }

    @Override
    public TagResponseDTO deleteTag(Integer id) {
        Tag tag = findTagEntity(id);
        repository.deleteById(id);
        return tag.toDto();
    }

    @Override
    public Page<TagResponseDTO> getTag(Pageable pageable) {
        return repository.findAll(pageable).map(Tag::toDto);
    }

    @Override
    public TagResponseDTO findTag(Integer id) {
        return repository.findById(id).orElseThrow(() -> new TagNotFoundException("Tag DTO não encontrado!")).toDto();
    }

    @Override
    public Tag findTagEntity(Integer id) {
        return repository.findById(id).orElseThrow(() -> new TagNotFoundException("Tag Entidade não encontrado!"));
    }

    @Override
    public Tag persisteChanges(Tag tag) {
        return repository.save(tag);
    }
}
