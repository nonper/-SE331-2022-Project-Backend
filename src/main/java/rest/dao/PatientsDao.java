package rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rest.entity.Patients;

public interface PatientsDao {
    Page<Patients> getPatients(Integer pageSize, Integer page);

    Patients getPatients(Long id);

    Patients save(Patients patients);

    Page<Patients> getPatients(String name, Pageable page);
}
