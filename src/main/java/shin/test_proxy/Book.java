package shin.test_proxy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id @GeneratedValue
    private Integer id;

    private String title;

    public Integer getId() {
        return  id;
    }

    public void setId(Integer id) {
        this.id = id;
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
