package uam.fia.jaguarcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.dto.MedicamentoDTO;
import uam.fia.jaguarcare.model.Medicamento;
import uam.fia.jaguarcare.repository.IMedicamentoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicamentoService implements IMedicamentoService {

    @Autowired
    private IMedicamentoRepository medicamentoRepository;  // Inyección del repositorio

    public List<MedicamentoDTO> getAll() {
        return medicamentoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void create(MedicamentoDTO medicamentoDTO) {
        Medicamento medicamento = convertToEntity(medicamentoDTO);
        medicamentoRepository.save(medicamento);
    }
    public void delete(Integer id) {
        medicamentoRepository.deleteById(id);
    }

    private MedicamentoDTO convertToDTO(Medicamento medicamento) {
        MedicamentoDTO dto = new MedicamentoDTO();
        dto.setId(medicamento.getId());
        dto.setNombreComercial(medicamento.getNombreComercial());
        dto.setNombreGenerico(medicamento.getNombreGenerico());
        dto.setDosis(medicamento.getDosis());
        dto.setPresentacion(medicamento.getPresentacion());
        dto.setLote(medicamento.getLote());
        dto.setVencimiento(medicamento.getVencimiento());
        dto.setIndicaciones(medicamento.getIndicaciones());
        dto.setCantidad(medicamento.getCantidad());
        return dto;
    }

    private Medicamento convertToEntity(MedicamentoDTO dto) {
        Medicamento medicamento = new Medicamento();
        medicamento.setId(dto.getId());
        medicamento.setNombreComercial(dto.getNombreComercial());
        medicamento.setNombreGenerico(dto.getNombreGenerico());
        medicamento.setDosis(dto.getDosis());
        medicamento.setPresentacion(dto.getPresentacion());
        medicamento.setLote(dto.getLote());
        medicamento.setVencimiento(dto.getVencimiento());
        medicamento.setIndicaciones(dto.getIndicaciones());
        medicamento.setCantidad(dto.getCantidad());
        return medicamento;
    }
}
