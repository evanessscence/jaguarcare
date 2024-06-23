package uam.fia.jaguarcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uam.fia.jaguarcare.model.Inventario;

public interface IInventarioRepository extends JpaRepository <Inventario,String> {}