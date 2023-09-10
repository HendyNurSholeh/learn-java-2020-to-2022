package programmer.zaman.now.classes;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesApp {
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("application.properties"));
            String name = properties.getProperty("Database.name");
            String password = properties.getProperty("Database.password");
            System.out.println(name);
            System.out.println(password);
            properties.put("Database.host", "hime-hime");
            properties.store(new FileOutputStream("application.properties"),"");
        }catch (FileNotFoundException exception){
            System.out.println("Gagal menemukan file");
        }catch (IOException exception){
            System.out.println("Gagal meload file");
        }

        try {
            Properties properties = new Properties();
            properties.put("Database.nama", "hendy");
            properties.put("Database.password", "kacang ijo");
            properties.store(new FileOutputStream("telor.properties"),"Database telor");
        }catch (FileNotFoundException exception){
            System.out.println("Gagal menemukan file");
        }catch (IOException exception){
            System.out.println("Gagal memasukkan file");
        }

    }

}
