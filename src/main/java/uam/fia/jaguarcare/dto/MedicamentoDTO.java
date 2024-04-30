package uam.fia.jaguarcare.dto;

import lombok.Data;
import uam.fia.jaguarcare.model.PresentacionMedicamento;
@Data
public class MedicamentoDTO {
    private Integer id;
    private String nombreComercial;
    private String nombreGenerico;
    private String dosis;
    private PresentacionMedicamento presentacionMedicamento;
}
