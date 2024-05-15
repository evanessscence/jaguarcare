package uam.fia.jaguarcare.model;

import java.time.*;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
public class Compra{
	@Id
	private Integer NumeroDeFactura;

	@NotNull(message = "La fecha no puede estar vacia")
	private LocalDate fecha;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "compra_medicamento", joinColumns = @JoinColumn(name = "compra_id"),
			inverseJoinColumns = @JoinColumn(name = "medicamento_id"))
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Medicamento> medicamento;

	@Min(value = 1, message = "La cantidad debe ser al menos 1")
	private int cantidadComprada;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "proveedor_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@NotNull(message = "El proveedor no puede estar vacio")
	private Proveedor proveedor;

}
