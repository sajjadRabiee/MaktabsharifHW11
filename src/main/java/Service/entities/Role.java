package Service.entities;

import javax.persistence.*;

@Entity
@Table(name = "role" , catalog = "schema1" , schema = "schema1")
public class Role implements EntityInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private long id;
    @Column(name = "title" , unique = true)
    private String title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
