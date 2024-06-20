package uam.fia.jaguarcare.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import lombok.*;
import jakarta.persistence.*;
import uam.fia.jaguarcare.model.enums.Carrera;
import uam.fia.jaguarcare.model.enums.TipoVisitante;

@Entity
@Getter @Setter

public class Visitante {

	@Id
	private String cifID;

	private String primerNombre;

	private String primerApellido;
	
	@Enumerated(EnumType.STRING)
    private Carrera carrera;
    
    @Enumerated(EnumType.STRING)
    private TipoVisitante tipo;

    private String telefono;
	
	/*@OneToMany(mappedBy="visitante")
	@ListProperties("numero,date,receta.diagnostico,receta.sintomatologia.nombre,receta.medicamento.nombre,receta.cantidad")
	Collection<Visita> visitas;*/
	
}
