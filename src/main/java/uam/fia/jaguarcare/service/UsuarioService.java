package uam.fia.jaguarcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.model.Usuario;
import uam.fia.jaguarcare.model.Visitante;
import uam.fia.jaguarcare.repository.IUsuarioRepository;
import uam.fia.jaguarcare.repository.IVisitanteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }


    @Override
    public void create(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void delete(String id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Optional<Usuario> find(String id) {
        return usuarioRepository.findById(id);
    }

}
