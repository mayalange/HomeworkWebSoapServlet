package com.example.service;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

@Data
@XmlRootElement(name = "book", namespace = "http://service.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "book", propOrder = {
        "title",
        "author",
        "publishedYear",
        "genre"
})
public class BookDTO {
    @XmlElement(namespace = "http://service.example.com/")
    private String title;

    @XmlElement(namespace = "http://service.example.com/")
    private String author;

    @XmlElement(namespace = "http://service.example.com/")
    private int publishedYear;

    @XmlElement(namespace = "http://service.example.com/")
    private String genre;

    public BookDTO() {
    }

    public BookDTO(String title, String author, int publishedYear, String genre) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.genre = genre;
    }
}
