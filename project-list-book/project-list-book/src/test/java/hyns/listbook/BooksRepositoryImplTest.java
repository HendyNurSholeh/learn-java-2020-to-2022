package hyns.listbook;

import hyns.listbook.entity.Books;
import hyns.listbook.repository.BooksRepository;
import hyns.listbook.repository.BooksRepositoryImpl;
import hyns.listbook.utility.ConnectorUtil;
import lombok.Cleanup;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.UUID;


public class BooksRepositoryImplTest {

    DataSource dataSource = ConnectorUtil.getDataSource();
    BooksRepository booksRepository;

    @BeforeEach
    void setUp() {
        booksRepository = new BooksRepositoryImpl(dataSource);
    }

    @Test
    void getAllSuccess() {
        List<Books> all = booksRepository.getAll();
        assertTrue(!all.isEmpty());
    }

    @Test
    @SneakyThrows
    void insertBookSuccess() {
        var newBook = new Books(0, 2000, "testing", "testing", "testing");
        var randomJudul = UUID.randomUUID().toString().substring(1, 11);
        newBook.setJudul(randomJudul);
        Boolean isSuccess = booksRepository.insertBook(newBook);
        assertTrue(isSuccess);
        // cek database
        String sqlCek = "select * from books where judul = ?";
        @Cleanup Connection connection = dataSource.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sqlCek);
        preparedStatement.setString(1, randomJudul);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            assertEquals(randomJudul, resultSet.getString("judul"));
        }
    }

    @Test
    @SneakyThrows
    void insertBookFailedBecauseDuplicateBook() {
        List<Books> booksList = booksRepository.getAll();
        var duplicateJudul = booksList.get(booksList.size() - 1).getJudul();
        var book = new Books(0, 2000, "testing", "testing", "testing");
        book.setJudul(duplicateJudul);
        Boolean isSuccess = booksRepository.insertBook(book);
        assertFalse(isSuccess);
        // cek size books in database
        int sizeBooksBefore = booksList.size();
        int sizeBookAfter = booksRepository.getAll().size();
        assertEquals(sizeBooksBefore, sizeBookAfter);
    }

    @Test
    @SneakyThrows
    void deleteBookByIdSuccess() {
        List<Books> booksList = booksRepository.getAll();
        int idBook = booksList.get(booksList.size() - 1).getId();
        Boolean isSuccess = booksRepository.deleteBookById(idBook);// delete book
        assertTrue(isSuccess);
        // cek id book in database
        String sqlcek = "select * from books where id = ?";
        @Cleanup Connection connection = dataSource.getConnection();
        @Cleanup PreparedStatement preparedStatementCek = connection.prepareStatement(sqlcek);
        preparedStatementCek.setInt(1, idBook);
        @Cleanup ResultSet resultSetCek = preparedStatementCek.executeQuery();
        assertFalse(resultSetCek.next());
        assertNotEquals(booksList.size(), booksRepository.getAll().size()); // cek size before & after
    }

    @Test
    @SneakyThrows
    void deleteBookByIdFailedBecauseIdNotFound() {
        List<Books> booksList = booksRepository.getAll();
        int sizeBooksBefore = booksList.size();
        int idBook = -1;
        Boolean isSuccess = booksRepository.deleteBookById(idBook);// delete book
        assertFalse(isSuccess);
        // cek size database
        int sizeBooksAfter = booksList.size();
        assertEquals(sizeBooksBefore, sizeBooksAfter);
    }

    @Test
    @SneakyThrows
    void updateBookSuccess() {
        String randomString = UUID.randomUUID().toString().substring(1, 11);
        List<Books> booksList = booksRepository.getAll();
        var book = booksList.get(booksList.size()-1);
        book.setJudul(randomString);
        Boolean isSuccess = booksRepository.updateBook(book);
        assertTrue(isSuccess);
        // cek result
        String sql = "select * from books where id = " + book.getId();
        @Cleanup Connection connection = dataSource.getConnection();
        @Cleanup Statement statement = connection.createStatement();
        @Cleanup ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            assertEquals(book.getTahun(), resultSet.getInt("tahun"));
            assertEquals(book.getJudul(), resultSet.getString("judul"));
            assertEquals(book.getPenulis(), resultSet.getString("penulis"));
            assertEquals(book.getPenerbit(), resultSet.getString("penerbit"));
        }
    }

    @Test
    @SneakyThrows
    void updateBookFailedBecauseDuplicateBook() {
        List<Books> books = booksRepository.getAll();
        var duplicateJudul = books.get(1).getJudul();
        var book = books.get(0);
        book.setJudul(duplicateJudul);
        Boolean isSuccess = booksRepository.updateBook(book);
        assertFalse(isSuccess);
        // cek result
        String sql = "select * from books where id = " + book.getId();
        @Cleanup Connection connection = dataSource.getConnection();
        @Cleanup Statement statement = connection.createStatement();
        @Cleanup ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            assertNotEquals(book.getJudul(), resultSet.getString("judul"));
        }
    }

    @Test
    void searchBooks() {
        List<Books> booksList = booksRepository.getAll();
        assumeFalse(booksList.isEmpty(), "test dibatalkan database kosong");
        if (!booksList.isEmpty()){
            Books bookSearch = booksList.get(0);
            String judulSearch = bookSearch.getJudul();

            List<Books> booksOutput= booksRepository.searchBooks(judulSearch);
            assertFalse(booksOutput.isEmpty());
            boolean isMatch = booksOutput.stream().map(value -> value.getJudul()).anyMatch(value -> value.equals(judulSearch));
            assertTrue(isMatch);
        }
    }

    @Test
    void searchBooksNotFound() {
        List<Books> booksOutput= booksRepository.searchBooks("xxcvsalah");
        assertTrue(booksOutput.isEmpty());
    }

}
