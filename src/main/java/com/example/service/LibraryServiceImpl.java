package com.example.service;

import jakarta.annotation.Resource;
import jakarta.jws.WebService;
import jakarta.xml.ws.BindingType;
import jakarta.xml.ws.WebServiceContext;
import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;
import jakarta.xml.ws.soap.SOAPBinding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebService(
        serviceName = "LibraryServiceImplService",
        portName = "LibraryServiceImplPort",
        targetNamespace = "http://service.example.com/",
        endpointInterface = "com.example.service.LibraryService"
)
public class LibraryServiceImpl implements LibraryService {
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

    @Resource
    private WebServiceContext context;

    @Override
    public void addBook(BookDTO book) {

        System.out.println("Received book object: " + book);

        if (book == null) {
            System.err.println("Error: BookDTO is null");
            throw new IllegalArgumentException("Book data is required");
        }

        System.out.println("Processing book: " + book.getTitle());

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

    private void logRequestHeaders() {
        try {
            if (context != null && context.getMessageContext() != null) {
                Map<String, List<String>> headers =
                        (Map<String, List<String>>) context.getMessageContext()
                                .get(MessageContext.HTTP_REQUEST_HEADERS);
                System.out.println("Request headers: " + headers);
            }
        } catch (Exception e) {
            System.err.println("Error logging headers: " + e.getMessage());
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