package uam.fia.jaguarcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.dto.VisitaDTO;
import uam.fia.jaguarcare.model.Visita;
import uam.fia.jaguarcare.repository.IVisitaRepository;

import java.time.LocalTime;
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
        dto.setFecha(visita.getDate());
        dto.setHoradeEntrada(LocalTime.parse(visita.getHoraEntrada()));
        dto.setHoradeSalida(LocalTime.parse(visita.getHoraSalida()));
        dto.setVisitanteId(visita.getVisitante().getCifID());
        dto.setUsuarioId(visita.getRecepcionista().getIdRecepcionista());
        dto.setDiagnostico(visita.getDiagnostico());
        dto.setCantDispensada(visita.getCantidadDispensada());
        dto.setSintomatologiaId(Integer.valueOf(Optional.ofNullable(visita.getSintomatologia()).map(s -> s.getId()).orElse(null)));
        return dto;
    }

    private Visita convertToEntity(VisitaDTO dto) {
        Visita visita = new Visita();
        visita.setId(dto.getId());
        visita.setDate(dto.getFecha());
        visita.setHoraEntrada(String.valueOf(dto.getHoradeEntrada()));
        visita.setHoraSalida(String.valueOf(dto.getHoradeSalida()));
        return visita;
    }
}
