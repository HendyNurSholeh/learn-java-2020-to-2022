class Manager extends Employee {

    Manager(String name){
        super(name);
    }

    void sayHello(String name){
        System.out.println("Hi "+ name+", My Name Is Manager "+this.name);
    }

}
