package rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rest.dao.PatientsDao;
import rest.entity.Patients;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PatientsServiceImpl implements PatientsService{

    @Autowired
    PatientsDao patientsDao;

    @Override
    public Page<Patients> getPatients(Integer pageSize, Integer page) {
        return patientsDao.getPatients(pageSize, page);
    }

    @Override
    public Patients getPatients(Long id) {
        return patientsDao.getPatients(id);
    }

    @Override
    @Transactional
    public Patients save(Patients patients) {
        return patientsDao.save(patients);
    }

    @Override
    public Page<Patients> getPatients(String name, Pageable pageable) {
        return patientsDao.getPatients(name, pageable);
    }
}
