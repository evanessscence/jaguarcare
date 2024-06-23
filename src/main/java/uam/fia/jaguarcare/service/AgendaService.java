package uam.fia.jaguarcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.dto.AgendaDTO;
import uam.fia.jaguarcare.model.Agenda;
import uam.fia.jaguarcare.repository.IAgendaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgendaService implements IAgendaService {

    @Autowired
    private IAgendaRepository agendaRepository;
    @Override
    public List<AgendaDTO> getAll() {
        return agendaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void create(AgendaDTO agendaDTO) {
        Agenda agenda = convertToEntity(agendaDTO);
        agendaRepository.save(agenda);
    }

    @Override
    public void delete(String id) {
        agendaRepository.deleteById(id);
    }

    @Override
    public Optional<AgendaDTO> find(String id) {
        return agendaRepository.findById(id)
                .map(this::convertToDTO);
    }

    private AgendaDTO convertToDTO(Agenda agenda) {
        AgendaDTO dto = new AgendaDTO();
        dto.setIdAgenda(agenda.getIdAgenda());
        dto.setEspecialidad(agenda.getEspecialidad());
        dto.setHora(agenda.getHora());
        dto.setFecha(agenda.getFecha());
        dto.setVisitante(agenda.getVisitante());
        return dto;
    }

    private Agenda convertToEntity(AgendaDTO dto) {
        Agenda agenda = new Agenda();
        agenda.setIdAgenda(dto.getIdAgenda());
        agenda.setEspecialidad(dto.getEspecialidad());
        agenda.setHora(dto.getHora());
        agenda.setFecha(dto.getFecha());
        agenda.setVisitante(dto.getVisitante());
        return agenda;
    }
}
