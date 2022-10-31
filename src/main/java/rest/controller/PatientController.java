package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import rest.entity.Patients;
import rest.security.entity.Authority;
import rest.security.entity.AuthorityName;
import rest.security.entity.User;
import rest.security.repository.AuthorityRepository;
import rest.security.repository.UserRepository;
import rest.security.service.UserService;
import rest.service.PatientsService;
import rest.util.LabMapper;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

@Controller
public class PatientController {

    @Autowired
    PatientsService patientsService;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("patients")
    public ResponseEntity<?> getEventLists(@RequestParam(value = "_limit", required = false) Integer perPage
            , @RequestParam(value = "_page", required = false) Integer page
            , @RequestParam(value = "title", required = false) String title) {
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Patients> pageOutput;
        if (title == null) {
            pageOutput = patientsService.getPatients(perPage, page);
        } else {
            pageOutput = patientsService.getPatients(title, PageRequest.of(page - 1, perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();

        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getPatientsDTO(pageOutput.getContent()), responseHeader, HttpStatus.OK);
    }

    @GetMapping("patients/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
        Patients output = patientsService.getPatients(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getPatientsDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/patient")
    public ResponseEntity<?> addEvent(@RequestBody Patients patients) {
        Patients output = patientsService.save(patients);

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        Authority authUser = Authority.builder().name(AuthorityName.ROLE_USER).build();
        authorityRepository.save(authUser);

        User user = User.builder()
                .firstname(patients.getName())
                .lastname(patients.getSurname())
                .username(patients.getName())
                .email(patients.getName()+"@gmail.com")
                .password(encoder.encode("user"))
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01,
                        01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user.getAuthorities().add(authUser);
        userRepository.save(user);

        patients.setUser(user);
        user.setPatients(patients);

        userService.save(user);
        return ResponseEntity.ok(LabMapper.INSTANCE.getPatientsDTO(output));
    }
}
