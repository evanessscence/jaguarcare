package uam.fia.jaguarcare.dto;

import lombok.Data;
import uam.fia.jaguarcare.model.enums.Carrera;
import uam.fia.jaguarcare.model.enums.TipoVisitante;

@Data
public class VisitanteDTO {
    private String ID;
    private String primerNombre;
    private String primerApellido;
    private Carrera carrera;
    private TipoVisitante tipo;
    private String telefono;
}
