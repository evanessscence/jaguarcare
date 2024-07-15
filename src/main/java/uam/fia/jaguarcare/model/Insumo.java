package uam.fia.jaguarcare.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Insumo extends Identificable{

    private String nombreInsumo;

    private String descripcion;

    private Integer cantidadDisponible;

    private Integer cantidadMinima;}

