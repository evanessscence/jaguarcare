package uam.fia.jaguarcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.dto.CompraDTO;
import uam.fia.jaguarcare.dto.MedicamentoDTO;
import uam.fia.jaguarcare.dto.ProveedorDTO;
import uam.fia.jaguarcare.model.Compra;
import uam.fia.jaguarcare.repository.ICompraRepository;
import uam.fia.jaguarcare.repository.IMedicamentoRepository;
import uam.fia.jaguarcare.repository.IProveedorRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompraService implements ICompraService {

    @Autowired
    private ICompraRepository compraRepository;

    @Autowired
    private IMedicamentoRepository medicamentoRepository;

    @Autowired
    private IProveedorRepository proveedorRepository;

    @Override
    public List<CompraDTO> getAll() {
        return compraRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void create(CompraDTO compraDTO) {
        Compra compra = convertToEntity(compraDTO);
        compraRepository.save(compra);
    }

    @Override
    public void delete(Integer id) {
        compraRepository.deleteById(id);
    }

    @Override
    public Optional<CompraDTO> find(Integer id) {
        return compraRepository.findById(id).map(this::convertToDTO);
    }

    private CompraDTO convertToDTO(Compra compra) {
        CompraDTO compraDTO = new CompraDTO();
        compraDTO.setNumeroDeFactura(compra.getNumeroDeFactura());
        compraDTO.setFecha(compra.getFecha());
        compraDTO.setMedicamentos(compra.getMedicamentos().stream()
                .map(medicamento -> {
                    MedicamentoDTO medicamentoDTO = new MedicamentoDTO();
                    medicamentoDTO.setId(medicamento.getId());
                    medicamentoDTO.setNombreComercial(medicamento.getNombreComercial());
                    medicamentoDTO.setNombreGenerico(medicamento.getNombreGenerico());
                    medicamentoDTO.setDosis(medicamento.getDosis());
                    medicamentoDTO.setPresentacion(medicamento.getPresentacion());
                    return medicamentoDTO;
                })
                .collect(Collectors.toList()));
        ProveedorDTO proveedorDTO = new ProveedorDTO();
        proveedorDTO.setId(compra.getProveedor().getId());
        proveedorDTO.setNombre(compra.getProveedor().getNombre());
        proveedorDTO.setCompania(compra.getProveedor().getCompania());
        proveedorDTO.setCorreo(compra.getProveedor().getCorreo());
        compraDTO.setProveedor(proveedorDTO);

        return compraDTO;
    }

    private Compra convertToEntity(CompraDTO compraDTO) {
        Compra compra = new Compra();
        compra.setNumeroDeFactura(compraDTO.getNumeroDeFactura());
        compra.setFecha(compraDTO.getFecha());
        compra.setMedicamentos(compraDTO.getMedicamentos().stream()
                .map(medicamentoDTO -> medicamentoRepository.findById(medicamentoDTO.getId())
                        .orElseThrow(() -> new IllegalStateException("Medicamento not found: " + medicamentoDTO.getId())))
                .collect(Collectors.toList()));
        compra.setProveedor(proveedorRepository.findById(compraDTO.getProveedor().getId())
                .orElseThrow(() -> new IllegalStateException("Proveedor not found: " + compraDTO.getProveedor().getId())));
        return compra;
    }
}
