package uam.fia.jaguarcare.model;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
@Data
public class Visitante {

    @Id
    @NotBlank(message = "El CIF no puede estar vacío")
    private String cifID;

    @Column(length=25)
    @NotBlank(message = "El primer nombre no puede estar en blanco")
    private String primerNombre;

    @Column(length=25)
    @NotBlank(message = "El primer apellido no puede estar en blanco")
    private String primerApellido;

    @NotNull(message = "La carrera no puede estar vacia")
    private Carrera carrera;

    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "El número de teléfono no debe empezar en 0")
    private String telefono;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "visitante",cascade = CascadeType.ALL)
    List<Visita> visitas;

}
