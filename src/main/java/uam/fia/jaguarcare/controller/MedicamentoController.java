package uam.fia.jaguarcare.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import uam.fia.jaguarcare.model.Medicamento;
import uam.fia.jaguarcare.model.Medicamento;
import uam.fia.jaguarcare.service.IMedicamentoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {

    @Autowired
    private IMedicamentoService medicamentoService;

    @GetMapping("/all")
    public ResponseEntity<List<Medicamento>> getAll()
    {
        List<Medicamento> lista = medicamentoService.getAll();
        if (lista.isEmpty())
        {
            return ResponseEntity.badRequest().body(lista);

        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody @Valid Medicamento medicamento) // Crea un servicio que inserta usuarios
    {

        medicamentoService.create(medicamento);
        return ResponseEntity.ok("Medicamento creado");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody @Valid Medicamento medicamento)
    {
        medicamentoService.create(medicamento);
        return ResponseEntity.ok("Medicamento actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id)
    {
       medicamentoService.delete(id);
        return ResponseEntity.ok("Medicamento eliminado");
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
