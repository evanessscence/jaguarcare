package uam.fia.jaguarcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.model.Proveedor;
import uam.fia.jaguarcare.repository.IProveedorRepository;

import java.util.List;

@Service
public class ProveedorService implements IProveedorService {

    @Autowired
    private IProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> getAll() {
        return proveedorRepository.findAll();
    }

    @Override
    public void create(Proveedor visita) {
        proveedorRepository.save(visita);
    }

    @Override
    public void delete(Integer id) {
    proveedorRepository.deleteById(id);
    }
}
