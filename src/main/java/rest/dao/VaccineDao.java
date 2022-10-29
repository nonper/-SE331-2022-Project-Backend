package rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rest.entity.Vaccine;

import java.util.Optional;

public interface VaccineDao {
    Page<Vaccine> getVaccines(Pageable pagerequest);

    Vaccine getVaccine(Long id);

    Vaccine save(Vaccine vaccine);
}
