package com.example.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService(targetNamespace = "http://example.com/service")
public interface LibraryService {
    @WebMethod(operationName = "addBook")
    void addBook(@WebParam(name = "book", targetNamespace = "http://example.com/service") BookDTO book);

    @WebMethod
    void addReader(ReaderDTO reader);

    @WebMethod
    void borrowBook(BorrowDTO borrow);

    @WebMethod
    List<BookDTO> getBorrowedBooksByReaderId(int readerId);
}