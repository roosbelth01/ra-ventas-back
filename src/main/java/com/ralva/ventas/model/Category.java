package com.ralva.ventas.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category extends BaseEntity{
    private Long id;
    private String nameCategory;
    private String description;
    private String state;
}
