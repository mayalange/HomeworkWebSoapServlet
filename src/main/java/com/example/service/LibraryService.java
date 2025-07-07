package com.example.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface LibraryService {
    @WebMethod
    void addBook(BookDTO book);

    @WebMethod
    void addReader(ReaderDTO reader);

    @WebMethod
    void borrowBook(BorrowDTO borrow);

    @WebMethod
    List<BookDTO> getBorrowedBooksByReaderId(int readerId);
}