package com.jakub_szalkowski.project.controllers.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Book {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String title;

    public String getTitle() 
    {
        return title;
    }

    public long getId() 
    {
        return id;
    }
    public void setId(long id) 
    {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() 
    {
        return "Book [id=]" + id + ", title" + title + "]";
    }
}