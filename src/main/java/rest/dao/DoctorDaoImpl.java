package rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import rest.entity.Doctor;
import rest.repository.DoctorRepository;

import java.util.Optional;

@Profile("db")
@Repository
public class DoctorDaoImpl implements DoctorDao{
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public Page<Doctor> getDoctor(Pageable pagerequest) {
        return doctorRepository.findAll(pagerequest);
    }

    @Override
    public Optional<Doctor> findByID(Long id) {
        return doctorRepository.findById(id);
    }
}
