package com.ralva.ventas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO extends BaseDTO{
    private Long idCategory;
    private String nameCategory;
    private String description;
    private String state;
}
