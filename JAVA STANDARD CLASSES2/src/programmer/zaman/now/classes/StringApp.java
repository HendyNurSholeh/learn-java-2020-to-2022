package programmer.zaman.now.classes;

public class StringApp {
    public static void main(String[] args) {

        String name = "Eko Kurniawan Khannedy";
        String nameLowerCase = name.toLowerCase();
        String nameUpperCase = name.toUpperCase();
        String[] nameSplit = name.split(" ");

        System.out.println(name);
        System.out.println(nameLowerCase);
        System.out.println(nameUpperCase);
        for (var value:nameSplit) {
            System.out.println(value);
        }
        System.out.println(name.length());
        System.out.println(name.startsWith("Eko"));
        System.out.println(name.endsWith("Khannedy"));

        System.out.println(" ".isBlank());
        System.out.println(" ".isEmpty());
        System.out.println("".isEmpty());
        char charName = name.charAt(21);
        System.out.println(charName);
        char[] charsName = name.toCharArray();
        System.out.println(charsName);
        for (var value:charsName) {
            System.out.println(value);
        }
        int[] cobaArray = {1,2,3};
        System.out.println(cobaArray);

    }
}
