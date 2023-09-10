package programmer.zaman.now.validation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import java.util.List;

public class Person {

    @Valid
    public Person() {
    }

    public Person(String firtsName, String lastName) {
        this.firtsName = firtsName;
        this.lastName = lastName;
    }

    @Valid
    public Person(@NotBlank(message = "first name can not blank") String firtsName,
                  @NotBlank(message = "last name can not blank") String lastName,
                  @NotNull(message = "address can not null") @Valid Address address) {
        this.firtsName = firtsName;
        this.lastName = lastName;
        this.address = address;
    }

    @NotBlank(message = "firtsName tidak boleh Blank")
    private String firtsName;

    @NotEmpty(message = "lastName tidak boleh empty")
    @Size(max = 10, message = "caracter yang anda masukkan lebih dari 10 caracter")
    private String lastName;

    @NotNull(message = "address tidak boleh null")
    @Valid
    private Address address;

    private List<@NotBlank(message = "hobbies must be not blank") String> hobbies;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirtsName() {
        return firtsName;
    }

    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void sayHello(@NotBlank(message = "parameter name must not blank") String name){
        System.out.println("Hello " + name + ", Welcome to my application");
    }

    @NotBlank(message = "full name cannot blank")
    public String fullName(){
        return firtsName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Object ini memiliki " +
                "firtsName = '" + firtsName + '\'' +
                ", lastName = '" + lastName + '\'' +
                '}';
    }
}
