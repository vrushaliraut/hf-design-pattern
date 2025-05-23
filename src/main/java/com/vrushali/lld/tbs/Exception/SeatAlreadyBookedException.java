package com.vrushali.lld.tbs.Exception;

public class SeatAlreadyBookedException extends  RuntimeException{
    public SeatAlreadyBookedException(String message) {
        super(message);
    }
}
