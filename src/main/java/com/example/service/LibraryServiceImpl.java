package com.example.service;

import jakarta.annotation.Resource;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@WebService(
        endpointInterface = "com.example.service.LibraryService",
        targetNamespace = "http://example.com/service"
)public class LibraryServiceImpl implements LibraryService {
    private static final String url = "jdbc:postgresql://localhost:5432/lesson_networks_db";
    private static final String user = "admin";
    private static final String password = "admin";

    static {
        try {
            Class.forName("org.postgresql.Driver");
            try (Connection testConn = DriverManager.getConnection(url, user, password)) {
                System.out.println("Connected to database successfully!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Database initialization failed", e);
        }
    }

    @Override
    public void addBook(@WebParam(name = "book", targetNamespace = "http://example.com/service") BookDTO book) {
        String sql = "INSERT INTO \"mySchema\".books (title, author, published_year, genre) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getPublishedYear());
            statement.setString(4, book.getGenre());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Database error: " + e.getMessage(), e);
        }


    }
    @Override
    public void addReader(ReaderDTO reader) {

    }

    @Override
    public void borrowBook(BorrowDTO borrow) {

    }

    @Override
    public List<BookDTO> getBorrowedBooksByReaderId(int readerId) {
        return List.of();
    }
}