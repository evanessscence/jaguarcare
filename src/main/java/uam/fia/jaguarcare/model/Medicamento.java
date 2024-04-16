package uam.fia.jaguarcare.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Medicamento {

    @Id
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 1000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Integer id;
    private String nombreComercial;
    private String nombreGenerico;
    private String dosis;
    private PresentacionMedicamento presentacionMedicamento;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "id")
    List<Receta> recetas;
}
