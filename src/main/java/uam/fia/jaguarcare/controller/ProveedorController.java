package uam.fia.jaguarcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uam.fia.jaguarcare.model.Proveedor;
import uam.fia.jaguarcare.service.IProveedorService;
import uam.fia.jaguarcare.service.IVisitaService;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private IProveedorService proveedorService;

    @GetMapping("/all")
    public ResponseEntity<List<Proveedor>> getAll()
    {
        List<Proveedor> lista = proveedorService.getAll();
        if (lista.isEmpty())
        {
            return ResponseEntity.badRequest().body(lista);

        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Proveedor modelo) // Crea un servicio que inserta usuarios
    {

        proveedorService.create(modelo);
        return ResponseEntity.ok("Proveedor creado");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Proveedor modelo)
    {
        proveedorService.create(modelo);
        return ResponseEntity.ok("Datos de proveedor actualizados");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id)
    {
       proveedorService.delete(id);
        return ResponseEntity.ok("Proveedor eliminado");
    }


}
