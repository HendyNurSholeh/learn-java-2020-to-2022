package hyns;

import hyns.entity.Books;
import hyns.repository.BooksRepository;
import hyns.repository.BooksRepositoryImpl;
import hyns.utility.ConnectorUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BooksRepositoryImplTest {

    DataSource dataSource = ConnectorUtil.getDataSource();
    BooksRepository booksRepository;

    @BeforeEach
    void setUp() {
        booksRepository = new BooksRepositoryImpl(dataSource);
    }

    @Test
    void getAll() {
        List<Books> all = booksRepository.getAll();
        Assertions.assertNotNull(all);
    }

    @Test
    void insertBook() {
        String sql = "select * from books where penulis = 'kkn desa kenari'";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql))
        {
            Books book = new Books(2020, "kkn desa kenari", "hendy nur sholeh", "gramedia");
            booksRepository.insertBook(book);
            while (resultSet.next()){
                Assertions.assertEquals("kkn desa kenari", resultSet.getString("judul"));
            }
        }catch (SQLException e){
            Assertions.fail(e);
        }
    }

    @Test
    void deleteBookById() {
        String sql = """
                select * from books 
                order by id desc limit 1""";
        String sqlcek = "select * from books where id = ?";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatementCek = connection.prepareStatement(sqlcek);
             ResultSet resultSet = statement.executeQuery(sql)
        ){
            while (resultSet.next()){
                booksRepository.deleteBookById(resultSet.getInt("id")); // delete book
                preparedStatementCek.setInt(1, resultSet.getInt("id"));
            }

            // cek hasil delete
            try (ResultSet resultSetCek = preparedStatementCek.executeQuery()){
                Assertions.assertEquals(false, resultSetCek.next());
                Assertions.assertFalse(resultSetCek.next());
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Test
    void updateBook() {
        Books book = new Books(10, 1900, "bicara itu...", "muhammad ali", "grammedia");
        booksRepository.updateBookById(book);
        // cek hasil
        String sql = "select * from books where id = " + book.getId();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);
        ){
            if (resultSet.next()){
                Assertions.assertEquals(book.getTahun(), resultSet.getInt("tahun"));
                Assertions.assertEquals(book.getJudul(), resultSet.getString("judul"));
                Assertions.assertEquals(book.getPenulis(), resultSet.getString("penulis"));
                Assertions.assertEquals(book.getPenerbit(), resultSet.getString("penerbit"));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Test
    void searchBooks() {
        List<Books> booksList = booksRepository.getAll();
        Assumptions.assumeFalse(booksList.isEmpty(), "test dibatalkan database kosong");
        if (!booksList.isEmpty()){
            Books bookSearch = booksList.get(0);
            String judulSearch = bookSearch.getJudul();

            List<Books> booksOutput= booksRepository.searchBooks(judulSearch);
            Assertions.assertFalse(booksOutput.isEmpty());
            boolean isMatch = booksOutput.stream().map(value -> value.getJudul()).anyMatch(value -> value.equals(judulSearch));
            Assertions.assertTrue(isMatch);
        }
    }

    @Test
    void searchBooksNotFound() {
        List<Books> booksOutput= booksRepository.searchBooks("xxcvsalah");
        Assertions.assertTrue(booksOutput.isEmpty());
    }

}
