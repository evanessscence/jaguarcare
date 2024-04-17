package uam.fia.jaguarcare.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
public class Visita {
    @Id
    @SequenceGenerator(
            name = "visita_sequence",
            sequenceName = "visita_sequence",
            allocationSize = 1,
            initialValue = 1000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "visita_sequence"
    )
    private Integer id;

    private LocalDate fecha;

    private LocalTime horadeEntrada;

    @PrePersist
    public void createdAt()
    {
        this.fecha = LocalDate.now();
        this.horadeEntrada = LocalTime.now();
        this.horadeSalida = LocalTime.now();
    }

    private LocalTime horadeSalida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visitante_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Visitante visitante;

}
