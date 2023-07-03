package com.example.mutsamarket.exceptions;

public class NotFoundItemException extends Status404Exception{
    public NotFoundItemException() {
        super("등록되지 않은 물품입니다.");
    }
}
