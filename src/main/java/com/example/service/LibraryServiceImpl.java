package com.example.service;

import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebService(
        endpointInterface = "com.example.service.LibraryService",
        targetNamespace = "http://example.com/service"
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
    public void addReader(@WebParam(name = "reader", targetNamespace = "http://example.com/service") ReaderDTO reader) {
        String sql = "INSERT INTO \"mySchema\".readers (\"name\", email, phone) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, reader.getName());
            statement.setString(2, reader.getEmail());
            statement.setString(3, reader.getPhone());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Database error: " + e.getMessage(), e);
        }
    }

    @Override
    public void borrowBook(@WebParam(name = "borrowBook", targetNamespace = "http://example.com/service") BorrowDTO borrow) {
        String sql = "INSERT INTO \"mySchema\".borrowed_books (book_id, reader_id, borrow_date, return_date, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, borrow.getBookId());
            statement.setInt(2, borrow.getReaderId());
            statement.setDate(3, new java.sql.Date(borrow.getBorrowDate().getTime()));
            statement.setDate(4, new java.sql.Date(borrow.getReturnDate().getTime()));
            statement.setString(5, borrow.getStatus());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Database error: " + e.getMessage(), e);
        }
    }

    @Override
    public List<BookDTO> getBorrowedBooksByReaderId(@WebParam(name = "readerId", targetNamespace = "http://example.com/service") int readerId) {
        List<BookDTO> result = new ArrayList<>();
        String sql = "SELECT b.title, b.author, b.published_year, b.genre, bb.borrow_date, bb.status " +
                "FROM \"mySchema\".borrowed_books bb " +
                "JOIN \"mySchema\".books b ON bb.book_id = b.book_id " +
                "WHERE bb.reader_id = ? AND bb.status = 'borrowed'";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, readerId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                BookDTO book = new BookDTO();
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublishedYear(resultSet.getInt("published_year"));
                book.setGenre(resultSet.getString("genre"));

                result.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error: " + e.getMessage(), e);
        }
        return result;
    }
}