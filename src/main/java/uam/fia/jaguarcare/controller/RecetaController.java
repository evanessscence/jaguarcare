package uam.fia.jaguarcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uam.fia.jaguarcare.model.Receta;
import uam.fia.jaguarcare.service.IMedicamentoService;
import uam.fia.jaguarcare.service.IRecetaService;

import java.util.List;

@RestController
@RequestMapping("/receta")
public class RecetaController {

    @Autowired
    private IRecetaService recetaService;

    @GetMapping("/all")
    public ResponseEntity<List<Receta>> getAll()
    {
        List<Receta> lista = recetaService.getAll();
        if (lista.isEmpty())
        {
            return ResponseEntity.badRequest().body(lista);

        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Receta receta) // Crea un servicio que inserta usuarios
    {

        recetaService.create(receta);
        return ResponseEntity.ok("Receta creada");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Receta receta)
    {
        recetaService.create(receta);
        return ResponseEntity.ok("Receta actualizada");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id)
    {
       recetaService.delete(id);
        return ResponseEntity.ok("Receta eliminada");
    }
    
}
