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
    private String diagnostico;
    private Integer cantDispensada;
    private Integer visita_id;

    @PrePersist
    public void createdAt()
    {
        this.visita_id = this.id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicamento_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Medicamento medicamento;

}
