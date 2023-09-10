package programmer.zaman.now.collection.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private List<String> hobbies;

    public Person(String name) {
        this.name = name;
        this.hobbies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addHobby(String Hobby){
        hobbies.add(Hobby);
    }

    public List<String> getHobbies(){
        return Collections.unmodifiableList(hobbies);
    }

}
