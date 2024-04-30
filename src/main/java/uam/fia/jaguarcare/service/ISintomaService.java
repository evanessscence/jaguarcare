package uam.fia.jaguarcare.service;

import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.model.Sintomatologia;

import java.util.List;

@Service
public interface ISintomaService {

    public List<Sintomatologia> getAll();

    public void create(Sintomatologia sintomatologia);

    public void delete(Integer id);

}
