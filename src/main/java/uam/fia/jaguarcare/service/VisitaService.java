package uam.fia.jaguarcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.dto.VisitaDTO;
import uam.fia.jaguarcare.model.Visita;
import uam.fia.jaguarcare.repository.IVisitaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VisitaService implements IVisitaService {

    @Autowired
    private IVisitaRepository modeloRepositorio;

    @Override
    public List<VisitaDTO> getAll() {
        return modeloRepositorio.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void create(VisitaDTO visitaDTO) {
        Visita visita = convertToEntity(visitaDTO);
        modeloRepositorio.save(visita);
    }

    @Override
    public void delete(Integer id) {
        modeloRepositorio.deleteById(id);
    }
    private VisitaDTO convertToDTO(Visita visita) {
        VisitaDTO dto = new VisitaDTO();
        dto.setId(visita.getId());
        dto.setFecha(visita.getFecha());
        dto.setHoradeEntrada(visita.getHoradeEntrada());
        dto.setHoradeSalida(visita.getHoradeSalida());
        dto.setVisitanteId(visita.getVisitante().getCifID());
        dto.setUsuarioId(visita.getUsuario().getCIF());
        dto.setDiagnostico(visita.getDiagnostico());
        dto.setCantDispensada(visita.getCantDispensada());
        dto.setSintomatologiaId(Optional.ofNullable(visita.getSintomatologia()).map(s -> s.getId()).orElse(null));
        return dto;
    }

    private Visita convertToEntity(VisitaDTO dto) {
        Visita visita = new Visita();
        visita.setId(dto.getId());
        visita.setFecha(dto.getFecha());
        visita.setHoradeEntrada(dto.getHoradeEntrada());
        visita.setHoradeSalida(dto.getHoradeSalida());

        return visita;
    }
}
