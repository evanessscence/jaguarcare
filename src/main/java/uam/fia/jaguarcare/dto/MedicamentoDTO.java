package uam.fia.jaguarcare.dto;

import lombok.Data;
import uam.fia.jaguarcare.model.PresentacionMedicamento;
import java.util.Date;

@Data
public class MedicamentoDTO {
    private Integer id;
    private String nombreComercial;
    private String nombreGenerico;
    private String dosis;
    private PresentacionMedicamento presentacion;
    private String lote;
    private Date vencimiento;
    private String indicaciones;
    private int cantidad;

}
