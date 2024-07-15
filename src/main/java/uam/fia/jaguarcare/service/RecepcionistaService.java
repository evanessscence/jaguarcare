package uam.fia.jaguarcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.dto.RecepcionistaDTO;
import uam.fia.jaguarcare.model.Recepcionista;
import uam.fia.jaguarcare.repository.IRecepcionistaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class RecepcionistaService implements IRecepcionistaService {

    @Autowired
    private IRecepcionistaRepository usuarioRepository;

    public List<RecepcionistaDTO> getAll() {
        return usuarioRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void create(RecepcionistaDTO recepcionistaDTO) {
        Recepcionista recepcionista = convertToEntity(recepcionistaDTO);
        usuarioRepository.save(recepcionista);
    }

    public void delete(String id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<RecepcionistaDTO> find(String id) {
        return usuarioRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Override
    public int getLogin(String cedula, String password) {
        return usuarioRepository.getLogin(cedula,password);
    }

    private RecepcionistaDTO convertToDTO(Recepcionista recepcionista) {
        RecepcionistaDTO dto = new RecepcionistaDTO();
        dto.setIdRecepcionista(recepcionista.getIdrecepcionista());
        dto.setCedula(recepcionista.getCedula());
        dto.setName(recepcionista.getName());
        dto.setPassword(recepcionista.getPassword());
        return dto;
    }

    private Recepcionista convertToEntity(RecepcionistaDTO dto) {
        Recepcionista recepcionista = new Recepcionista();
        recepcionista.setIdrecepcionista(dto.getIdRecepcionista());
        recepcionista.setName(dto.getName());
        recepcionista.setCedula(dto.getCedula());
        recepcionista.setPassword(dto.getPassword());
        return recepcionista;
    }
}
