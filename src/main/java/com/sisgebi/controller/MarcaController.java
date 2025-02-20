package com.sisgebi.controller;

import com.sisgebi.entity.Marca;
import com.sisgebi.response.MarcaResponseRest;
import com.sisgebi.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    // Obtener todas las marcas
    @GetMapping("/getAll")
    public ResponseEntity<MarcaResponseRest> getAllMarcas() {
        return marcaService.getAllMarcas();
    }

    // Obtener una marca por el nombre
    @GetMapping("/getByNombreMarca/{nombreMarca}")
    public ResponseEntity<MarcaResponseRest> getMarcaByNombreMarca(@PathVariable String nombreMarca) {
        return marcaService.getMarcaByNombre(nombreMarca);  // Llamamos al servicio con el nombre de la marca
    }

    // Crear una nueva marca
    @PostMapping("/createMarca")
    public ResponseEntity<MarcaResponseRest> createMarca(@RequestBody Marca marca) {
        return marcaService.createMarca(marca);
    }

    // Actualizar una marca existente
    @PutMapping("/updateByNombreMarca/{nombreMarca}")
    public ResponseEntity<MarcaResponseRest> updateMarcaByNombreMarca(@PathVariable String nombreMarca, @RequestBody Marca marca) {
        return marcaService.updateMarca(nombreMarca, marca);  // Llamamos al servicio con el nombre de la marca
    }

    // Eliminar una marca
    @DeleteMapping("/deleteByNombreMarca/{nombreMarca}")
    public ResponseEntity<MarcaResponseRest> deleteMarcaByNombreMarca(@PathVariable String nombreMarca) {
        return marcaService.deleteMarca(nombreMarca);  // Llamamos al servicio con el nombre de la marca
    }
}
