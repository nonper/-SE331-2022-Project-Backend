package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import rest.entity.Comment;
import rest.entity.Doctor;
import rest.entity.Patients;
import rest.service.DoctorService;
import rest.util.LabMapper;

@RestController
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @GetMapping("/doctors")
    ResponseEntity<?> getDoctors() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getDoctorDTO(doctorService.getAllDoctor()));
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
        Doctor output = doctorService.getDoctor(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getDoctorDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/addDoctor")
    public ResponseEntity<?> addDoctor(@RequestBody Doctor doctor) {
        Doctor output = doctorService.save(doctor);
        return ResponseEntity.ok(LabMapper.INSTANCE.getDoctorDTO(output));
    }
}
