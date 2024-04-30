package uam.fia.jaguarcare.service;

import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.model.Proveedor;
import uam.fia.jaguarcare.model.Visita;

import java.util.List;

@Service
public interface IProveedorService {

    public List<Proveedor> getAll();

    public void create(Proveedor proveedor);

    public void delete(Integer id);

}
