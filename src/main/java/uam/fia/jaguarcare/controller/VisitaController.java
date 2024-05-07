package uam.fia.jaguarcare.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import uam.fia.jaguarcare.model.Visita;
import uam.fia.jaguarcare.model.Visitante;
import uam.fia.jaguarcare.repository.IVisitanteRepository;
import uam.fia.jaguarcare.service.IVisitaService;
import uam.fia.jaguarcare.service.IVisitanteService;
import uam.fia.jaguarcare.service.VisitanteService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/visita")
public class VisitaController {

    @Autowired
    private IVisitaService visitaService;

    @GetMapping("/all")
    public ResponseEntity<List<Visita>> getAll()
    {
        List<Visita> lista = visitaService.getAll();
        if (lista.isEmpty())
        {
            return ResponseEntity.badRequest().body(lista);

        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody @Valid Visita modelo) // Crea un servicio que inserta usuarios
    {

        visitaService.create(modelo);
        return ResponseEntity.ok("Visita creada");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody @Valid Visita modelo)
    {
        visitaService.create(modelo);
        return ResponseEntity.ok("Visita actualizada");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id)
    {
       visitaService.delete(id);
        return ResponseEntity.ok("Visita eliminada");
    }
    //Bean Validation
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleValidationException(MethodArgumentNotValidException exception){
        Map<String,String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError)error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        });
        return errors;
    }

}
