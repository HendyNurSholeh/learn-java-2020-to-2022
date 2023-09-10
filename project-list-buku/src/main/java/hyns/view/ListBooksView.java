package hyns.view;

import hyns.entity.Books;
import hyns.service.ListBooksService;
import hyns.utility.ConvertUtil;
import hyns.utility.InputUtil;
import hyns.utility.PrintUtil;
import hyns.utility.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

public class ListBooksView {

    private ListBooksService listBooksService;


    public ListBooksView(ListBooksService listBooksService) {
        this.listBooksService = listBooksService;
    }

    public void showApp() {
        Boolean isContinue = true;
        do {
            System.out.println("\nAPLIKASI PERPUSTAKAAN BUKU");
            System.out.println("1. Melihat Seluruh Buku");
            System.out.println("2. Menambah Buku");
            System.out.println("3. Menghapus Buku");
            System.out.println("4. Cari Buku");
            System.out.println("5. Memperbarui Buku");
            System.out.println("x. Keluar");
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
                    System.out.println("input tidak dimengerti!!");
                    pilihan = InputUtil.inputUser("Masukkan pilihan");
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
        System.out.println("MENAMBAH BUKU");
        // mengambil input user
        Integer tahunInt = InputUtil.inputTahun("Masukkan tahun terbit buku (yyyy)");
        String judul = InputUtil.inputUser("Masukkan judul buku              ");
        String penulis = InputUtil.inputUser("Masukkan penulis buku            ");
        String penerbit = InputUtil.inputUser("Masukkan penerbit buku           ");


        System.out.println("\n--Data Buku--");
        System.out.println("Judul    : " + judul);
        System.out.println("Tahun    : " + tahunInt);
        System.out.println("Penulis  : " + penulis);
        System.out.println("Penerbit : " + penerbit);
        while (true){
            String input = InputUtil.inputUser("Apakah anda yakin ingin menambahkan buku ini (y/n)");
            if (input.equalsIgnoreCase("y")){
                var book = new Books(tahunInt, judul, penulis, penerbit);
                boolean validate = ValidationUtil.validate(book, "Gagal menambahkan buku");
                if (validate) listBooksService.addBooks(book);
            }else if (input.equalsIgnoreCase("n")){
                System.out.println("Menambah Buku dibatalkan");
            }else {
                // input salah, melanjutkan perulangan
                System.out.println("Input tidak dimengerti");
                continue;
            }
            break;
        }
    }

    public void deleteBooks(){
        listAllBooks();
        System.out.println("MENGHAPUS BUKU");
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
                System.out.println("Buku dengan kata kunci yang anda cari tidak ada");
            } else {
                System.out.println("\nBuku yang mungkin anda cari");
                PrintUtil.showBooks(booksList);
            }
        }
        // batal
    }

    public void updateBooks(){
        listAllBooks();
        System.out.println("MENGUBAH BUKU");
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
