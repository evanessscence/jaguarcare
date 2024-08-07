package uam.fia.jaguarcare.service;

import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.dto.MedicamentoDTO;
import uam.fia.jaguarcare.model.Medicamento;
import uam.fia.jaguarcare.model.Visita;

import java.util.List;

@Service
public interface IMedicamentoService {

    public List<MedicamentoDTO> getAll();

    public void create(MedicamentoDTO medicamentoDTO);

    public void delete(String id);

}
