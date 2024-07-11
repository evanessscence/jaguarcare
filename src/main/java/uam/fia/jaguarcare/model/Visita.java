package uam.fia.jaguarcare.model;
import java.time.*;
import java.util.*;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Cascade;
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
    private Usuario recepcionista;
	
	@Column(length=20)
	private LocalDate date; 
	
	@Column(length=20)
	private String horaEntrada;

	@Column(length=20)
	@NotNull
	private String horaSalida;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Visitante visitante;

	@ManyToOne(fetch=FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
	private Sintomatologia sintomatologia; 
	     
	@Enumerated(EnumType.STRING)
	private Destino destino;
	    
	private String diagnostico;
	    
	@ManyToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Medicamento> medicamentos;
	    
	private Integer cantidadDispensada;




}