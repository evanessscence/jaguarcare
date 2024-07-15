package uam.fia.jaguarcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uam.fia.jaguarcare.model.Recepcionista;


public interface IRecepcionistaRepository extends JpaRepository<Recepcionista, String> {

    @Query("select count(e) from Recepcionista e " +
            "where e.cedula = ?1 " +
            "and e.password = ?2")
    int getLogin(String cedula,String password);
}
