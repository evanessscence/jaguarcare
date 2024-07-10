package uam.fia.jaguarcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uam.fia.jaguarcare.model.Usuario;
import uam.fia.jaguarcare.model.Visitante;


public interface IUsuarioRepository extends JpaRepository<Usuario, String> {

    @Query("select count(e) from Usuario e " +
            "where e.Cedula = ?1 " +
            "and e.password = ?2")
    int getLogin(String cedula,String password);
}
