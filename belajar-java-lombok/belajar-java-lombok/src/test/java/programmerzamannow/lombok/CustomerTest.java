package programmerzamannow.lombok;

import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    void testGetterSetter() {
        Customer customer = Customer.createEmpty();
        customer.setId("123");
        System.out.println(customer.getId());
        System.out.println(customer.getName());
    }

    @Test
    void testConstructor() {
        Customer customer = Customer.create("123", "hendy ganteng");
        System.out.println(customer.getId());
        System.out.println(customer.getName());
    }

    @Test
    void testEqualsAndHascode() {
        var customer1 = Customer.create("123", "hendy");
        var customer2 = Customer.create("1234", "hendy");

        System.out.println(customer1.hashCode());
        System.out.println(customer2.hashCode());
        System.out.println(customer1.equals(customer2));
    }
}
