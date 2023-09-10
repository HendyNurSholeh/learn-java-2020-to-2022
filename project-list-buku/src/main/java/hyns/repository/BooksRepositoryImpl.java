package hyns.repository;

import hyns.entity.Books;
import hyns.utility.ConnectorUtil;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BooksRepositoryImpl implements BooksRepository{

    DataSource dataSource;

    public BooksRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Books> getAll(){
        String sql = "select * from books";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql))
        {
            List<Books> allData = new ArrayList<>();
            while (resultSet.next()){
                allData.add(new Books(
                        resultSet.getInt("id"),
                        resultSet.getInt("tahun"),
                        resultSet.getString("judul"),
                        resultSet.getString("penulis"),
                        resultSet.getString("penerbit")
                ));
            }
            return allData;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean insertBook(Books book){
        if (isDuplicateBook(book)) {
            return false;
        } else {
            String sql = """
                    insert into books(tahun, judul, penulis, penerbit)
                    values(?, ?, ?, ?)
                    """;
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                Integer tahun = book.getTahun();
                String judul = book.getJudul().toLowerCase();
                String penulis = book.getPenulis().toLowerCase();
                String penerbit = book.getPenerbit();
                preparedStatement.setInt(1, tahun);
                preparedStatement.setString(2, judul);
                preparedStatement.setString(3, penulis);
                preparedStatement.setString(4, penerbit);
                preparedStatement.executeUpdate();
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    while (resultSet.next()) {
                        book.setId(resultSet.getInt(1));
                    }
                }
                return true;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void deleteBookById(Integer id){
        String sql = "delete from Books where id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Books> searchBooks(String search){
        List<Books> outputSearch = new ArrayList<>();
        String sql = """
                select * from books where match(judul, penulis, penerbit) 
                against(? in natural language mode)
                """;
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            preparedStatement.setString(1, search);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()){
                    outputSearch.add(new Books(
                            resultSet.getInt("id"),
                            resultSet.getInt("tahun"),
                            resultSet.getString("judul"),
                            resultSet.getString("penulis"),
                            resultSet.getString("penerbit")
                    ));
                }
                return outputSearch;
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean updateBookById(Books newBook) {
        if (isDuplicateBook(newBook)) {
            return false;
        }
        String sql = """
                update books 
                set tahun = ?, judul = ?, penulis = ?, penerbit = ?
                where id = ?
                """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setInt(1, newBook.getTahun());
            preparedStatement.setString(2, newBook.getJudul());
            preparedStatement.setString(3, newBook.getPenulis());
            preparedStatement.setString(4, newBook.getPenerbit());
            preparedStatement.setInt(5, newBook.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public boolean isDuplicateBook(Books book){
        String sql = "select * from books where judul = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            preparedStatement.setString(1, book.getJudul());
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    // kalau idnya ada berarti melakukan update, takpapa jika judul sama/tak diubah
                    if(book.getId() == null){
                        return true;
                    }
                }
            }
            return false;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


}
