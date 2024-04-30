package uam.fia.jaguarcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uam.fia.jaguarcare.model.Usuario;
import uam.fia.jaguarcare.model.Visitante;


public interface IUsuarioRepository extends JpaRepository<Usuario, String> {

}
