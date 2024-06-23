package uam.fia.jaguarcare.service;

import uam.fia.jaguarcare.dto.InventarioDTO;

import java.util.List;
import java.util.Optional;

public interface IInventarioService {
    public List<InventarioDTO> getAll();
    public void create(InventarioDTO InventarioDTO);
    public void delete(String id);
    public Optional<InventarioDTO> find(String id);}