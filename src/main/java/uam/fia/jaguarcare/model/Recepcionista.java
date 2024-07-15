package uam.fia.jaguarcare.model;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Recepcionista {
    @Id
    @NotBlank(message = "El CIF no puede estar vacío")
    private String idrecepcionista;

    @Column
    String cedula;

    @Column
    String name;

    @Hidden
    String password;
}
