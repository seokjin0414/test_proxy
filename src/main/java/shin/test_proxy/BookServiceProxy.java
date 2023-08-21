package shin.test_proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BookServiceProxy implements BookService {

    BookService bookService;

    public BookServiceProxy(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void rent(Book book) {
        System.out.println("proxy - S");
        bookService.rent(book);
        System.out.println("proxy - E");
    }

    @Override
    public void returnBook(Book book) {
        System.out.println("proxy - S");
        bookService.returnBook(book);
        System.out.println("proxy - E");
    }


}
