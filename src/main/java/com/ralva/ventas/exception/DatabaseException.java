package com.ralva.ventas.exception;


import lombok.Getter;

@Getter
public class DatabaseException extends RuntimeException {
    //private final int errorCode;
    //private final String causa;

    public DatabaseException(String mensaje, Throwable causa) {
        super(mensaje, causa);
        //this.errorCode = errorCode;
        //this.causa = causa.getMessage();
    }


}
