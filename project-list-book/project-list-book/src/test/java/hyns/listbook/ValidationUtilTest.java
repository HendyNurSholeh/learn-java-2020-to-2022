package hyns.listbook;

import hyns.listbook.entity.Books;
import hyns.listbook.utility.ValidationUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidationUtilTest {

    @Test
    void testValidate() {
        var book = new Books();
        boolean validate = ValidationUtil.validate(book, "gagal menambahkan buku");
        ValidationUtil.validate(book, "gagal menambahkan buku");

        Assertions.assertFalse(validate);
    }
}
