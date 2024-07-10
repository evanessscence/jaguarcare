package uam.fia.jaguarcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.dto.InventarioDTO;
import uam.fia.jaguarcare.model.Inventario;
import uam.fia.jaguarcare.repository.IInventarioRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventarioService implements IInventarioService {
    @Autowired
    private IInventarioRepository InventarioRepository;
    @Override
    public List<InventarioDTO> getAll() {
        return InventarioRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void create(InventarioDTO InventarioDTO) {
        Inventario Inventario= convertToEntity(InventarioDTO);
        InventarioRepository.save(Inventario);
    }

    @Override
    public void delete(String id) {
            InventarioRepository.deleteById(id);
    }

    @Override
    public Optional<InventarioDTO> find(String id) {
            return InventarioRepository.findById(id)
                    .map(this::convertToDTO);
    }

    private InventarioDTO convertToDTO(Inventario Inventario) {
        InventarioDTO dto = new InventarioDTO();
        dto.setAnyo(Inventario.getAnyo());
        dto.setMedicamentoComprado(Inventario.getMedicamentocomprado());
        dto.setCantidadComprada(Inventario.getCantidadmedComprada());
        return dto;
    }

    private Inventario convertToEntity(InventarioDTO dto) {
        Inventario Inventario = new Inventario();
        Inventario.setAnyo(dto.getAnyo());
        Inventario.setMedicamentocomprado(dto.getMedicamentoComprado());
        Inventario.setCantidadmedComprada(dto.getCantidadComprada());
        return Inventario;
    }
}
