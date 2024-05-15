package uam.fia.jaguarcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.dto.ProveedorDTO;
import uam.fia.jaguarcare.model.Proveedor;
import uam.fia.jaguarcare.repository.IProveedorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProveedorService implements IProveedorService {

    @Autowired
    private IProveedorRepository proveedorRepository;

    public List<ProveedorDTO> getAll() {
        return proveedorRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void create(ProveedorDTO proveedorDTO) {
        Proveedor proveedor = convertToEntity(proveedorDTO);
        proveedorRepository.save(proveedor);
    }

    public void delete(Integer id) {
        proveedorRepository.deleteById(id);
    }

    private ProveedorDTO convertToDTO(Proveedor proveedor) {
        ProveedorDTO dto = new ProveedorDTO();
        dto.setId(proveedor.getId());
        dto.setNombre(proveedor.getNombre());
        dto.setCompania(proveedor.getCompania());
        dto.setCorreo(proveedor.getCorreo());
        return dto;
    }

    private Proveedor convertToEntity(ProveedorDTO dto) {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(dto.getId());
        proveedor.setNombre(dto.getNombre());
        proveedor.setCompania(dto.getCompania());
        proveedor.setCorreo(dto.getCorreo());
        return proveedor;
    }
}
