package uam.fia.jaguarcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uam.fia.jaguarcare.model.Sintomatologia;
import uam.fia.jaguarcare.model.Visitante;


public interface ISintomaRepository extends JpaRepository<Sintomatologia, String> {

}
