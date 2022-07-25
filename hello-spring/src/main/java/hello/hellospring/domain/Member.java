package hello.hellospring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String text;
//    private Date currentDate;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }
    public void setText(String content) {
        this.text = content;
    }

//    public Date getCurrentDate() {
//        return currentDate;
//    }
//    public void setCurrentDate(Date currentDate) {
//        this.currentDate = currentDate;
//    }
}
