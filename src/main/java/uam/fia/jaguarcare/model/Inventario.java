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
    private Medicamento medicamentocomprado;

	@Column(name="cantidadmed_comprada")
	private Integer cantidadmedComprada;


	@Column(name="cantidadinsumo_comprada")
	private Integer cantidadinsumoComprada;

	@ManyToOne(fetch = FetchType.LAZY)
	private Insumo insumocomprado;

}

