package uam.fia.jaguarcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uam.fia.jaguarcare.model.Visitante;
import uam.fia.jaguarcare.service.IVisitanteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/visitante")
public class VisitanteController {

    @Autowired
    private IVisitanteService visitanteService;

    @GetMapping("/all")
    public ResponseEntity<List<Visitante>> getAll()
    {
        List<Visitante> lista = visitanteService.getAll();
        if (lista.isEmpty())
        {
            return ResponseEntity.badRequest().body(lista);

        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Visitante modelo) // Crea un servicio que inserta usuarios
    {
        visitanteService.create(modelo);
        return ResponseEntity.ok("Visitante creado");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Visitante modelo)
    {
        visitanteService.create(modelo);
        return ResponseEntity.ok("Visitante actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id)
    {
       visitanteService.delete(id);
        return ResponseEntity.ok("Visitante eliminado");
    }

    @GetMapping("search/{id}")
    public ResponseEntity<Optional<Visitante>> find(@PathVariable("id") String id)
    {
        Optional<Visitante> lista = visitanteService.find(id);
        return ResponseEntity.ok(lista);
    }
}
