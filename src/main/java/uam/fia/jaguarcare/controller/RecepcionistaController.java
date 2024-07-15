package uam.fia.jaguarcare.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import uam.fia.jaguarcare.dto.RecepcionistaDTO;
import uam.fia.jaguarcare.repository.IRecepcionistaRepository;
import uam.fia.jaguarcare.service.IRecepcionistaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class RecepcionistaController {

    @Autowired
    private IRecepcionistaService recepcionistaService;
    @Autowired
    private IRecepcionistaRepository repoUsuario;

    @GetMapping("/login")
    public Integer getLogin(@RequestParam("cedula") String cedula,
                            @RequestParam("password") String password) {
        return recepcionistaService.getLogin(cedula,password);
    }
    @GetMapping("/all")
    public ResponseEntity<List<RecepcionistaDTO>> getAll() {
        List<RecepcionistaDTO> list = recepcionistaService.getAll();
        if (list.isEmpty()) {
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(list);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody @Valid RecepcionistaDTO recepcionistaDTO) {
        recepcionistaService.create(recepcionistaDTO);
        return ResponseEntity.ok("Usuario creado");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody @Valid RecepcionistaDTO recepcionistaDTO) {
        recepcionistaService.create(recepcionistaDTO);  // Assuming an update method is available
        return ResponseEntity.ok("Usuario actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        recepcionistaService.delete(id);
        return ResponseEntity.ok("Usuario eliminado");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Optional<RecepcionistaDTO>> find(@PathVariable String id) {
        Optional<RecepcionistaDTO> usuario = recepcionistaService.find(id);
        return ResponseEntity.ok(usuario);
    }

    // Bean Validation error handling
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
