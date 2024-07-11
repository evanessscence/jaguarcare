package uam.fia.jaguarcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.dto.VisitaDTO;
import uam.fia.jaguarcare.model.Visita;
import uam.fia.jaguarcare.repository.IVisitaRepository;

import java.sql.Time;
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
    public void delete(String id) {
        modeloRepositorio.deleteById(id);
    }
    private VisitaDTO convertToDTO(Visita visita) {
        VisitaDTO dto = new VisitaDTO();
        dto.setId(visita.getId());
        dto.setFecha(visita.getDate());
        dto.setHoradeEntrada(visita.getHoraEntrada());
        dto.setHoradeSalida(visita.getHoraSalida());
        dto.setVisitanteId(visita.getVisitante());
        dto.setRecepcionista(visita.getRecepcionista());
        dto.setDiagnostico(visita.getDiagnostico());
        dto.setCantDispensada(visita.getCantidadDispensada());
        dto.setSintomatologiaId(visita.getSintomatologia());
        dto.setMedicamento(visita.getMedicamentos());
        dto.setDestino(visita.getDestino());
        return dto;
    }

    private Visita convertToEntity(VisitaDTO dto) {
        Visita visita = new Visita();
        visita.setId(dto.getId());
        visita.setDate(dto.getFecha());
        visita.setHoraEntrada(dto.getHoradeEntrada());
        visita.setHoraSalida(dto.getHoradeSalida());
        visita.setVisitante(dto.getVisitanteId());
        visita.setRecepcionista(dto.getRecepcionista());
        visita.setDiagnostico(dto.getDiagnostico());
        visita.setCantidadDispensada(dto.getCantDispensada());
        visita.setSintomatologia(dto.getSintomatologiaId());
        visita.setMedicamentos(dto.getMedicamento());
        visita.setDestino(dto.getDestino());
        return visita;
    }
}
