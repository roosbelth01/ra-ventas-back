package com.ralva.ventas.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public abstract class BaseDTO {
    private Date dateCreation;
    private  String userCreation;
}
