package uam.fia.jaguarcare.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import uam.fia.jaguarcare.dto.ProveedorDTO;
import uam.fia.jaguarcare.model.Proveedor;
import uam.fia.jaguarcare.service.IProveedorService;
import uam.fia.jaguarcare.service.IVisitaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private IProveedorService proveedorService;

    @GetMapping("/all")
    public ResponseEntity<List<ProveedorDTO>> getAll()
    {
        List<ProveedorDTO> lista = proveedorService.getAll();
        if (lista.isEmpty())
        {
            return ResponseEntity.badRequest().body(lista);

        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody @Valid ProveedorDTO proveedorDTO) {
        proveedorService.create(proveedorDTO);
        return ResponseEntity.ok("Proveedor creado");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody @Valid ProveedorDTO proveedorDTO) {
        proveedorService.create(proveedorDTO);
        return ResponseEntity.ok("Datos de proveedor actualizados");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        proveedorService.delete(id);
        return ResponseEntity.ok("Proveedor eliminado");
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
