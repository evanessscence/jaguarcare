package uam.fia.jaguarcare.model;
import jakarta.persistence.Entity;
import lombok.*;


@Entity
@Getter
@Setter

/*@NamedQueries({
	
	@NamedQuery(name="Sintomatologia.findByNombre",query="select e from Sintomatologia e where e.nombre like ?1")
})*/

public class Sintomatologia extends Identificable{
	
	private String nombre;

}
