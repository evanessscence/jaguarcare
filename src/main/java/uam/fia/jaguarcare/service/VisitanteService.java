package uam.fia.jaguarcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.dto.VisitanteDTO;
import uam.fia.jaguarcare.model.Visitante;
import uam.fia.jaguarcare.repository.IVisitanteRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VisitanteService implements IVisitanteService {

    @Autowired
    private IVisitanteRepository visitanteRepository;

    @Override
    public List<VisitanteDTO> getAll() {
        return visitanteRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void create(VisitanteDTO visitanteDTO) {
        Visitante visitante = convertToEntity(visitanteDTO);
        visitanteRepository.save(visitante);
    }

    @Override
    public void delete(String id) {
        visitanteRepository.deleteById(id);
    }

    @Override
    public Optional<VisitanteDTO> find(String id) {
        return visitanteRepository.findById(id)
                .map(this::convertToDTO);
    }

    private VisitanteDTO convertToDTO(Visitante visitante) {
        VisitanteDTO dto = new VisitanteDTO();
        dto.setID(visitante.getID());
        dto.setPrimerNombre(visitante.getPrimerNombre());
        dto.setPrimerApellido(visitante.getPrimerApellido());
        dto.setCarrera(visitante.getCarrera());
        dto.setTelefono(visitante.getTelefono());
        return dto;
    }

    private Visitante convertToEntity(VisitanteDTO dto) {
        Visitante visitante = new Visitante();
        visitante.setID(dto.getID());
        visitante.setPrimerNombre(dto.getPrimerNombre());
        visitante.setPrimerApellido(dto.getPrimerApellido());
        visitante.setCarrera(dto.getCarrera());
        visitante.setTelefono(dto.getTelefono());
        return visitante;
    }

}
