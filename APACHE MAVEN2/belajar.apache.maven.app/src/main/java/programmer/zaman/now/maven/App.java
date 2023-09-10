package programmer.zaman.now.maven;

import com.google.gson.Gson;

import java.util.Collection;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        Gson gson = new Gson();
        Person person = new Person("hendy");
        String gsonPerson = gson.toJson(person);
        System.out.println(gsonPerson);

        System.out.print("Input your name : ");
        String name = scanner.nextLine();
        System.out.print("Input your address : ");
        String address = scanner.nextLine();
        System.out.print("What is your hobby : ");
        String hobby = scanner.nextLine();
        System.out.print("How old are you : ");
        Integer old = scanner.nextInt();

        System.out.println("Your name is " + name);
        System.out.println("Your address is " + address);
        System.out.println("Your hobby is " + hobby);
        System.out.println("Your old is " + old);





    }
}
