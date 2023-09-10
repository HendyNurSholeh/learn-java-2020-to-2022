package programmerzamannow.reflection;

import com.sun.jdi.event.ClassPrepareEvent;
import org.junit.jupiter.api.Test;
import programmerzamannow.reflection.data.Cat;
import programmerzamannow.reflection.data.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    @Test
    void testCallInterfaceCat() {
        // InvocationHandler (penampungnya)
        InvocationHandler invocationHandler = (proxy, method, args) -> {
            if (method.getName().equals("getName")){
                return "doggi";
            } else if (method.getName().equals("getColor")){
                return "blue";
            } else if (method.getName().equals("eat")){
                System.out.println("cat is eating");
            }
            return null;
        };

        // Proxy
        Object proxy = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Cat.class}, invocationHandler);
        var cat = (Cat) proxy;
        System.out.println(cat.getClass().getSimpleName());
        System.out.println(cat.getName());
        System.out.println(cat.getColor());
        cat.eat();
    }
}
