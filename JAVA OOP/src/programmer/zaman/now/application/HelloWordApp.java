package programmer.zaman.now.application;

import programmer.zaman.now.data.HelloWord;

public class HelloWordApp {
    public static void main(String[] args) {

        HelloWord english = new HelloWord() {

            public void sayHello() {
                System.out.println("Hello");
            }

            public void sayHello(String name) {
                System.out.println("Hello "+name);
            }
        };
        HelloWord indonesia = new HelloWord() {

            public void sayHello() {
                System.out.println("Halo");
            }

            public void sayHello(String name) {
                System.out.println("Halo "+name);
            }
        };

        english.sayHello();
        english.sayHello("Eko");


        english.sayHello();
        indonesia.sayHello("Eko");
    }
}
