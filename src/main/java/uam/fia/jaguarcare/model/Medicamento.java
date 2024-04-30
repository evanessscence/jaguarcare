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
            name = "med_sequence",
            sequenceName = "med_sequence",
            allocationSize = 1,
            initialValue = 1000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "med_sequence"
    )
    private Integer id;
    private String nombreComercial;
    private String nombreGenerico;
    private String dosis;
    private PresentacionMedicamento presentacionMedicamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visita_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Visita visita;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "medicamento")
    private List<Compra> compra;
}
