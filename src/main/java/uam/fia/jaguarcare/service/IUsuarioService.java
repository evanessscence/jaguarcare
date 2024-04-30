package uam.fia.jaguarcare.service;

import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.model.Usuario;
import uam.fia.jaguarcare.model.Visitante;

import java.util.List;
import java.util.Optional;

@Service
public interface IUsuarioService {

    public List<Usuario> getAll();

    public void create(Usuario usuario);

    public void delete(String id);

    public Optional<Usuario> find(String id);
}
