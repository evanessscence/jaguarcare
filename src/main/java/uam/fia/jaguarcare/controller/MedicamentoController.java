package uam.fia.jaguarcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uam.fia.jaguarcare.model.Medicamento;
import uam.fia.jaguarcare.model.Medicamento;
import uam.fia.jaguarcare.service.IMedicamentoService;

import java.util.List;

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
    public ResponseEntity<String> create(@RequestBody Medicamento medicamento) // Crea un servicio que inserta usuarios
    {

        medicamentoService.create(medicamento);
        return ResponseEntity.ok("Medicamento creado");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Medicamento medicamento)
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

}
