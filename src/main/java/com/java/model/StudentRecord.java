package com.java.model;
//POJO
public class StudentRecord
{
    private String name;
    private String university;

    public StudentRecord(String name, String university)
    {
        this.name=name;
        this.university = university;
    }

    public String getName()
    {
        return name;
    }

    public String getUniversity()
    {
        return university;
    }
    //
    @Override
    public String toString()
    {
        return "name='" + name + '\'' +
                ", univ='" + university + '\'';
    }
}
