package rest.service;

import rest.entity.Vaccine;

import java.util.List;
import java.util.Optional;

public interface VaccineService {

    List<Vaccine> getAllVaccines();

    Vaccine getVaccine(Long id);

    Vaccine save(Vaccine vaccine);
}
