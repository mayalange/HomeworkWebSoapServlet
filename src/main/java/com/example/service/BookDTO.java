package com.example.service;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

@XmlRootElement(name = "book", namespace = "http://example.com/service")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookDTO {
    @XmlElement(namespace = "http://example.com/service")
    private String title;

    @XmlElement(namespace = "http://example.com/service")
    private String author;

    @XmlElement(namespace = "http://example.com/service")
    private int publishedYear;

    @XmlElement(namespace = "http://example.com/service")
    private String genre;

    public BookDTO() {
    }

    public BookDTO(String title, String author, int publishedYear, String genre) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
