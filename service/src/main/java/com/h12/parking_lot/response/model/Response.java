package com.h12.parking_lot.response.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface Response {

    static Response of(Object headers, Object data, Object errors) {
        return of(headers, data, errors, (Exception[]) null);
    }

    static Response of(Object headers, Object data, Object errors, Exception... ex) {
        return new GenericResponse(headers, data, errors, ex);
    }

    static Response of(Object headers, Object data) {
        return of(headers, data, null);
    }

    static Response of(Object data) {
        return of(null, data, null);
    }

    @Data
    class GenericResponse implements Response {
        private Object headers;
        private Object data;
        private Object errors;
        private Exception[] exceptions;

        public GenericResponse(Object headers, Object data, Object errors, Exception[] exceptions) {
            this.headers = headers;
            this.data = data;
            this.errors = errors;
            this.exceptions = exceptions;
        }
    }
}
