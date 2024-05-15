package uam.fia.jaguarcare.service;

import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.dto.SintomatologiaDTO;
import uam.fia.jaguarcare.model.Sintomatologia;

import java.util.List;

@Service
public interface ISintomaService {

    public List<SintomatologiaDTO> getAll();

    public void create(SintomatologiaDTO sintomatologiaDTO);

    public void delete(Integer id);

}
