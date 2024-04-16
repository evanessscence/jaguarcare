package uam.fia.jaguarcare.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Visita {
    @Id
    @Column(nullable = false, updatable = false)
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
