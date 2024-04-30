package uam.fia.jaguarcare.model;

import java.time.*;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import lombok.*;

@Entity
@Data
public class Compra{
	@Id
	private Integer id;

	private LocalDate fecha;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "compra_medicamento", joinColumns = @JoinColumn(name = "compra_id"),
			inverseJoinColumns = @JoinColumn(name = "medicamento_id"))
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Medicamento> medicamento;
	
	private Date lote;

    private Date vencimiento;

    private String presentacion;

    private String indicaciones;
	
	private int cantidad;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "proveedor_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Proveedor proveedor;

}
