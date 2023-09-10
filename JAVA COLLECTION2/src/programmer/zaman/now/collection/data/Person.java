package programmer.zaman.now.collection.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person{
    private String name;
    private List<String> hobbies;

    public Person(String name) {
        this.name = name;
        this.hobbies = new ArrayList<>();
    }

    public void addHobby(String hobby){
        hobbies.add(hobby);
    }

    public List<String> getHobbies() {
        return Collections.unmodifiableList(hobbies);
    }

    public String getName() {
        return name;
    }

}
