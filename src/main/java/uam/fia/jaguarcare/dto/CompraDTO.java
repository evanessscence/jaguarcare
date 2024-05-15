package uam.fia.jaguarcare.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class CompraDTO {
    private Integer NumeroDeFactura;
    private LocalDate fecha;
    private Integer cantidadComprada;
    private List<MedicamentoDTO> medicamentos;
    private ProveedorDTO proveedor;

}
