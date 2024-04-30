package uam.fia.jaguarcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uam.fia.jaguarcare.model.Proveedor;
import uam.fia.jaguarcare.model.Visita;


public interface IProveedorRepository extends JpaRepository<Proveedor, Integer> {


}
