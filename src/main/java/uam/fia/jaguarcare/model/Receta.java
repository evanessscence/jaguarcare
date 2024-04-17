package uam.fia.jaguarcare.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
public class Receta {
    @Id
    @SequenceGenerator(
            name = "receta_sequence",
            sequenceName = "receta_sequence",
            allocationSize = 1,
            initialValue = 1000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "receta_sequence"
    )
    private Integer id;
    private String diagnostico;
    private Integer cantDispensada;

    @OneToOne
    @JoinColumn(name = "visita_id")
    private Visita visita; // Visita no se genera automáticamente con el pre-persist :(

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "receta")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Medicamento> medicamentos;

}
