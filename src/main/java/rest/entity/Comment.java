package rest.entity;

import lombok.*;
import rest.security.entity.User;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String comment;

    @OneToOne
    Doctor doctor;

    @ManyToOne
    Patients patients;
}
