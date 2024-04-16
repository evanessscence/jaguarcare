package uam.fia.jaguarcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uam.fia.jaguarcare.model.Visita;
import uam.fia.jaguarcare.model.Visitante;
import uam.fia.jaguarcare.repository.IVisitanteRepository;
import uam.fia.jaguarcare.service.IVisitaService;
import uam.fia.jaguarcare.service.IVisitanteService;
import uam.fia.jaguarcare.service.VisitanteService;

import java.util.List;

@RestController
@RequestMapping("/visita")
public class VisitaController {

    @Autowired
    private IVisitaService visitaService;
    @Autowired
    private IVisitanteService visitanteService;

    @GetMapping("/all")
    public ResponseEntity<List<Visita>> getAll()
    {
        List<Visita> lista = visitaService.getAll();
        if (lista.isEmpty())
        {
            return ResponseEntity.badRequest().body(lista);

        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Visita modelo) // Crea un servicio que inserta usuarios
    {

        visitaService.create(modelo);
        return ResponseEntity.ok("Visita creada");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Visita modelo)
    {
        visitaService.create(modelo);
        return ResponseEntity.ok("Visita actualizada");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id)
    {
       visitaService.delete(id);
        return ResponseEntity.ok("Visita eliminada");
    }


}
