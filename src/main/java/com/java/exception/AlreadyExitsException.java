package com.java.exception;
//Student with same roll number should not exist. If the user is repeating the roll no then throw this exception.
public class AlreadyExitsException extends RuntimeException
{
    public AlreadyExitsException(String str)
    {
        super(str);
    }
}
