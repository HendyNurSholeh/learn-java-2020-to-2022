public class PolymorphismApp {
    public static void main(String[] args) {


        Employee employee = new Employee("Eko");
        employee.sayHello("Budi");


        employee = new Manager("Eko");
        employee.sayHello("Budi");

        employee = new VicePresident("Eko");
        employee.sayHello("Budi");


        sayHello(new VicePresident("Budi"));
        sayHello(new Manager("Joko"));
        sayHello(new Employee("Eko"));

    }

    static void sayHello(Employee employee){
        if (employee instanceof VicePresident){
            VicePresident vicePresident = (VicePresident) employee;
            System.out.println("Hello VP "+vicePresident.name);
        }else if (employee instanceof Manager){
            Manager manager = (Manager) employee;
            System.out.println("Hello Manager "+ manager.name);
        }else {
            System.out.println("Hello "+employee.name);
        }
    }
}
