package uam.fia.jaguarcare.dto;

import lombok.Data;
import uam.fia.jaguarcare.model.Medicamento;
import uam.fia.jaguarcare.model.Proveedor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Data
public class CompraDTO {
    private Integer id;
    private LocalDate fecha;
    private List<MedicamentoDTO> medicamento;
    private ProveedorDTO proveedor;
}
