package uam.fia.jaguarcare.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Usuario {
    @Id
    @NotBlank(message = "El CIF no puede estar vacío")
    private String CIF;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String contraseña;

    @NotBlank(message = "El rol no puede estar vacío")
    private String rol;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "usuario")
    List<Visita> visitas;
}
