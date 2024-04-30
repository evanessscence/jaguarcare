package uam.fia.jaguarcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uam.fia.jaguarcare.model.Compra;
import uam.fia.jaguarcare.model.Medicamento;


public interface ICompraRepository extends JpaRepository<Compra, Integer> {


}
