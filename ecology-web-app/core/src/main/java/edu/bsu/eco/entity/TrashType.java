package edu.bsu.eco.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "trash")
public class TrashType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trash_type_id")
    private Long id;

    @Column(name = "trash_type_name")
    private String name;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        TrashType trashType = (TrashType) o;
        return id != null && Objects.equals(id, trashType.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
