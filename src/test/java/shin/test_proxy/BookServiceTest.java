package shin.test_proxy;

import jakarta.annotation.security.RunAs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    BookService bookService = new DefaultBookService();

    @Test
    public void di() {
        Book book = new Book();
        book.setTitle("tttt");
        bookService.rent(book);
    }

}
