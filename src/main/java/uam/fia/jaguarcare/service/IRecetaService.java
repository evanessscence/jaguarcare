package uam.fia.jaguarcare.service;

import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.model.Receta;

import java.util.List;

@Service
public interface IRecetaService {

    public List<Receta> getAll();

    public void create(Receta medicamento);

    public void delete(Integer id);

}
