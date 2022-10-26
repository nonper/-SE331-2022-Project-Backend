package rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import rest.entity.Patients;
import rest.repository.PatientsRepository;

@Profile("db")
@Repository
public class PatientsDaoImpl implements PatientsDao{

    @Autowired
    PatientsRepository patientsRepository;

    @Override
    public Page<Patients> getPatients(Integer pageSize, Integer page) {
        return patientsRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Patients getPatients(Long id) {
        return patientsRepository.findById(id).orElse(null);
    }

    @Override
    public Patients save(Patients patients) {
        return patientsRepository.save(patients);
    }

    @Override
    public Page<Patients> getPatients(String name, Pageable page) {
        return patientsRepository.findByNameIgnoreCaseContaining(name, page);
    }
}
