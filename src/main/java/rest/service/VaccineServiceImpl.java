package rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rest.dao.VaccineDao;
import rest.entity.Vaccine;

import java.util.List;
import java.util.Optional;

@Service
public class VaccineServiceImpl implements VaccineService{
    @Autowired
    VaccineDao vaccineDao;

    @Override
    public List<Vaccine> getAllVaccines() {
        return vaccineDao.getVaccines(Pageable.unpaged()).getContent();
    }

    @Override
    public Vaccine getVaccine(Long id) {
        return vaccineDao.getVaccine(id);
    }

    @Override
    public Vaccine save(Vaccine vaccine) {
        return vaccineDao.save(vaccine);
    }
}
