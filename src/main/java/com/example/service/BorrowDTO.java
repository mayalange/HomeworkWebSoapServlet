package com.example.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Date;

@XmlRootElement(name = "borrowBook", namespace = "http://example.com/service")
@XmlAccessorType(XmlAccessType.FIELD)
public class BorrowDTO {

    @XmlElement(namespace = "http://example.com/service")
    int bookId;

    @XmlElement(namespace = "http://example.com/service")
    int readerId;

    @XmlElement(namespace = "http://example.com/service")
    Date borrowDate;

    @XmlElement(namespace = "http://example.com/service")
    Date returnDate;

    @XmlElement(namespace = "http://example.com/service")
    String status;

    public BorrowDTO(int bookId, int readerId, Date borrowDate, Date returnDate, String status) {
        this.bookId = bookId;
        this.readerId = readerId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public BorrowDTO(){};

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}