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
	private Integer id;

	@NotNull(message = "La fecha no puede estar vacia")
	private LocalDate fecha;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "compra_medicamento", joinColumns = @JoinColumn(name = "compra_id"),
			inverseJoinColumns = @JoinColumn(name = "medicamento_id"))
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Medicamento> medicamento;

	@NotNull(message = "La fecha de lote no puede estar vacia")
	@PastOrPresent(message = "La fecha de lote debe ser en el pasado o presente")
	private Date lote;

	@NotNull(message = "La fecha de vencimiento no puede estar vacia")
	@Future(message = "La fecha de vencimiento debe ser en el futuro")
    private Date vencimiento;

	@NotBlank(message = "La presentación no puede estar en blanco")
    private String presentacion;

    private String indicaciones;

	@Min(value = 1, message = "La cantidad debe ser al menos 1")
	private int cantidad;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "proveedor_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@NotNull(message = "El proveedor no puede estar vacio")
	private Proveedor proveedor;

}
