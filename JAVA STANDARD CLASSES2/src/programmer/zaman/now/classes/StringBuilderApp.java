package programmer.zaman.now.classes;

public class StringBuilderApp {
    public static void main(String[] args) {
        StringBuilder name = new StringBuilder();
        name.append("hendy");
        name.append(" ");
        name.append("Nur");
        name.append(" ");
        StringBuilder names = name.append("Sholeh");
        System.out.println(name);
        System.out.println(names);
        System.out.println(name.capacity());
        String string = "hendy Nur Sholeh";
        String stringName = name.toString();
        System.out.println(stringName.equals(string));
        System.out.println(stringName.hashCode());
        System.out.println(string.hashCode());

        var name2 = "hendy";
        System.out.println(name2.hashCode());
        name2 = name2 + " Nur Sholeh";
        System.out.println(name2.hashCode());
    }
}
