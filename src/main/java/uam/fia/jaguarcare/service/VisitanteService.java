package uam.fia.jaguarcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.model.Visitante;
import uam.fia.jaguarcare.repository.IVisitanteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VisitanteService implements IVisitanteService {

    @Autowired
    private IVisitanteRepository visitanteRepository;

    @Override
    public List<Visitante> getAll() {
        return visitanteRepository.findAll();
    }

    @Override
    public void create(Visitante visita) {
        visitanteRepository.save(visita);
    }

    @Override
    public void delete(String id) {
    visitanteRepository.deleteById(id);
    }

    @Override
    public Optional<Visitante> find(String id) {
        return visitanteRepository.findById(id);
    }

}
