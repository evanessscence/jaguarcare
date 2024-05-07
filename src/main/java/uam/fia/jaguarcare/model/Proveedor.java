
package uam.fia.jaguarcare.model;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
public class Proveedor {

    @Id
    //no deberia ser Auto Generado?
    private Integer id;

    @NotBlank(message = "El nombre del proveedor no puede estar en blanco")
    private String nombre;

    @NotBlank(message = "El nombre de la compañía no puede estar en blanco")
    private String compania;

    @Email(message = "El correo debe ser un correo electrónico válido")
    @NotBlank(message = "El correo no puede estar en blanco")
	private String correo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "proveedor")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Compra> compras;
}
