package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.service.VaccineService;
import rest.util.LabMapper;

@RestController
public class VaccineController {
    @Autowired
    VaccineService vaccineService;

    @GetMapping("/vaccines")
    ResponseEntity<?> getDoctors() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getVaccineDTO(vaccineService.getAllVaccines()));
    }
}
