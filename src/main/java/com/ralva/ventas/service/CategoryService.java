package com.ralva.ventas.service;

import com.ralva.ventas.dto.CategoryDTO;

public interface CategoryService {
    public CategoryDTO obtenerProductoPorId(Long id);
    public CategoryDTO crearProducto(CategoryDTO categoryDTO);
}
