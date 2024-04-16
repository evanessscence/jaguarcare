package uam.fia.jaguarcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.model.Receta;
import uam.fia.jaguarcare.repository.IMedicamentoRepository;
import uam.fia.jaguarcare.repository.IRecetaRepository;

import java.util.List;

@Service
public class RecetaService implements IRecetaService {

    @Autowired
    private IRecetaRepository recetaRepository;

    @Override
    public List<Receta> getAll() {
        return recetaRepository.findAll();
    }

    @Override
    public void create(Receta medicamento) {
        recetaRepository.save(medicamento);
    }

    @Override
    public void delete(Integer id) {
    recetaRepository.deleteById(id);
    }
}
