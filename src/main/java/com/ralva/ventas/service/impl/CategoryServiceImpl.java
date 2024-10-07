package com.ralva.ventas.service.impl;

import com.ralva.ventas.dto.CategoryDTO;
import com.ralva.ventas.exception.DatabaseException;
import com.ralva.ventas.exception.RecursoNoEncontradoException;
import com.ralva.ventas.mapper.CategoryMapper;
import com.ralva.ventas.model.Category;
import com.ralva.ventas.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {


    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public CategoryDTO obtenerProductoPorId(Long id) throws RecursoNoEncontradoException {
        try {
            Category producto = categoryMapper.selectProductoById(id);
            if (producto == null) {
                throw new RecursoNoEncontradoException("Categoria no encontrado con ID: " + id);
            }
            return convertirADTO(producto);
        } catch (IllegalArgumentException e) {
            throw new DatabaseException("Error de tipo de datos: " + e.getMessage(), e);
        }
    }

    public CategoryDTO crearProducto(CategoryDTO productoDTO) {
        if (productoDTO.getNameCategory() == null || productoDTO.getState() == null) {
            throw new IllegalArgumentException("El nombre y el precio no pueden ser nulos");
        }
        Category producto = convertirAEntidad(productoDTO);
        categoryMapper.insertProducto(producto);
        return convertirADTO(producto);
    }


    private CategoryDTO convertirADTO(Category producto) {
        CategoryDTO dto = new CategoryDTO();
        dto.setIdCategory(producto.getId());
        dto.setNameCategory(producto.getNameCategory());
        dto.setDescription(producto.getDescription());
        dto.setState(producto.getState());
        return dto;
    }

    private Category convertirAEntidad(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setNameCategory(categoryDTO.getNameCategory());
        category.setDescription(categoryDTO.getDescription());
        category.setState(categoryDTO.getState());

        return category;
    }
}
