package programmer.zaman.now.data;

import programmer.zaman.now.anotation.Fancy;

@Fancy(name = "AnimalApp",tags = {"application","java"})
public enum Level {
    STANDARD("Standard level"),
    PREMIUM("Premium level"),
    VIP("Vip level");

    private String description;

    Level(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
