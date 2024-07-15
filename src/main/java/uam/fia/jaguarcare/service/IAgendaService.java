package uam.fia.jaguarcare.service;

import uam.fia.jaguarcare.dto.AgendaDTO;

import java.util.List;
import java.util.Optional;

public interface IAgendaService {
    public List<AgendaDTO> getAll();

    public void create(AgendaDTO agendaDTO);

    public void delete(String id);

    public Optional<AgendaDTO> find(String id);
}
