package hyns.listbook;

import com.zaxxer.hikari.HikariDataSource;
import hyns.listbook.repository.BooksRepository;
import hyns.listbook.repository.BooksRepositoryImpl;
import hyns.listbook.service.ListBooksService;
import hyns.listbook.service.ListBooksServiceImpl;
import hyns.listbook.utility.ConnectorUtil;
import hyns.listbook.utility.ValidationUtil;
import hyns.listbook.view.ListBooksView;
import lombok.extern.slf4j.Slf4j;

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
