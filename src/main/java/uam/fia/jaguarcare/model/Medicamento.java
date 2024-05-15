package uam.fia.jaguarcare.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.Date;
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
    @Enumerated(EnumType.STRING)
    private PresentacionMedicamento presentacion;

    @NotBlank(message = "El lote no puede estar en blanco")
    private String lote;

    @NotNull(message = "La fecha de vencimiento no puede estar vacia")
    @Future(message = "La fecha de vencimiento debe ser en el futuro")
    private Date vencimiento;

    private String indicaciones;

    @NotNull(message = "La cantidad no puede estar vacia")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private Integer cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visita_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Visita visita;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "medicamentos")
    private List<Compra> compra;
}
