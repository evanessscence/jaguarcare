package uam.fia.jaguarcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uam.fia.jaguarcare.model.Compra;
import uam.fia.jaguarcare.repository.ICompraRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService implements ICompraService {

    @Autowired
    private ICompraRepository compraRepository;

    @Override
    public List<Compra> getAll() {
        return compraRepository.findAll();
    }


    @Override
    public void create(Compra usuario) {
        compraRepository.save(usuario);
    }

    @Override
    public void delete(Integer id) {
        compraRepository.deleteById(id);
    }

    @Override
    public Optional<Compra> find(Integer id) {
        return compraRepository.findById(id);
    }

}
