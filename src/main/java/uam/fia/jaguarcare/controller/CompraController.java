package uam.fia.jaguarcare.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import uam.fia.jaguarcare.dto.CompraDTO;
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
    public ResponseEntity<List<CompraDTO>> getAll() {
        List<CompraDTO> list = compraService.getAll();
        if (list.isEmpty()) {
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(list);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody @Valid CompraDTO compraDTO) // Crea un servicio que inserta usuarios
    {
        compraService.create(compraDTO);
        return ResponseEntity.ok("Compra creado");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody @Valid CompraDTO compraDTO)
    {
        compraService.create(compraDTO);
        return ResponseEntity.ok("Compra actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id)
    {
       compraService.delete(id);
        return ResponseEntity.ok("Compra eliminado");
    }

    @GetMapping("search/{id}")
    public ResponseEntity<Optional<CompraDTO>> find(@PathVariable("id") Integer id)
    {
        Optional<CompraDTO> lista = compraService.find(id);
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
