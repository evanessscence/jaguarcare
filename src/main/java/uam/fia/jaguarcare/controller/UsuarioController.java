package uam.fia.jaguarcare.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import uam.fia.jaguarcare.model.Usuario;
import uam.fia.jaguarcare.service.IUsuarioService;
import uam.fia.jaguarcare.service.IVisitanteService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getAll()
    {
        List<Usuario> lista = usuarioService.getAll();
        if (lista.isEmpty())
        {
            return ResponseEntity.badRequest().body(lista);

        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody @Valid Usuario modelo) // Crea un servicio que inserta usuarios
    {
        usuarioService.create(modelo);
        return ResponseEntity.ok("Usuario creado");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody @Valid Usuario modelo)
    {
        usuarioService.create(modelo);
        return ResponseEntity.ok("Usuario actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id)
    {
       usuarioService.delete(id);
        return ResponseEntity.ok("Usuario eliminado");
    }

    @GetMapping("search/{id}")
    public ResponseEntity<Optional<Usuario>> find(@PathVariable("id") String id)
    {
        Optional<Usuario> lista = usuarioService.find(id);
        return ResponseEntity.ok(lista);
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
