package uam.fia.jaguarcare.service;

import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.dto.CompraDTO;
import uam.fia.jaguarcare.model.Compra;
import uam.fia.jaguarcare.model.Usuario;

import java.util.List;
import java.util.Optional;

@Service
public interface ICompraService {

    public List<CompraDTO> getAll();

    public void create(CompraDTO compraDTO);

    public void delete(Integer id);

    public Optional<CompraDTO> find(Integer id);
}
