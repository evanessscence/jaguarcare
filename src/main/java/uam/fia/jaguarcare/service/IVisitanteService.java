package uam.fia.jaguarcare.service;

import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.dto.VisitanteDTO;
import uam.fia.jaguarcare.model.Visitante;

import java.util.List;
import java.util.Optional;

@Service
public interface IVisitanteService {

    public List<VisitanteDTO> getAll();

    public void create(VisitanteDTO visitanteDTO);

    public void delete(String id);

    public Optional<VisitanteDTO> find(String id);
}
