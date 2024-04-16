package uam.fia.jaguarcare.service;

import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.model.Visita;

import java.util.List;

@Service
public interface IVisitaService {

    public List<Visita> getAll();

    public void create(Visita visita);

    public void delete(Integer id);

}
