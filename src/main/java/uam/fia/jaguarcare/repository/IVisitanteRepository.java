package uam.fia.jaguarcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uam.fia.jaguarcare.model.Visitante;


public interface IVisitanteRepository extends JpaRepository<Visitante, String> {

}
