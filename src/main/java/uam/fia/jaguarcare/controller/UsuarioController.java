package uam.fia.jaguarcare.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import uam.fia.jaguarcare.dto.UsuarioDTO;
import uam.fia.jaguarcare.model.Usuario;
import uam.fia.jaguarcare.repository.IUsuarioRepository;
import uam.fia.jaguarcare.service.IUsuarioService;
import uam.fia.jaguarcare.service.IVisitanteService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private IUsuarioRepository repoUsuario;

    @GetMapping("/login")
    public Integer getLogin(@RequestParam("cedula") String cedula,
                            @RequestParam("password") String password) {
        return usuarioService.getLogin(cedula,password);
    }
    @GetMapping("/all")
    public ResponseEntity<List<UsuarioDTO>> getAll() {
        List<UsuarioDTO> list = usuarioService.getAll();
        if (list.isEmpty()) {
            return ResponseEntity.badRequest().body(list);
        }
        return ResponseEntity.ok(list);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        usuarioService.create(usuarioDTO);
        return ResponseEntity.ok("Usuario creado");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        usuarioService.create(usuarioDTO);  // Assuming an update method is available
        return ResponseEntity.ok("Usuario actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        usuarioService.delete(id);
        return ResponseEntity.ok("Usuario eliminado");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Optional<UsuarioDTO>> find(@PathVariable String id) {
        Optional<UsuarioDTO> usuario = usuarioService.find(id);
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
