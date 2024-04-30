package uam.fia.jaguarcare.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Usuario {
    @Id
    private String CIF;
    private String nombre;
    private String contraseña;
    private String rol;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "usuario")
    List<Visita> visitas;
}
