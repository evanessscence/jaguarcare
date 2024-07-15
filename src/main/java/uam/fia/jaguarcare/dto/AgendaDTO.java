package uam.fia.jaguarcare.dto;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import uam.fia.jaguarcare.model.Visitante;

import java.util.Date;
@Data
public class AgendaDTO {

    private String idAgenda;
    private Visitante visitante;
    private Date fecha;
    private String hora;
    private String especialidad;}
