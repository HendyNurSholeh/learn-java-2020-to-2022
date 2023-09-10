package programer.zaman.now.classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class propertiesApp {
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("aplication.properties"));


            String host = properties.getProperty("database.host");
            String port = properties.getProperty("database.port");
            String username = properties.getProperty("database.username");
            String password = properties.getProperty("database.password");

            System.out.println(host);
            System.out.println(port);
            System.out.println(username);
            System.out.println(password);
        }catch (FileNotFoundException exception){
            System.out.println(exception);
        }catch (IOException exception){
        }

        try{
            Properties properties = new Properties();
            properties.put("name.first","Eko");
            properties.put("name.middle","Kurniawan");
            properties.put("name.last","Khannedy");

            properties.store(new FileOutputStream("name.properties"),"Konfigurasi nama");
        }catch (FileNotFoundException exception){
            System.out.println("Eror membuat file properties");
        }catch (IOException exception){
            System.out.println("Eror menyimpan properties");
        }
    }
}
