package uam.fia.jaguarcare.service;

import uam.fia.jaguarcare.dto.AgendaDTO;
import uam.fia.jaguarcare.dto.UsuarioDTO;
import uam.fia.jaguarcare.model.Agenda;

import java.util.List;
import java.util.Optional;

public interface IAgendaService {
    public List<AgendaDTO> getAll();

    public void create(AgendaDTO agendaDTO);

    public void delete(String id);

    public Optional<AgendaDTO> find(String id);
}
