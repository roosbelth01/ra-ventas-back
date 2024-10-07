package com.ralva.ventas.controller;

import com.ralva.ventas.dto.CategoryDTO;
import com.ralva.ventas.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> obtenerProducto(@PathVariable Long id) {
        CategoryDTO producto = categoryService.obtenerProductoPorId(id);
        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> crearProducto(@RequestBody CategoryDTO productoDTO) {
        CategoryDTO nuevoProducto = categoryService.crearProducto(productoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> obtenerProducto(@PathVariable Long id) {
        CategoryDTO producto = categoryService.obtenerProductoPorId(id);
        Map<String, Object> response = new HashMap<>();
        response.put("data", producto);
        response.put("metadata", Map.of(
                "timestamp", LocalDateTime.now(),
                "status", HttpStatus.OK.value(),
                "message", "Operación exitosa"
        ));
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> crearProducto(@Valid @RequestBody CategoryDTO productoDTO) {
        CategoryDTO nuevoProducto = categoryService.crearProducto(productoDTO);
        Map<String, Object> response = new HashMap<>();
        response.put("data", nuevoProducto);
        response.put("metadata", Map.of(
                "timestamp", LocalDateTime.now(),
                "status", HttpStatus.CREATED.value(),
                "message", "Creación exitosa"
        ));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
