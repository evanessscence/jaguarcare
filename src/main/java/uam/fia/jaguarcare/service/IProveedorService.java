package uam.fia.jaguarcare.service;

import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.dto.ProveedorDTO;
import uam.fia.jaguarcare.model.Proveedor;
import uam.fia.jaguarcare.model.Visita;

import java.util.List;

@Service
public interface IProveedorService {

    public List<ProveedorDTO> getAll();

    public void create(ProveedorDTO proveedorDTO);

    public void delete(Integer id);

}
