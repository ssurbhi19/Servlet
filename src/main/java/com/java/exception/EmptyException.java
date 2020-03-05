package com.java.exception;
//If the user has left any of the field empty then throw this exception
public class EmptyException extends Exception
{
    public EmptyException(String str)
    {
        super(str);
    }
}
