package com.msvc.books.exception;

public class BookOutOfStockException extends RuntimeException{
    public BookOutOfStockException(String message) {
        super(message);
    }
}
