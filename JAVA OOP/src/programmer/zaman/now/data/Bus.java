package programmer.zaman.now.data;

public class Bus implements Car {
    public void drive() {
        System.out.println("Bus drive");
    }


    public int getTier() {
        return 8;
    }

    public String getBrand() {
        return "Hino";
    }

    public boolean isMaintenance() {
        return false;
    }

    public void isBig() {
        System.out.println("his");
    }
}
