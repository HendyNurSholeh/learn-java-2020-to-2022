package programmer.zaman.now.generic.application;

import java.awt.dnd.DropTarget;

public class MultipleContraintApp {
    public static void main(String[] args) {
//        Data<Manager> managerData = new Data<Manager>(); // ERROR
        Data<VicePresident> vicePresidentData = new Data<>(new VicePresident());
    }

    public static interface CanSayHello{
        void sayHello(String name);
    }

    public static abstract class Employee{

    }

    public static class Manager extends Employee{
        String data;

        public Manager(String data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Manager{" +
                    "data='" + data + '\'' +
                    '}';
        }
    }

    public static class VicePresident extends Employee implements CanSayHello {

        @Override
        public void sayHello(String name) {
            System.out.println("Hello " + name);
        }
    }

    public static class Data<T extends Employee & CanSayHello>{
        T data;

        public Data(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}
