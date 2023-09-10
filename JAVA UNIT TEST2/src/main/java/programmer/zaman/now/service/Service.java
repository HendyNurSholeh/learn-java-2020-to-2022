package programmer.zaman.now.service;

import programmer.zaman.now.data.Person;
import programmer.zaman.now.repository.Repository;

import java.util.UUID;

public class Service {

    Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    Person get(String id){
        Person person = repository.selectById(id);
        if (person != null){
            return person;
        }else {
            throw new IllegalArgumentException("Person Not Found");
        }
    }


    Person createId(String name){
        String id = UUID.randomUUID().toString();
        Person person = new Person(name, id);
        repository.insert(person);
        return person;
    }

}
