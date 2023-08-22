package shin.test_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;

public class ClassProxyTest {

    @Test
    public void di() {
        MethodInterceptor handler = new MethodInterceptor() {
            DefaultBookService2 bookService = new DefaultBookService2();
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                if (method.getName().equals("rent")) {
                    System.out.println("AAAA");
                    Object invoke = method.invoke(bookService, objects);
                    System.out.println("BBBB");
                    return invoke;
                }
                return method.invoke(bookService, objects);
            }
        };

        DefaultBookService2 DefaultBookService2 = (DefaultBookService2) Enhancer.create(DefaultBookService2.class, handler);

        Book book = new Book();
        book.setTitle("class_proxy");
        DefaultBookService2.rent(book);
        DefaultBookService2.returnBook(book);
    }

}
