package com.example.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService(targetNamespace = "http://example.com/service")
public interface LibraryService {
    @WebMethod(operationName = "addBook")
    void addBook(@WebParam(name = "book", targetNamespace = "http://example.com/service") BookDTO book);

    @WebMethod(operationName = "addReader")
    void addReader(@WebParam(name = "reader", targetNamespace = "http://example.com/service") ReaderDTO reader);

    @WebMethod(operationName = "borrowBook")
    void borrowBook(@WebParam(name = "borrowBook", targetNamespace = "http://example.com/service") BorrowDTO borrow);

    @WebMethod(operationName = "getBorrowedBooksByReaderId")
    List<BookDTO> getBorrowedBooksByReaderId(@WebParam(name = "readerId", targetNamespace = "http://example.com/service") int readerId);}