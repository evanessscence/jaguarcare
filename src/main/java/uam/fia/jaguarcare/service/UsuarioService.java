package uam.fia.jaguarcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.dto.UsuarioDTO;
import uam.fia.jaguarcare.model.Usuario;
import uam.fia.jaguarcare.model.Visitante;
import uam.fia.jaguarcare.repository.IUsuarioRepository;
import uam.fia.jaguarcare.repository.IVisitanteRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public List<UsuarioDTO> getAll() {
        return usuarioRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void create(UsuarioDTO usuarioDTO) {
        Usuario usuario = convertToEntity(usuarioDTO);
        usuarioRepository.save(usuario);
    }

    public void delete(String id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<UsuarioDTO> find(String id) {
        return usuarioRepository.findById(id)
                .map(this::convertToDTO);
    }

    private UsuarioDTO convertToDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setCif(usuario.getCIF());
        dto.setNombre(usuario.getNombre());
        dto.setContraseña(usuario.getContraseña());
        dto.setRol(usuario.getRol());
        return dto;
    }

    private Usuario convertToEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setCIF(dto.getCif());
        usuario.setNombre(dto.getNombre());
        usuario.setContraseña(dto.getContraseña());
        usuario.setRol(dto.getRol());
        return usuario;
    }
}
