package com.choi.weplay.handler.exception;

import com.choi.weplay.handler.Constants;
import org.springframework.http.HttpStatus;

public class CustomException extends Exception {

    private static final long serialVersionUID = 3333L;

    private Constants.ExceptionDomain exceptionDomain;
    private HttpStatus httpStatus;

    public CustomException(Constants.ExceptionDomain exceptionDomain, HttpStatus httpStatus, String message) {
        super(exceptionDomain.toString() + message);
        this.exceptionDomain = exceptionDomain;
        this.httpStatus = httpStatus;
    }

    public Constants.ExceptionDomain getExceptionDomain() {
        return exceptionDomain;
    }

    public int getHttpStatusCode() {
        return httpStatus.value();
    }

    public String getHttpStatusType() {
        return httpStatus.getReasonPhrase();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}

