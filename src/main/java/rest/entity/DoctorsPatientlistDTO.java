package rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorsPatientlistDTO {
    Long id;
    String name;
    String surname;
    String homeTown;
    Long age;
    String vaccinateStatus;
    List<Vaccine> vaccines;
    List<DocComDTO> comment;
    String firstDate;
    String secondDate;
}
