package uam.fia.jaguarcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uam.fia.jaguarcare.model.Agenda;

public interface IAgendaRepository extends JpaRepository<Agenda,String> {
}
