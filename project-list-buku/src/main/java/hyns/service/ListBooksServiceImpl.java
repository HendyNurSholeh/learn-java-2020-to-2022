package hyns.service;

import hyns.entity.Books;
import hyns.repository.BooksRepository;
import hyns.utility.ConvertUtil;
import hyns.utility.InputUtil;
import hyns.utility.PrintUtil;
import hyns.utility.ValidationUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class ListBooksServiceImpl implements ListBooksService{

    private BooksRepository booksRepository;

    public ListBooksServiceImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public List<Books> listAllBooks(){
        List<Books> allBooks = booksRepository.getAll();
        return allBooks;
    }

    @Override
    public void addBooks(Books book) {
        Boolean isSuccess = booksRepository.insertBook(book);
        if (isSuccess){
            log.info("Sukses menambahkan buku");
        }else {
            log.info("Gagal menambahkan buku");
            log.info("Buku yang anda masukkan sudah ada");
        }
    }

    @Override
    public void deleteBooks(Integer noTodo) {
        List<Books> all = booksRepository.getAll();

        if ( noTodo > all.size() || noTodo <= 0){
            log.info("Gagal menghapus Todo List");
            log.info("Nomor yang anda masukkan tidak ada");
        }else {
            Books book = all.get(noTodo - 1);
            log.info("\n--Data Buku--");
            log.info("Tahun    : {}", book.getTahun());
            log.info("Judul    : {}", book.getJudul());
            log.info("Penulis  : {}", book.getPenulis());
            log.info("Penerbit : {}", book.getPenerbit());
            boolean yesOrNo = InputUtil.inputYesOrNo("Apakah anda yakin menghapus buku ini (y/n)");
            if (yesOrNo){
                booksRepository.deleteBookById(book.getId());
                log.info("Berhasil menghapus buku");
            }else {
                log.info("Menghapus buku dibatalkan");
            }
        }
    }

    @Override
    public List<Books> searchBooks(String search) {
        List<Books> booksList = booksRepository.searchBooks(search);
        return booksList;
    }
    @Override
    public void updateBooks(Integer noTodo) {
        List<Books> all = booksRepository.getAll();

        if (noTodo > all.size() || noTodo <= 0) {
            log.info("Gagal menghapus Todo List");
            log.info("Nomor yang anda masukkan tidak ada");
        } else {
            Books book = all.get(noTodo - 1);

            log.info("\n--Data Buku--");
            log.info("Tahun    : {}", book.getTahun());
            log.info("Judul    : {}", book.getJudul());
            log.info("Penulis  : {}", book.getPenulis());
            log.info("Penerbit : {}", book.getPenerbit());
            Boolean isChange = InputUtil.inputYesOrNo("Apakah anda ingin mengubah data buku ini (y/n)");
            if (!isChange) {
                log.info("Mengubah buku dibatalkan");
            } else {
                String judul = InputUtil.inputUser("Masukkan judul buku                           ");
                Integer tahun = InputUtil.inputTahun("Masukkan tahun terbit buku (yyyy)             ");
                String penulis = InputUtil.inputUser("Masukkan penulis buku                         ");
                String penerbit = InputUtil.inputUser("Masukkan penerbit buku                        ");

                log.info("\n--Data Buku--");
                log.info("Tahun    : " + judul);
                System.out.println("Judul    : " + tahun);
                System.out.println("Penulis  : " + penulis);
                System.out.println("Penerbit : " + penerbit);
                Boolean isChangeFix = InputUtil.inputYesOrNo("Apakah anda yakin ingin merubahnya dengan data ini (y/n)");
                if (isChangeFix) {
                    book.setJudul(judul);
                    book.setTahun(tahun);
                    book.setPenulis(penulis);
                    book.setPenerbit(penerbit);
                    isChangeFix = ValidationUtil.validate(book, "Gagal mengupdate buku");
                    if (isChangeFix) {
                        boolean isSuccessUpdate = booksRepository.updateBookById(book);
                        if (isSuccessUpdate) {
                            System.out.println("Sukses mengupdate buku");
                        } else {
                            System.out.println("Gagal mengupdate buku");
                            System.out.println("Buku yang anda masukkan sudah ada");
                        }
                    }
                } else {
                    System.out.println("Menambah buku dibatalkan");
                }
            }
        }
    }
}
