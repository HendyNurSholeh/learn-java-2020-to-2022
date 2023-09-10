package hyns;

import com.zaxxer.hikari.HikariDataSource;
import hyns.entity.Books;
import hyns.repository.BooksRepository;
import hyns.repository.BooksRepositoryImpl;
import hyns.service.ListBooksService;
import hyns.service.ListBooksServiceImpl;
import hyns.utility.ConnectorUtil;
import hyns.utility.ValidationUtil;
import hyns.view.ListBooksView;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        new ValidationUtil();
        HikariDataSource dataSource = ConnectorUtil.getDataSource();
        BooksRepository booksRepository = new BooksRepositoryImpl(dataSource);
        ListBooksService listBooksService = new ListBooksServiceImpl(booksRepository);
        ListBooksView listBooksView = new ListBooksView(listBooksService);
        listBooksView.showApp();
    }
}
