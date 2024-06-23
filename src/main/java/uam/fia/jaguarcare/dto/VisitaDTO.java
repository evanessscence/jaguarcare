package uam.fia.jaguarcare.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class VisitaDTO {
    private String id;
    private LocalDate fecha;

    @JsonFormat(pattern = "HH:mm:ss", timezone = "UTC")
    private LocalTime horadeEntrada;

    @JsonFormat(pattern = "HH:mm:ss", timezone = "UTC")
    private LocalTime horadeSalida;

    private String visitanteId;
    private String usuarioId;
    private String diagnostico;
    private Integer cantDispensada;
    private Integer sintomatologiaId;
}
