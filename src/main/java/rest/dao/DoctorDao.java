package rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rest.entity.Doctor;

import java.util.Optional;

public interface DoctorDao {

    Page<Doctor> getDoctor(Pageable pagerequest);

    Doctor findByID(Long id);

    Doctor save(Doctor doctor);
}
