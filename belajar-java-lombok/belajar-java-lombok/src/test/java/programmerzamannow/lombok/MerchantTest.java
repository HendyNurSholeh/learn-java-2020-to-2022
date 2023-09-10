package programmerzamannow.lombok;

import org.junit.jupiter.api.Test;

public class MerchantTest {


    @Test
    void testRequaredContructor() {
        var merchant = new Merchant("123", "hendy");
        System.out.println(merchant.getId());
        System.out.println(merchant.getName());
    }
}
