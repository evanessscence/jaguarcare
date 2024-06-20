package uam.fia.jaguarcare.model;
import java.time.*;
import java.util.*;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import uam.fia.jaguarcare.model.enums.Destino;

@Entity
@Getter @Setter

public class Visita extends Identificable {


	@Column(length=6)
	int anyo;
		
	@Column(length=6)
	int numero;
	
	@ManyToOne(fetch = FetchType.LAZY,
			optional = false)
    private Recepcionista recepcionista;
	
	@Column(length=10)
	private LocalDate date; 
	
	@Column(length=10)
	private String horaEntrada;

	@Column(length=10)
	@NotNull
	private String horaSalida;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Visitante visitante;

	@ManyToOne(fetch=FetchType.LAZY, optional = true)
	private Sintomatologia sintomatologia; 
	     
	@Enumerated(EnumType.STRING)
	private Destino destino;
	    
	private String diagnostico;
	    
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Medicamento> medicamentos;
	    
	private Integer cantidadDispensada;
	
    @PrePersist
    @PreUpdate
    private void checkMedicamentoDisponible() {
    	Medicamento medicine = new Medicamento();
        medicine.verificarCantidadMinima();
    }
	   
/*	@PrePersist
	@PreUpdate
	private void validarHoras() throws Exception {
	    if (horaEntrada != null && horaSalida != null) {
	        LocalTime horaEntradaParsed = LocalTime.parse(this.horaEntrada);
	        LocalTime horaSalidaParsed = LocalTime.parse(this.horaSalida);

	        if (horaSalidaParsed.isBefore(horaEntradaParsed)) {
	            throw new javax.validation.ValidationException(
	                    "La hora de salida debe ser mayor que la hora de entrada."
	            );
	        }
	    }
	} */

}