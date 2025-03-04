package net.weg.moviesapi.service;

import lombok.AllArgsConstructor;
import net.weg.moviesapi.interfaces.TagInterface;
import net.weg.moviesapi.model.dto.request.TagRequestDTO;
import net.weg.moviesapi.model.dto.response.TagResponseDTO;
import net.weg.moviesapi.model.entity.Tag;
import net.weg.moviesapi.repository.TagRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TagService implements TagInterface {

    private TagRepository repository;

    @Override
    public TagResponseDTO createTag(TagRequestDTO tagRequestDTO) {
        return null;
    }

    @Override
    public TagResponseDTO putTag(TagRequestDTO tagRequestDTO, Integer id) {
        return null;
    }

    @Override
    public TagResponseDTO deleteTag(Integer id) {
        return null;
    }

    @Override
    public Page<TagResponseDTO> getTag(Pageable pageable) {
        return null;
    }

    @Override
    public TagResponseDTO findTag(Integer id) {
        return null;
    }

    @Override
    public Tag findTagEntity(Integer id) {
        return null;
    }
}
