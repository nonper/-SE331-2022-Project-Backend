package rest.entity;

import lombok.*;

import javax.persistence.*;

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
    String firstDose;
    String secondDose;
    String firstDate;
    String secondDate;

    @ManyToOne
    Doctor doctor;
}
