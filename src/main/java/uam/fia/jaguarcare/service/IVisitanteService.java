package uam.fia.jaguarcare.service;

import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.model.Visitante;

import java.util.List;
import java.util.Optional;

@Service
public interface IVisitanteService {

    public List<Visitante> getAll();

    public void create(Visitante visita);

    public void delete(String id);

    public Optional<Visitante> find(String id);
}
