package uam.fia.jaguarcare.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

import org.hibernate.annotations.*;
import lombok.*;

@Entity
@Getter @Setter

public class Inventario extends Identificable{

	@Column(length=4)
	int anyo;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Medicamento medicamentoComprado; 
    
	private Integer cantidadComprada; 


}

