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
public class PatientsDTO {
    Long id;
    String name;
    String surname;
    String homeTown;
    Long age;
    String vaccinateStatus;
    List<PatVacDTO> vaccines;
    List<PatComDTO> comment;
    String firstDate;
    String secondDate;
    DoctorForPaDTO doctor;
    List<String> imageUrls;
}
