package uam.fia.jaguarcare.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import uam.fia.jaguarcare.dto.VisitanteDTO;
import uam.fia.jaguarcare.model.Visitante;
import uam.fia.jaguarcare.service.IVisitanteService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/visitante")
public class VisitanteController {

    @Autowired
    private IVisitanteService visitanteService;

    @GetMapping("/all")
    public ResponseEntity<List<VisitanteDTO>> getAll() {
        List<VisitanteDTO> lista = visitanteService.getAll();
        return lista.isEmpty() ? ResponseEntity.badRequest().body(lista) : ResponseEntity.ok(lista);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody @Valid VisitanteDTO modelo) {
        visitanteService.create(modelo);
        return ResponseEntity.ok("Visitante creado");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody @Valid VisitanteDTO modelo) {
        visitanteService.create(modelo);
        return ResponseEntity.ok("Visitante actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        visitanteService.delete(id);
        return ResponseEntity.ok("Visitante eliminado");
    }

    @GetMapping("search/{id}")
    public ResponseEntity<Optional<VisitanteDTO>> find(@PathVariable("id") String id) {
        Optional<VisitanteDTO> lista = visitanteService.find(id);
        return ResponseEntity.ok(lista);
    }

    //Bean Validation
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError)error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
