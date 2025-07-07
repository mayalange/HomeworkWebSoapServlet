package com.example.service;

import lombok.Data;

import java.util.Date;

@Data
public class BorrowDTO {
    int bookId;
    int readerId;
    Date borrowDate;
    Date returnDate;
    String status;

    public BorrowDTO(int bookId, int readerId, Date borrowDate, Date returnDate, String status) {
        this.bookId = bookId;
        this.readerId = readerId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public BorrowDTO(){};
}
