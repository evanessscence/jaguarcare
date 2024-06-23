package uam.fia.jaguarcare.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import uam.fia.jaguarcare.dto.InventarioDTO;
import uam.fia.jaguarcare.service.IInventarioService;
import uam.fia.jaguarcare.model.Inventario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/inventario")
 public class InventarioController {

@Autowired
private IInventarioService inventarioService;

@GetMapping("/all")
public ResponseEntity<List<InventarioDTO>> getAll() {
List<InventarioDTO> list = inventarioService.getAll();
if (list.isEmpty()) {
return ResponseEntity.badRequest().body(list);
}
return ResponseEntity.ok(list);
}

@PostMapping("/create")
public ResponseEntity<String> create(@RequestBody @Valid InventarioDTO inventarioDTO) {

inventarioService.create(inventarioDTO);
return ResponseEntity.ok("Inventario agregado");
}

@PutMapping("/update")
public ResponseEntity<String> update(@RequestBody @Valid InventarioDTO inventarioDTO) {

inventarioService.create(inventarioDTO);
return ResponseEntity.ok("Inventario actualizada");
}

@DeleteMapping("/delete/{id}")
public ResponseEntity<String> delete(@PathVariable("id")String id) {

inventarioService.delete(id);
return ResponseEntity.ok("Inventario eliminada");
}

private InventarioDTO convertToDTO(Inventario inventario) {
InventarioDTO dto = new InventarioDTO();
dto.setAnyo(inventario.getAnyo());
dto.setMedicamentoComprado(inventario.getMedicamentoComprado());
dto.setCantidadComprada(inventario.getCantidadComprada());
return dto;
}

@ResponseStatus(HttpStatus.BAD_REQUEST)
@ExceptionHandler(MethodArgumentNotValidException.class)
public Map<String,String> handleValidationException(MethodArgumentNotValidException exception) {
Map<String,String> errors = new HashMap<>();
exception.getBindingResult().getAllErrors().forEach((error) -> {
String fieldName = ((FieldError)error).getField();
String errorMessage = error.getDefaultMessage();
errors.put(fieldName,errorMessage);
});
return errors;
}

}