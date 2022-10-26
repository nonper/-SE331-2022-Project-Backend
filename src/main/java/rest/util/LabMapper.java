package rest.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import rest.entity.*;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    PatientsDTO getPatientsDTO(Patients patients);

    List<PatientsDTO> getPatientsDTO(List<Patients> patients);

    DoctorDTO getDoctorDTO(Doctor doctor);

    List<DoctorDTO> getDoctorDTO(List<Doctor> doctor);
}