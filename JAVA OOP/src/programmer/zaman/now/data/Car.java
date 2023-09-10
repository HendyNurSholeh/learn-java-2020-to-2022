package programmer.zaman.now.data;

import programmer.zaman.now.anotation.Fancy;

@Fancy(name = "AnimalApp",tags = {"application","java"})
public interface Car extends HasBrand,IsMaintenance{

    void drive();
    int getTier();

    default void isBig() {
        System.out.println("h");
    }
}
