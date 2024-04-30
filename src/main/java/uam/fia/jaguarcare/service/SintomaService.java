package uam.fia.jaguarcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.model.Sintomatologia;
import uam.fia.jaguarcare.repository.ISintomaRepository;

import java.util.List;

@Service
public class SintomaService implements ISintomaService {

    @Autowired
    private ISintomaRepository iSintomaRepository;

    @Override
    public List<Sintomatologia> getAll() {
        return iSintomaRepository.findAll();
    }

    @Override
    public void create(Sintomatologia Sintomatologia) {
        iSintomaRepository.save(Sintomatologia);
    }

    @Override
    public void delete(Integer id) {
    iSintomaRepository.deleteById(id);
    }
}
