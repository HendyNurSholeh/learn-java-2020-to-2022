package hyns.listbook.repository;


import hyns.listbook.entity.Books;
import lombok.Cleanup;
import lombok.SneakyThrows;

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
    @SneakyThrows
    public List<Books> getAll(){
        String sql = "select * from books";
        @Cleanup Connection connection = dataSource.getConnection();
        @Cleanup Statement statement = connection.createStatement();
        @Cleanup ResultSet resultSet = statement.executeQuery(sql);
        List<Books> booksListTemplate = new ArrayList<>();
        while (resultSet.next()){
            booksListTemplate.add(new Books(
                    resultSet.getInt("id"),
                    resultSet.getInt("tahun"),
                    resultSet.getString("judul"),
                    resultSet.getString("penulis"),
                    resultSet.getString("penerbit")
            ));
        }
        return booksListTemplate;
    }

    @Override
    @SneakyThrows
    public Boolean insertBook(Books newBook){
        if (isDuplicateByJudul(newBook)) return false;
        String sql = """
                insert into books(tahun, judul, penulis, penerbit) 
                values(?, ?, ?, ?)
                """;
        @Cleanup Connection connection = dataSource.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        Integer tahun = newBook.getTahun();
        String judul = newBook.getJudul().toLowerCase();
        String penulis = newBook.getPenulis().toLowerCase();
        String penerbit = newBook.getPenerbit().toLowerCase();
        preparedStatement.setInt(1, tahun);
        preparedStatement.setString(2, judul);
        preparedStatement.setString(3, penulis);
        preparedStatement.setString(4, penerbit);
        preparedStatement.executeUpdate();
        @Cleanup ResultSet resultSet = preparedStatement.getGeneratedKeys();
        while (resultSet.next()) {
            newBook.setId(resultSet.getInt(1));
        }
        return true;
    }

    @Override
    @SneakyThrows
    public Boolean deleteBookById(Integer id){
        String sql = "delete from Books where id = ?";
        @Cleanup Connection connection = dataSource.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int isSuccess = preparedStatement.executeUpdate();
        if (isSuccess >= 1) return true;
        return false;
    }

    @Override
    @SneakyThrows
    public List<Books> searchBooks(String search){
        List<Books> outputSearch = new ArrayList<>();
        String sql = """
                select * from books where match(judul, penulis, penerbit) 
                against(? in natural language mode)
                """;
        @Cleanup Connection connection = dataSource.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, search);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
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

    @Override
    @SneakyThrows
    public Boolean updateBook(Books newBook) {
        if (isDuplicateByJudul(newBook)) return false;
        String sql = """
                update books 
                set tahun = ?, judul = ?, penulis = ?, penerbit = ?
                where id = ?
                """;
        @Cleanup Connection connection = dataSource.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, newBook.getTahun());
        preparedStatement.setString(2, newBook.getJudul());
        preparedStatement.setString(3, newBook.getPenulis());
        preparedStatement.setString(4, newBook.getPenerbit());
        preparedStatement.setInt(5, newBook.getId());
        preparedStatement.executeUpdate();
        return true;
    }

    @SneakyThrows
    public boolean isDuplicateByJudul(Books book){
        String sql = "select * from books where judul = ?";
        @Cleanup Connection connection = dataSource.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, book.getJudul());
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            if(book.getId().equals(resultSet.getInt("id"))){
                // berarti melakukan update, tidak apa-apa jika judul sama/tak diubah
            }else {
                return true;
            }
        }
        return false;
    }


}
