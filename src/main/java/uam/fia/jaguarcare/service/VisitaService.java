package uam.fia.jaguarcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.model.Visita;
import uam.fia.jaguarcare.repository.IVisitaRepository;

import java.util.List;

@Service
public class VisitaService implements IVisitaService {

    @Autowired
    private IVisitaRepository modeloRepositorio;

    @Override
    public List<Visita> getAll() {
        return modeloRepositorio.findAll();
    }

    @Override
    public void create(Visita visita) {
        modeloRepositorio.save(visita);
    }

    @Override
    public void delete(Integer id) {
    modeloRepositorio.deleteById(id);
    }
}
