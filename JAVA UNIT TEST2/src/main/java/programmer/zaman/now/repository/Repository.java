package programmer.zaman.now.repository;

import programmer.zaman.now.data.Person;

public interface Repository {

    Person selectById(String id);

    void insert(Person person);
}
