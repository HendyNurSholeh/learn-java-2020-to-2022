package hyns.repository;

import hyns.entity.Books;

import javax.sql.DataSource;
import java.util.List;

public interface BooksRepository {

    List<Books> getAll();

    Boolean insertBook(Books book);

    void deleteBookById(Integer id);

    List<Books> searchBooks(String search);

    Boolean updateBookById(Books book);

}
