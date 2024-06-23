package uam.fia.jaguarcare.dto;

import lombok.Data;
import uam.fia.jaguarcare.model.enums.PresentacionMedicamento;
import java.util.Date;

@Data
public class MedicamentoDTO {
    private String id;
    private String nombreComercial;
    private String nombreGenerico;
    private String dosis;
    private PresentacionMedicamento presentacion;
    private String lote;
    private Date vencimiento;
    private String indicaciones;
    private Integer cantidadDisponible;
    private Integer cantidadMinima;

}
