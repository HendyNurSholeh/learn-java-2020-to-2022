package hyns.listbook;

import hyns.listbook.entity.Books;
import hyns.listbook.repository.BooksRepository;
import hyns.listbook.repository.BooksRepositoryImpl;
import hyns.listbook.service.ListBooksServiceImpl;
import hyns.listbook.utility.ConnectorUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.*;

public class ListBooksServiceTest {

    DataSource dataSource = ConnectorUtil.getDataSource();
    private BooksRepository booksRepository = new BooksRepositoryImpl(dataSource);
    private ListBooksServiceImpl listBooksService;

    @BeforeEach
    void setUp() {
        listBooksService = new ListBooksServiceImpl(booksRepository);
    }

    @Test
    void addBooks() {
        Books book = new Books(0, 2018, "Kawan Lama", "carpentom", "geonime");
        listBooksService.addBooks(book);

        String sql = "select * from books where judul = 'kawan lama'";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql))
        {
            while (resultSet.next()){
                Assertions.assertTrue(resultSet.getString("judul").equals("kawan lama"));
                Assertions.assertEquals("kawan lama", resultSet.getString("judul"));
            }
        }catch (SQLException e){
            Assertions.fail(e);
        }
    }

    @Test
    void deleteBooks() {
        String sql = "select * from books order by id limit 1";
        String sqlCek = "select * from books where id = ?";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatementCek = connection.prepareStatement(sqlCek);
             ResultSet resultSet = statement.executeQuery(sql)
        ){
            while (resultSet.next()){
                preparedStatementCek.setInt(1, resultSet.getInt("id"));
            }
            listBooksService.deleteBooks(1); // delete book

            // cek hasil delete
            try (ResultSet resultSetCek = preparedStatementCek.executeQuery()){
                Assertions.assertFalse(resultSetCek.next());
                Assertions.assertEquals(false, resultSetCek.next());
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
