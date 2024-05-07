package uam.fia.jaguarcare.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Entity
@Data
public class Sintomatologia {
    @jakarta.persistence.Id
    @SequenceGenerator(
            name = "sintoma_sequence",
            sequenceName = "sintoma_sequence",
            allocationSize = 1,
            initialValue = 1000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sintoma_sequence"
    )
    private Integer Id;

    @NotBlank(message = "El nombre de la sintomatología no puede estar vacío")
    private String nombre;

    @OneToMany(mappedBy="sintomatologia")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    List<Visita> visitas;
}
