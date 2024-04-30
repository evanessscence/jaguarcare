package uam.fia.jaguarcare.service;

import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.model.Compra;
import uam.fia.jaguarcare.model.Usuario;

import java.util.List;
import java.util.Optional;

@Service
public interface ICompraService {

    public List<Compra> getAll();

    public void create(Compra compra);

    public void delete(Integer id);

    public Optional<Compra> find(Integer id);
}
