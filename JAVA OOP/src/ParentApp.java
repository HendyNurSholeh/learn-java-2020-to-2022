public class ParentApp {
    public static void main(String[] args) {

        Child child = new Child();
        child.name = "Eko";
        child.doIt();
        System.out.println(child.name);
        // VARIABEL HIDDING
        // ketika membuat variabel yang sama dengan paren class, maka
        // saat di cast akan menjadi masalah
        // cara mengatasinya adalah dengan menggunakan super.name
        Parent parent = child;
        parent.doIt();
        System.out.println(parent.name);
    }
}
