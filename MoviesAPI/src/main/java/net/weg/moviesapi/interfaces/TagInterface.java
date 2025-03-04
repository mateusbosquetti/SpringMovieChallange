package net.weg.moviesapi.interfaces;

import net.weg.moviesapi.model.dto.request.TagRequestDTO;
import net.weg.moviesapi.model.dto.response.TagResponseDTO;
import net.weg.moviesapi.model.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagInterface {

    public TagResponseDTO createTag (TagRequestDTO tagRequestDTO);
    public TagResponseDTO putTag (TagRequestDTO tagRequestDTO, Integer id);
    public TagResponseDTO deleteTag (Integer id);
    public Page<TagResponseDTO> getTag (Pageable pageable);
    public TagResponseDTO findTag (Integer id);
    public Tag findTagEntity (Integer id);

}
