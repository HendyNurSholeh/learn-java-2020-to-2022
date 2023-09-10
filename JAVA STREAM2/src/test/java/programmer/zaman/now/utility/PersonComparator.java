package programmer.zaman.now.utility;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    Person person;
    @Override
    public int compare(Person o1, Person o2) {
        return o1.name.compareTo(o2.name);
    }

    @Override
    public boolean equals(Object obj) {
        return person.name.equals(obj);
    }
}
