package rest.service;

import rest.entity.Doctor;

import javax.print.Doc;
import java.util.List;

public interface DoctorService {

    List<Doctor> getAllDoctor();

    Doctor getDoctor(Long id);

    Doctor save(Doctor doctor);
}
