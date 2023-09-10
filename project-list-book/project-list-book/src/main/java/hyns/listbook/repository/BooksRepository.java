package hyns.listbook.repository;

import hyns.listbook.entity.Books;
import lombok.SneakyThrows;

import java.util.List;

public interface BooksRepository {

    List<Books> getAll();

    Boolean insertBook(Books book);

    Boolean deleteBookById(Integer id);

    List<Books> searchBooks(String search);

    Boolean updateBook(Books book);

}
