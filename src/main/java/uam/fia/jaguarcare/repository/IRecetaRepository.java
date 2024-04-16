package uam.fia.jaguarcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uam.fia.jaguarcare.model.Medicamento;
import uam.fia.jaguarcare.model.Receta;


public interface IRecetaRepository extends JpaRepository<Receta, Integer> {


}
