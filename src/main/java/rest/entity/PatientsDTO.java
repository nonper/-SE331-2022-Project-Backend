package rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientsDTO {
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
    DoctorForPaDTO doctor;
}
