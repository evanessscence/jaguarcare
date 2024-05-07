package uam.fia.jaguarcare.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import uam.fia.jaguarcare.model.Sintomatologia;
import uam.fia.jaguarcare.service.ISintomaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sintoma")
public class SintomaController {

    @Autowired
    private ISintomaService sintomaService;

    @GetMapping("/all")
    public ResponseEntity<List<Sintomatologia>> getAll()
    {
        List<Sintomatologia> lista = sintomaService.getAll();
        if (lista.isEmpty())
        {
            return ResponseEntity.badRequest().body(lista);

        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody @Valid Sintomatologia sintomatologia) // Crea un servicio que inserta usuarios
    {

        sintomaService.create(sintomatologia);
        return ResponseEntity.ok("Sintomatologia agregada");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody @Valid Sintomatologia sintomatologia)
    {
        sintomaService.create(sintomatologia);
        return ResponseEntity.ok("Sintomatologia actualizada");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id)
    {
       sintomaService.delete(id);
        return ResponseEntity.ok("Sintomatologia eliminada");
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
