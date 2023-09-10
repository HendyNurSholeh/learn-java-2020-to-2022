package hyns.listbook.view;

import hyns.listbook.entity.Books;
import hyns.listbook.service.ListBooksService;
import hyns.listbook.utility.ConvertUtil;
import hyns.listbook.utility.InputUtil;
import hyns.listbook.utility.PrintUtil;
import hyns.listbook.utility.ValidationUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ListBooksView {

    private ListBooksService listBooksService;


    public ListBooksView(ListBooksService listBooksService) {
        this.listBooksService = listBooksService;
    }

    public void showApp() {
        Boolean isContinue = true;
        do {
            log.info("\nAPLIKASI PERPUSTAKAAN BUKU");
            log.info("1. Melihat Seluruh Buku");
            log.info("2. Menambah Buku");
            log.info("3. Menghapus Buku");
            log.info("4. Cari Buku");
            log.info("5. Memperbarui Buku");
            log.info("x. Keluar");
            String pilihan = InputUtil.inputUser("Masukkan pilihan");
            switch (pilihan) {
                case "1":
                    listAllBooks();
                    break;
                case "2":
                    addBooks();
                    break;
                case "3":
                    deleteBooks();
                    break;
                case "4":
                    searchBooks();
                    break;
                case "5":
                    updateBooks();
                    break;
                case "x":
                    return;
                default:
                    log.info("input tidak dimengerti!!");
                    continue;
            }
            isContinue = InputUtil.inputYesOrNo("Apakah anda ingin melanjutkan (y/n)");
        } while (isContinue);
    }

    public void listAllBooks(){
        List<Books> allBooks = listBooksService.listAllBooks();
        PrintUtil.showBooks(allBooks);
    }

    public void addBooks(){
        log.info("MENAMBAH BUKU");
        // mengambil input user
        Integer tahunInt = InputUtil.inputTahun("Masukkan tahun terbit buku (yyyy)");
        String judul = InputUtil.inputUser("Masukkan judul buku              ");
        String penulis = InputUtil.inputUser("Masukkan penulis buku            ");
        String penerbit = InputUtil.inputUser("Masukkan penerbit buku           ");

        log.info("\n--Data Buku--");
        log.info("Judul    : {}", judul);
        log.info("Tahun    : {}", tahunInt);
        log.info("Penulis  : {}", penulis);
        log.info("Penerbit : {}", penerbit);
        while (true){
            String input = InputUtil.inputUser("Apakah anda yakin ingin menambahkan buku ini (y/n)");
            if (input.equalsIgnoreCase("y")){
                var book = new Books(0, tahunInt, judul, penulis, penerbit);
                boolean validate = ValidationUtil.validate(book, "Gagal menambahkan buku");
                if (validate) listBooksService.addBooks(book);
            }else if (input.equalsIgnoreCase("n")){
                log.info("Menambah Buku dibatalkan");
            }else {
                // input salah, melanjutkan perulangan
                log.info("Input tidak dimengerti");
                continue;
            }
            break;
        }
    }

    public void deleteBooks(){
        listAllBooks();
        log.info("MENGHAPUS BUKU");
        String input = InputUtil.inputUser("Masukkan no todolist (x jika batal)");
        if (!input.equalsIgnoreCase("x")){
            Integer intInput = ConvertUtil.stringToInteger(input, "Masukkan no todolist (x jika batal)", "x");
            if (intInput == null){
                // gagal menghapus buku
                return;
            }
            listBooksService.deleteBooks(intInput);
        }

    }

    public void searchBooks(){
        String inputUser = InputUtil.inputUser("Masukkan kata kunci buku (x jika batal)");
        if (!inputUser.equals("x")){
            List<Books> booksList = listBooksService.searchBooks(inputUser);
            if (booksList.isEmpty()){
                log.info("Buku dengan kata kunci yang anda cari tidak ada");
            } else {
                log.info("\nBuku yang mungkin anda cari");
                PrintUtil.showBooks(booksList);
            }
        }
        // batal
    }

    public void updateBooks(){
        listAllBooks();
        log.info("MENGUBAH BUKU");
        String input = InputUtil.inputUser("Masukkan no todolist (x jika batal)");
        if (!input.equalsIgnoreCase("x")){
            // bisa menghasilkan null pd saat convert
            Integer noTodo = ConvertUtil.stringToInteger(input, "Masukkan no todolist (x jika batal)", "x");
            if (noTodo == null) {
                // gagal mengupdate buku
                return;
            }
            listBooksService.updateBooks(noTodo);
        }
    }
}
