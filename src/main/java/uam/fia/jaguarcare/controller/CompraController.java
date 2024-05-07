package uam.fia.jaguarcare.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import uam.fia.jaguarcare.model.Compra;
import uam.fia.jaguarcare.service.ICompraService;
import uam.fia.jaguarcare.service.IUsuarioService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private ICompraService compraService;

    @GetMapping("/all")
    public ResponseEntity<List<Compra>> getAll()
    {
        List<Compra> lista = compraService.getAll();
        if (lista.isEmpty())
        {
            return ResponseEntity.badRequest().body(lista);

        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody @Valid Compra modelo) // Crea un servicio que inserta usuarios
    {
        compraService.create(modelo);
        return ResponseEntity.ok("Compra creado");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody @Valid Compra modelo)
    {
        compraService.create(modelo);
        return ResponseEntity.ok("Compra actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id)
    {
       compraService.delete(id);
        return ResponseEntity.ok("Compra eliminado");
    }

    @GetMapping("search/{id}")
    public ResponseEntity<Optional<Compra>> find(@PathVariable("id") Integer id)
    {
        Optional<Compra> lista = compraService.find(id);
        return ResponseEntity.ok(lista);
    }

    //Springboot Bean Validation
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
