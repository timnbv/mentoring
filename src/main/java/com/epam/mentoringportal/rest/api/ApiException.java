package com.epam.mentoringportal.rest.api;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-02-25T18:51:55.918Z")

public class ApiException extends Exception {
    private int code;

    public ApiException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
