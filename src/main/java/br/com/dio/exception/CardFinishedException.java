package br.com.dio.exception;

import javax.management.RuntimeMBeanException;

public class CardFinishedException extends RuntimeException {
    public CardFinishedException(String message) {
        super(message);
    }
}
