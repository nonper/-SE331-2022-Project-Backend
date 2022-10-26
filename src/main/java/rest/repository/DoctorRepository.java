package rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
