package uam.fia.jaguarcare.model;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;
import uam.fia.jaguarcare.exceptions.RefillException;
import uam.fia.jaguarcare.model.enums.PresentacionMedicamento;

@Entity
@Getter @Setter
/*@NamedQueries({
	@NamedQuery(name="Medicamento.findByNombre",query="select e from Medicamento e where e.nombre like ?1")
})*/

public class Medicamento extends Identificable{
	
	private String nombreComercial;
	@Column
    private String nombreGenerico;
    @Column
    private String dosis;
    
    @Enumerated(EnumType.STRING)
    private PresentacionMedicamento presentacion;
    @Column
	private String lote;
    @Column
    private Date vencimiento;
    @Column
    private String indicaciones;
    @Column
    private Integer cantidadDisponible;

	@Column
	private Integer cantidadMinima;

    public void verificarCantidadMinima() {
        if (cantidadDisponible != null && cantidadMinima != null) {
            if (cantidadDisponible <= cantidadMinima) {
                throw new RefillException(
                        "La cantidad disponible de '" + nombreComercial + "' está cerca o por debajo de la cantidad mínima. Rellene."
                );
            }
        }
    }


}