package uam.fia.jaguarcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.dto.SintomatologiaDTO;
import uam.fia.jaguarcare.model.Sintomatologia;
import uam.fia.jaguarcare.repository.ISintomaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SintomaService implements ISintomaService {

    @Autowired
    private ISintomaRepository iSintomaRepository;

    @Override
    public List<SintomatologiaDTO> getAll() {
        return iSintomaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void create(SintomatologiaDTO sintomatologiaDTO) {
        Sintomatologia sintomatologia = convertToEntity(sintomatologiaDTO);
        iSintomaRepository.save(sintomatologia);
    }
    @Override
    public void delete(Integer id) {
    iSintomaRepository.deleteById(id);
    }

    private Sintomatologia convertToEntity(SintomatologiaDTO dto) {
        Sintomatologia sintomatologia = new Sintomatologia();
        sintomatologia.setId(dto.getId());
        sintomatologia.setNombre(dto.getNombre());
        return sintomatologia;
    }

    private SintomatologiaDTO convertToDTO(Sintomatologia sintomatologia) {
        SintomatologiaDTO dto = new SintomatologiaDTO();
        dto.setId(sintomatologia.getId());
        dto.setNombre(sintomatologia.getNombre());
        return dto;
    }
}
