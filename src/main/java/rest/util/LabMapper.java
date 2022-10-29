package rest.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import rest.entity.*;
import rest.security.entity.User;
import rest.security.entity.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(imports = Collectors.class)
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    PatientsDTO getPatientsDTO(Patients patients);

    List<PatientsDTO> getPatientsDTO(List<Patients> patients);

    DoctorDTO getDoctorDTO(Doctor doctor);

    List<DoctorDTO> getDoctorDTO(List<Doctor> doctor);

    CommentDTO getCommentDTO(Comment comment);

    List<CommentDTO> getCommentDTO(List<Comment> comments);

    VaccineDTO getVaccineDTO(Vaccine vaccine);

    List<VaccineDTO> getVaccineDTO(List<Vaccine> vaccine);

    @Mapping(target = "authorities", expression = "java(patients.getUser().getAuthorities().stream().map(auth -> auth.getName().name()).collect(Collectors.toList()))")
    PatientAuthDTO getPatientAuthDTO(Patients patients);

    @Mapping(target = "authorities", expression = "java(doctor.getUser().getAuthorities().stream().map(auth -> auth.getName().name()).collect(Collectors.toList()))")
    DoctorAuthDTO getDoctorAuthDTO(Doctor doctor);

    UserDTO getUserDTO(User user);
}