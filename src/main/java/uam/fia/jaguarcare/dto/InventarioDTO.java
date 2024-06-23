package uam.fia.jaguarcare.dto;
import lombok.Data;
import uam.fia.jaguarcare.model.Medicamento;

@Data
public class InventarioDTO {
    int anyo;
    private Medicamento medicamentoComprado;
    private Integer cantidadComprada;
}
