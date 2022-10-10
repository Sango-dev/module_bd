package ua.com.alevel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subject {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private int key;
    private String name;

    @OneToOne(mappedBy = "subject")
    private Teacher teacher;

    @Override
    public String toString() {
        return "Subject{" +
                "key=" + key +
                ", name='" + name + '\'' +
                '}';
    }
}
