package uam.fia.jaguarcare.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotBlank(message = "El nombre comercial no puede estar en blanco")
    private String nombreComercial;

    @NotBlank(message = "El nombre genérico no puede estar en blanco")
    private String nombreGenerico;

    @NotBlank(message = "La dosis no puede estar en blanco")
    private String dosis;

    @NotNull(message = "La presentación del medicamento debe ser ingresada")
    private PresentacionMedicamento presentacionMedicamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visita_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Visita visita;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "medicamento")
    private List<Compra> compra;
}
