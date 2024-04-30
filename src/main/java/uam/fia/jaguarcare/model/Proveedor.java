
package uam.fia.jaguarcare.model;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import lombok.*;

@Entity
@Data
public class Proveedor {

    @Id
    private Integer id;

    private String nombre;

    private String compania;

	private String correo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "proveedor")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Compra> compras;
}
