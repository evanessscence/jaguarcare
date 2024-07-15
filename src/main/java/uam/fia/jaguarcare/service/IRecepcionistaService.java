package uam.fia.jaguarcare.service;

import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.dto.RecepcionistaDTO;

import java.util.List;
import java.util.Optional;

@Service
public interface IRecepcionistaService {

    public List<RecepcionistaDTO> getAll();

    public void create(RecepcionistaDTO recepcionistaDTO);

    public void delete(String id);

    public Optional<RecepcionistaDTO> find(String id);

    int getLogin(String cedula, String password);
}
