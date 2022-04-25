package edu.bsu.eco.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "trash_separating_place")
public class TrashSeparatingPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trash_separating_place_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "working_hours")
    private String workingHours;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "trash_place_type",
                joinColumns = {@JoinColumn(name = "trash_separating_place_id", referencedColumnName = "trash_separating_place_id")},
                inverseJoinColumns = {@JoinColumn(name = "trash_type_id", referencedColumnName = "trash_type_id")})
    private List<TrashType> trashTypes;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        TrashSeparatingPlace that = (TrashSeparatingPlace) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, latitude, longitude, workingHours, trashTypes);
    }
}
