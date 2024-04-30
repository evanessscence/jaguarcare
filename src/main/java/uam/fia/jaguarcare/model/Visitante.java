package uam.fia.jaguarcare.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Visitante {

    @Id
    private String cifID;

    @Column(length=25)
    private String primerNombre;

    @Column(length=25)
    private String primerApellido;

    private Carrera carrera;

    private String telefono;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "visitante",cascade = CascadeType.ALL)
    List<Visita> visitas;

}
