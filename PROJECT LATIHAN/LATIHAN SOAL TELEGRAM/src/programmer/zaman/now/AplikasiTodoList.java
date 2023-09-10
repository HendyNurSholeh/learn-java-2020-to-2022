package programmer.zaman.now;
import java.util.Scanner;

public class AplikasiTodoList {
    public static String array[] = new String[10];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    public static void showTodoList(){
        System.out.println("\n---TODOLIST---");
        int nomor = 0;
        String template[] = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null){
                nomor = i+1;
                System.out.println(nomor + ". " + array[i]);
                if (i == (array.length - 1)){
                    for (int j = 0; j < array.length; j++) {
                        template[j] = array[j];
                    }
                    array = new String[array.length*2];
                    for (int j = 0; j < template.length; j++) {
                        array[j] = template[j];
                    }
                }
            }else if (nomor < 1){
                System.out.println("1. \n2.");
                System.out.println("*Todolist masih kosong*");
                System.out.println("*Tambahkan todolist terlebih dahulu*");
                break;
            }
        }
    }

    public static void testShowTodoList(){
        showTodoList();
    }

    public static void addTodoList(){
        String addList = scanner.nextLine();
        if (addList.equalsIgnoreCase("x")){
            System.out.println("*Menambahkan list dibatalkan*");
        }else{
            for (int i = 0; i < array.length; i++){
                if (array[i] == null){
                    array[i] = addList;
                    System.out.println("*Menambah todolist succes*");
                    break;
                }
            }
        }
        viewShowTodoList();
    }

    public static void testAddTodoList(){
        array[0] = "Makan";
        array[1] = "Makan";
        array[2] = "Makan";
        array[3] = "Makan";
        array[4] = "Makan";
        array[5] = "Makan";
        array[6] = "Makan";
        array[7] = "Makan";
        array[8] = "Makan";
        array[9] = "Makan";
        showTodoList();
        addTodoList();
        showTodoList();
        System.out.println(array.length);
    }

    public static void removeTodoList(Integer remove){
        if (array[remove - 1] == null){
            System.out.println("*Todolist sudah kosong*");
            System.out.println("*Tidak dapat melakukan penghapusan*");
        }else {
            array[remove-1] = null;
            System.out.println("*Todolist berhasil dihapus*");
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null) {
                    if (i > (remove - 1)) {
                        array[i - 1] = array[i];
                        array[i] = null;
                    }
                }
            }
        }
    }

    public static void testRemoveTodoList(){
        array[0] = "Makan1";
        array[1] = "Makan2";
        array[2] = "Makan3";
        array[3] = "Makan4";
        array[4] = "Makan5";
        array[5] = "Makan6";
        array[6] = "Makan7";
        array[7] = "Makan8";
        array[8] = "Makan9";
        showTodoList();
        removeTodoList(2);
        showTodoList();
    }



    public static void viewAddTodoList(){
        System.out.println("---MENAMBAH TODOLIST---");
        System.out.print("Masukkan todolist(x jika batal) : ");
        addTodoList();
    }

    public static void testViewAddTodoList(){
        viewAddTodoList();
        showTodoList();
    }

    public static void viewRemoveTodoList(){
        System.out.println("\n---MENGHAPUS TODOLIST---");
        System.out.print("Masukkan no todolist(x jika batal) : ");
        String remove = scanner.nextLine();
        if (remove.equalsIgnoreCase("x")){
            System.out.println("*Remove dibatalkan*");
        }else{
            removeTodoList(Integer.valueOf(remove));
        }
        viewShowTodoList();
    }

    public static void testViewRemoveTodoList(){
        array[0] = "Makan1";
        array[1] = "Makan2";
        array[2] = "Makan3";
        array[3] = "Makan4";
        array[4] = "Makan5";
        array[5] = "Makan6";
        array[6] = "Makan7";
        array[7] = "Makan8";
        array[8] = "Makan9";
        showTodoList();
        viewRemoveTodoList();
        showTodoList();
    }

    public static void viewShowTodoList(){
        showTodoList();
        System.out.println("\n1. Tambah  2. Hapus  3. Keluar");
        System.out.print("Apakah anda ingin tambah/hapus list (1/2/3) ? ");
        String mauKemana = scanner.nextLine();
        if (mauKemana.equals("1")){
            viewAddTodoList();
        }else if (mauKemana.equals("2")){
            viewRemoveTodoList();
        }else if (mauKemana.equals("3")){
            // program brakhir
        }else {
            System.out.println("*input tidak diketahui*");
        }
    }

    public static void testViewShowTodoList(){
        array[0] = "Makan1";
        array[1] = "Makan2";
        array[2] = "Makan3";
        array[3] = "Makan4";
        array[4] = "Makan5";
        array[5] = "Makan6";
        array[6] = "Makan7";
        array[7] = "Makan8";
        array[8] = "Makan9";
        viewShowTodoList();
    }

}
