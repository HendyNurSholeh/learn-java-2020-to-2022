package programmer.zaman.now.application;

public class EqualsApp{
    public static void main(String[] args) {
        String first = "Eko";
        first = first + " " + "khannedy";

        System.out.println(first);

        String second = "Eko khannedy";
        System.out.println(second);

        System.out.println(first == second);
        System.out.println(second.equals(first));

        String third = "Eko khannedy";

        System.out.println(second == third);


    }
}
