package uam.fia.jaguarcare.model;

import java.util.*;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import org.hibernate.annotations.*;


import lombok.*;

@Entity
@Getter @Setter
public class Agenda {
	
	@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid") //Universally unique identifier
	@Column(length=10)
    @Hidden
    private String idAgenda;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Visitante visitante;

	@Column(length=10)
	private Date fecha;
	
	@Column(length=10)
	private String hora;
	
	@Column(length=20)
	private String especialidad;
	// Este campo podría ser un enum, pero no conozco las especialidades
}
