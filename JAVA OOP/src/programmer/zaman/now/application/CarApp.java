package programmer.zaman.now.application;

import programmer.zaman.now.data.Avanza;
import programmer.zaman.now.data.Car;
import programmer.zaman.now.data.Category;

public class CarApp {
    public static void main(String[] args) {
        Car car = new Avanza();
        System.out.println(car.getTier());
        car.drive();

    }
}
