package uam.fia.jaguarcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.model.Medicamento;
import uam.fia.jaguarcare.repository.IMedicamentoRepository;

import java.util.List;

@Service
public class MedicamentoService implements IMedicamentoService {

    @Autowired
    private IMedicamentoRepository iMedicamentoRepository;

    @Override
    public List<Medicamento> getAll() {
        return iMedicamentoRepository.findAll();
    }

    @Override
    public void create(Medicamento medicamento) {
        iMedicamentoRepository.save(medicamento);
    }

    @Override
    public void delete(Integer id) {
    iMedicamentoRepository.deleteById(id);
    }
}
