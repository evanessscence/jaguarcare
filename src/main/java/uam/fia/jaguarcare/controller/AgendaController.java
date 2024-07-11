package uam.fia.jaguarcare.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import uam.fia.jaguarcare.dto.AgendaDTO;
import uam.fia.jaguarcare.model.Agenda;
import uam.fia.jaguarcare.service.IAgendaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/agenda")
@CrossOrigin("*")
public class AgendaController {

    @Autowired
    private IAgendaService AgendaService;

    @GetMapping("/all")
    public ResponseEntity<List<AgendaDTO>> getAll() {
        List<AgendaDTO> list = AgendaService.getAll();
        if (list.isEmpty()) {
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(list);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody @Valid AgendaDTO AgendaDTO) {

        AgendaService.create(AgendaDTO);
        return ResponseEntity.ok("Cita agendada");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody @Valid AgendaDTO AgendaDTO) {

        AgendaService.create(AgendaDTO);
        return ResponseEntity.ok("Agenda actualizada");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {

        AgendaService.delete(id);
        return ResponseEntity.ok("Cita eliminada");
    }

    private AgendaDTO convertToDTO(Agenda agenda) {
        AgendaDTO dto = new AgendaDTO();
        dto.setIdAgenda(agenda.getIdAgenda());
        dto.setEspecialidad(agenda.getEspecialidad());
        dto.setHora(agenda.getHora());
        dto.setFecha(agenda.getFecha());
        dto.setVisitante(agenda.getVisitante());
        return dto;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleValidationException(MethodArgumentNotValidException exception) {
        Map<String,String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError)error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        });
        return errors;
    }

}

