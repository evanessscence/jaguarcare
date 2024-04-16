package uam.fia.jaguarcare.service;

import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.model.Medicamento;
import uam.fia.jaguarcare.model.Visita;

import java.util.List;

@Service
public interface IMedicamentoService {

    public List<Medicamento> getAll();

    public void create(Medicamento medicamento);

    public void delete(Integer id);

}
