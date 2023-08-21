package shin.test_proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class BookServiceTest {

    BookService bookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class}, new InvocationHandler() {
                BookService bookService = new DefaultBookService();
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    // return method.invoke(bookService, args); 그냥 실행
                    if (method.getName().equals("rent")) {
                        System.out.println("dp -S");
                        Object invoke = method.invoke(bookService, args);
                        System.out.println("dp -E");
                        return invoke;
                    }

                    return method.invoke(bookService, args);
                }
            });

    @Test
    public void di() {
        Book book = new Book();
        book.setTitle("tttt");
        book.setId(123123);
        bookService.rent(book);
        bookService.returnBook(book);
    }

}
