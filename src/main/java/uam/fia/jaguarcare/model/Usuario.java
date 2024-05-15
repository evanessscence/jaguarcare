package uam.fia.jaguarcare.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.*;
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

    @NotNull(message = "El rol no puede estar vacío")
    @Enumerated(EnumType.STRING)
    private Rol rol;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "usuario")
    List<Visita> visitas;
}
