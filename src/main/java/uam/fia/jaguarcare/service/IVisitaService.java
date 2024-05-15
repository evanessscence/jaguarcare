package uam.fia.jaguarcare.service;

import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.dto.VisitaDTO;
import uam.fia.jaguarcare.model.Visita;

import java.util.List;

@Service
public interface IVisitaService {

    public List<VisitaDTO> getAll();

    public void create(VisitaDTO visitaDTO);

    public void delete(Integer id);

}
