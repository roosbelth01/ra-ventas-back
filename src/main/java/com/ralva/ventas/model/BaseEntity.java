package com.ralva.ventas.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class BaseEntity {
    private Date dateCreation;
    private  String userCreation;
}
