package com.ralva.ventas.mapper;

import com.ralva.ventas.model.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CategoryMapper {
    //@Select("SELECT * FROM productos WHERE id = #{id}")
    Category selectProductoById(Long id);

    //@Insert("INSERT INTO productos(nombre, descripcion, precio) VALUES(#{nombre}, #{descripcion}, #{precio})")
    //@Options(useGeneratedKeys = true, keyProperty = "id")
    void insertProducto(Category producto);


}
