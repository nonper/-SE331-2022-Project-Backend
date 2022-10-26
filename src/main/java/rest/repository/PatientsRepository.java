package rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import rest.entity.Patients;

import java.util.List;

public interface PatientsRepository extends JpaRepository<Patients, Long> {
    List<Patients> findAll();

    Page<Patients> findByNameIgnoreCaseContaining(String name, Pageable pageRequest);
}
