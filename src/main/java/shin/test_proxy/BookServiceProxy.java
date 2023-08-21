package shin.test_proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BookServiceProxy implements BookService {

    BookService bookService;

    @Override
    public void rent(Book book) {

    }


}
