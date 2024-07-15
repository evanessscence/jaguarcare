package uam.fia.jaguarcare.dto;

import lombok.Data;
import uam.fia.jaguarcare.model.Medicamento;
import uam.fia.jaguarcare.model.Sintomatologia;
import uam.fia.jaguarcare.model.Recepcionista;
import uam.fia.jaguarcare.model.Visitante;
import uam.fia.jaguarcare.model.enums.Destino;

import java.time.LocalDate;
import java.util.List;

@Data
public class VisitaDTO {
    private String id;
    private LocalDate fecha;
    private String horadeEntrada;
    private String horadeSalida;
    private Destino destino;
    private Visitante visitanteId;
    private Recepcionista recepcionista;
    private String diagnostico;
    private Integer cantDispensada;
    private Sintomatologia sintomatologiaId;
    private List<Medicamento> medicamento;
}
