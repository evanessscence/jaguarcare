package uam.fia.jaguarcare.dto;

import jakarta.persistence.Column;
import lombok.Data;
import uam.fia.jaguarcare.model.Carrera;
@Data
public class VisitanteDTO {
    private String cifID;
    private String primerNombre;
    private String primerApellido;
    private Carrera carrera;
    private String telefono;
}
