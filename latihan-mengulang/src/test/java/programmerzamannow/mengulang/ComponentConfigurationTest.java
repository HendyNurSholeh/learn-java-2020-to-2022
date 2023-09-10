package programmerzamannow.mengulang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.mengulang.component.*;
import programmerzamannow.mengulang.configuration.ComponentConfiguration;
import programmerzamannow.mengulang.data.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class ComponentConfigurationTest {

    ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testComponentCustomer() {
        Object bean = applicationContext.getBean("productService");
        ComponentConfiguration componentConfiguration = applicationContext.getBean(ComponentConfiguration.class);
        Assertions.assertNotNull(bean);
        Assertions.assertNotNull(componentConfiguration);
    }

    @Test
    void testConstructorDependencyInjection() {
        ProductService productService = applicationContext.getBean(ProductService.class);
    }

    @Test
    void testMultipleConstructorDependencyInjection() {
        ProductDatabase productDatabase = applicationContext.getBean(ProductDatabase.class);
        ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);
        ProductService productService = applicationContext.getBean(ProductService.class);

        Assertions.assertSame(productDatabase, productService.getProductDatabase());
        Assertions.assertSame(productRepository, productService.getProductRepository());
    }

    @Test
    void testSetterDependencyInjection() {
        CategoryService categoryService = applicationContext.getBean(CategoryService.class);
        CategoryRepository categoryRepository = applicationContext.getBean(CategoryRepository.class);
        Assertions.assertSame(categoryRepository, categoryService.getCategoryRepository());
    }

    @Test
    void testFieldBasedDependencyInjection() {
        ProductDatabase productDatabase = applicationContext.getBean(ProductDatabase.class);
        ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);
        ProductDatabase productDatabase2 = productRepository.getProductDatabase();

        Assertions.assertSame(productDatabase, productDatabase2);
    }


    @Test
    void testQualifierDependencyInjection() {
        CustomerRepository normalCustomerRepository = applicationContext.getBean("memberCustomerRepository", CustomerRepository.class);
        CustomerService customerService = applicationContext.getBean(CustomerService.class);
        Assertions.assertSame(normalCustomerRepository, customerService.getCustomerRepository());
    }

    @Test
    void OptionalDependency() {
        Person person = applicationContext.getBean(Person.class);
        Address address = applicationContext.getBean(Address.class);
        Assertions.assertSame(person.getAddress(), address);
        Assertions.assertNull(person.getAge());
    }

    @Test
    void objectProviderDependencyInjection() {
        MultiFoo multiFoo = applicationContext.getBean(MultiFoo.class);
        Foo foo1 = applicationContext.getBean("foo1", Foo.class);
        Foo foo2 = applicationContext.getBean("foo2", Foo.class);
        Assertions.assertTrue(multiFoo.getFoos().size() == 2);
        Assertions.assertSame(multiFoo.getFoos().get(0), foo1);
        Assertions.assertSame(multiFoo.getFoos().get(1), foo2);
    }

    @Test
    void factoryBean() {
        Client client = applicationContext.getBean(Client.class);
        Assertions.assertNotNull(client);
        Assertions.assertSame(client.getName(), "hyns");
        Assertions.assertSame(client.getAddress(), "kintap");
        Assertions.assertSame(client.getAge(), 18);
    }

    @Test
    void testInheritance() {
        MerchantService merchantService = applicationContext.getBean(MerchantService.class);
        MerchantServiceImpl merchantServiceImpl = applicationContext.getBean(MerchantServiceImpl.class);
        Assertions.assertSame(merchantService, merchantServiceImpl);
    }

    @Test
    void testBeanFactory() {
        List<Foo> fooList = applicationContext.getBeanProvider(Foo.class).stream().collect(Collectors.toList());
        Foo foo1 = applicationContext.getBean("foo1", Foo.class);
        Foo foo2 = applicationContext.getBean("foo2", Foo.class);
        Assertions.assertSame(fooList.get(0), foo1);
        Assertions.assertSame(fooList.get(1), foo2);
    }

    @Test
    void testBeanPostProcessor() {
        Car car = applicationContext.getBean(Car.class);
        Assertions.assertNotNull(car.getId());
    }

    @Test
    void testAware() {
        AuthService authService = applicationContext.getBean(AuthService.class);
        log.info(authService.getBeanName());
        log.info(authService.getApplicationContext().toString());
        Assertions.assertSame(applicationContext, authService.getApplicationContext());
        AuthService authService1 = authService.getApplicationContext().getBean(AuthService.class);
        Assertions.assertSame(authService, authService1);
    }

    @Test
    void testBeanFactoryPostProcessor() {
        Registry registry1 = applicationContext.getBean(Registry.class);
        Registry registry2 = applicationContext.getBean(Registry.class);
        Assertions.assertNotNull(registry1);
        Assertions.assertSame(registry2, registry1);
        Assertions.assertTrue(registr);
    }
}
