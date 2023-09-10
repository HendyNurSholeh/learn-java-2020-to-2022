package hyns;

import hyns.entity.Books;
import hyns.repository.BooksRepository;
import hyns.repository.BooksRepositoryImpl;
import hyns.service.ListBooksService;
import hyns.service.ListBooksServiceImpl;
import hyns.utility.ConnectorUtil;
import hyns.utility.PrintUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

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
        Books book = new Books(2018, "Kawan Lama", "carpentom", "geonime");
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
