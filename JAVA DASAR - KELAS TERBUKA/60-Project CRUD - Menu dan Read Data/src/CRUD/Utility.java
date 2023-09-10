package CRUD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Year;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Utility {
    // default acces modifier
    static long ambilEntryPerTahun(String penulis,String tahun)throws IOException {
        FileReader fileInput = new FileReader("database.txt");
        BufferedReader bufferInput = new BufferedReader(fileInput);

        long entry = 0;
        String data = bufferInput.readLine();
        Scanner dataScanner;
        String primarykey;

        while (data != null){
            dataScanner = new Scanner(data);
            dataScanner.useDelimiter(",");
            primarykey = dataScanner.next();
            dataScanner = new Scanner(primarykey);
            dataScanner.useDelimiter("_");

            penulis = penulis.replaceAll("\\s+","");
            if(penulis.equalsIgnoreCase(dataScanner.next()) && tahun.equalsIgnoreCase(dataScanner.next())){
                entry = dataScanner.nextInt();
            }

            data = bufferInput.readLine();
        }
        return entry;
    }

    static boolean cekBukuDiDatabase (String [] keywords,boolean isDisplay) throws IOException{

        FileReader fileInput = new FileReader("database.txt");
        BufferedReader bufferedInput = new BufferedReader(fileInput);

        String data = bufferedInput.readLine();
        boolean isExist = false;
        int nomorData = 0;

        if (isDisplay) {
            System.out.println("\n| No |\tTahun |\tPenulis               |\tPenerbit              |\tJudul Buku");
            System.out.println("-------------------------------------------------------------------------------");
        }

        while (data != null){

            // cek keywords di dalam baris
            isExist = true;

            for (String keyword : keywords){
                isExist = isExist && data.toLowerCase(Locale.ROOT).contains(keyword.toLowerCase(Locale.ROOT));
            }

            // jika keywordsnya cocok maka tampilkan
            if (isExist){
                if(isDisplay) {
                    nomorData++;
                    StringTokenizer stringtoken = new StringTokenizer(data, ",");
                    stringtoken.nextToken();

                    System.out.printf("|%2d  ", nomorData);
                    System.out.printf("|\t%4s  ", stringtoken.nextToken());
                    System.out.printf("|\t%-20s  ", stringtoken.nextToken());
                    System.out.printf("|\t%-20s  ", stringtoken.nextToken());
                    System.out.printf("|\t%s  ", stringtoken.nextToken());
                    System.out.print("\n");
                }else {
                    break;
                }
            }

            data = bufferedInput.readLine();
        }
        if (isDisplay) {
            System.out.println("-------------------------------------------------------------------------------");
        }
        return isExist;
    }

    public static boolean getYesorNo(String message){
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("\n"+message +"(y/n)? ");
        String pilihanUser = terminalInput.next();

        while (!pilihanUser.equalsIgnoreCase("y") && !pilihanUser.equalsIgnoreCase("n") ){
            System.err.println("pilihan anda bukan y atau n");
            System.out.print("\n"+message+"(y/n)? ");
            pilihanUser = terminalInput.next();
        }
        return pilihanUser.equalsIgnoreCase("y");
    }

    public static void clearScreen(){
        try{
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            }else {
                System.out.println("\033\143");
            }
        }catch (Exception ex){
            System.out.println("tidak bisa clear screen");
        }
    }

    protected static String ambilTahun() throws IOException{
        boolean tahunValid = true;
        Scanner terminalInput = new Scanner(System.in);
        String tahunInput = terminalInput.nextLine();
        while (tahunValid) {
            try {
                Year.parse(tahunInput);
                tahunValid = false;
            } catch (Exception e) {
                System.out.println("Format tahun yang anda masukan salah, format=(YYYY)");
                System.out.print("silahkan masukan tahun lagi: ");
                tahunInput  = terminalInput.nextLine();
            }
        }
        return tahunInput;
    }
}
