package rest.entity;

import lombok.*;
import rest.security.entity.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;
    String surname;
    String homeTown;
    Long age;
    String vaccinateStatus;
    String firstDate;
    String secondDate;

    @ManyToMany
    @Builder.Default
    List<Vaccine> vaccines = new ArrayList<>();

    @OneToMany(mappedBy = "patients")
    @Builder.Default
    List<Comment> comment = new ArrayList<>();

    @ManyToOne
    Doctor doctor;

    @OneToOne
    User user;

    @ElementCollection
    List<String> imageUrls;
}
