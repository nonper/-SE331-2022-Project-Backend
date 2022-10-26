package rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rest.entity.Patients;

public interface PatientsService {

    Page<Patients> getPatients(Integer pageSize, Integer page);

    Patients getPatients(Long id);

    Patients save(Patients patients);

    Page<Patients> getPatients(String name, Pageable pageable);
}
