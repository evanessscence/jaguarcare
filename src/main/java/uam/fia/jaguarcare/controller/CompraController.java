package uam.fia.jaguarcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uam.fia.jaguarcare.model.Compra;
import uam.fia.jaguarcare.service.ICompraService;
import uam.fia.jaguarcare.service.IUsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private ICompraService compraService;

    @GetMapping("/all")
    public ResponseEntity<List<Compra>> getAll()
    {
        List<Compra> lista = compraService.getAll();
        if (lista.isEmpty())
        {
            return ResponseEntity.badRequest().body(lista);

        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Compra modelo) // Crea un servicio que inserta usuarios
    {
        compraService.create(modelo);
        return ResponseEntity.ok("Compra creado");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Compra modelo)
    {
        compraService.create(modelo);
        return ResponseEntity.ok("Compra actualizado");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id)
    {
       compraService.delete(id);
        return ResponseEntity.ok("Compra eliminado");
    }

    @GetMapping("search/{id}")
    public ResponseEntity<Optional<Compra>> find(@PathVariable("id") Integer id)
    {
        Optional<Compra> lista = compraService.find(id);
        return ResponseEntity.ok(lista);
    }
}
