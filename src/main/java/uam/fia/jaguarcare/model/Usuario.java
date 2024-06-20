package uam.fia.jaguarcare.model;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Usuario {
    @Id
    @NotBlank(message = "El CIF no puede estar vacío")
    private String idRecepcionista;

    @Column(length = 50)
    String Cedula;

    @Column(length=50)
    String name;

    @Hidden
    String password;
}
