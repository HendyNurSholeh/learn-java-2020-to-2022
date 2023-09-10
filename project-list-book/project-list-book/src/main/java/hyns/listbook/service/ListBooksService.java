package hyns.listbook.service;

import hyns.listbook.entity.Books;

import java.util.List;

public interface ListBooksService {

    List<Books> listAllBooks();

    void addBooks(Books book);

    void deleteBooks(Integer noTodo);

    List<Books> searchBooks(String search);

    void updateBooks(Integer noTodo);

}
