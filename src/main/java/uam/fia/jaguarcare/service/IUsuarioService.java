package uam.fia.jaguarcare.service;

import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.dto.UsuarioDTO;
import uam.fia.jaguarcare.model.Usuario;
import uam.fia.jaguarcare.model.Visitante;

import java.util.List;
import java.util.Optional;

@Service
public interface IUsuarioService {

    public List<UsuarioDTO> getAll();

    public void create(UsuarioDTO usuarioDTO);

    public void delete(String id);

    public Optional<UsuarioDTO> find(String id);
}
