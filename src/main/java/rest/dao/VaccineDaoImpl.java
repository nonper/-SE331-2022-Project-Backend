package rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import rest.entity.Vaccine;
import rest.repository.VaccineRepository;

import java.util.Optional;

@Profile("db")
@Repository
public class VaccineDaoImpl implements VaccineDao{

    @Autowired
    VaccineRepository vaccineRepository;


    @Override
    public Page<Vaccine> getVaccines(Pageable pagerequest) {
        return vaccineRepository.findAll(pagerequest);
    }

    @Override
    public Vaccine getVaccine(Long id) {
        return vaccineRepository.findById(id).orElse(null);
    }

    @Override
    public Vaccine save(Vaccine vaccine) {
        return vaccineRepository.save(vaccine);
    }
}
