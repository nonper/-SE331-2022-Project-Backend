package rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import rest.entity.*;
import rest.repository.*;
import rest.security.entity.Authority;
import rest.security.entity.AuthorityName;
import rest.security.entity.User;
import rest.security.repository.AuthorityRepository;
import rest.security.repository.UserRepository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    PatientsRepository patientsRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    VaccineRepository vaccineRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AdminRepository adminRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        addUser();
        Admin admin1;
        admin1 = adminRepository.save(Admin.builder()
                .name("Admin")
                .surname("Admin")
                .user(user1)
                .build());
        user1.setAdmin(admin1);
        user1.setFirstname(admin1.getName());
        Vaccine vac1, vac2, vac3, vac4, vac5, vac6;
        vac1 = vaccineRepository.save(Vaccine.builder()
                .vaccineName("Pfizer")
                .build());
        vac2 = vaccineRepository.save(Vaccine.builder()
                .vaccineName("Janssen")
                .build());
        vac3 = vaccineRepository.save(Vaccine.builder()
                .vaccineName("Moderna")
                .build());
        vac4 = vaccineRepository.save(Vaccine.builder()
                .vaccineName("Sinopharm")
                .build());
        vac5 = vaccineRepository.save(Vaccine.builder()
                .vaccineName("Oxford")
                .build());
        vac6 = vaccineRepository.save(Vaccine.builder()
                .vaccineName("Sputnik V")
                .build());

        Comment comment1, comment2;
        comment1 = commentRepository.save(Comment.builder()
                .comment("Good health condition.")
                .build());
        comment2 = commentRepository.save(Comment.builder()
                .comment("Do more an exercises.")
                .build());

        Doctor doc1, doc2;
        doc1 = doctorRepository.save(Doctor.builder()
                .name("Supachok")
                .surname("Jrirarojkul")
                .user(user4)
                .build());
        comment1.setDoctor(doc1);
        user4.setDoctor(doc1);
        user4.setFirstname(doc1.getName());
        doc2 = doctorRepository.save(Doctor.builder()
                .name("Thictikorne")
                .surname("Vin")
                .user(user5)
                .build());
        comment2.setDoctor(doc2);
        user5.setDoctor(doc2);
        user5.setFirstname(doc2.getName());

        Patients tempPat = null;
        tempPat = patientsRepository.save(Patients.builder()
                .name("Jevan")
                .surname("Jevan")
                .vaccinateStatus("Second dose")
                .firstDate("19/6/2021")
                .secondDate("11/8/2021")
                .age(29L)
                .homeTown("907 Pennington Lane Ankeny, IA 50023")
                .build());
        tempPat.getComment().add(comment1);
        comment1.setPatients(tempPat);

        tempPat.getVaccines().add(vac1);
        tempPat.getVaccines().add(vac2);

        doc1.getPatients().add(tempPat);
        tempPat.setDoctor(doc1);

        tempPat.setUser(user2);
        user2.setPatients(tempPat);
        user2.setFirstname(tempPat.getName());

        tempPat = patientsRepository.save(Patients.builder()
                .name("Evelyn")
                .surname("Horne")
                .age(52L)
                .vaccinateStatus("Second dose")
                .firstDate("01-06-2021")
                .secondDate("01-08-2021")
                .homeTown("8657 Prairie Drive Reynoldsburg, OH 43068")
                .build());
        tempPat.getVaccines().add(vac1);
        tempPat.getVaccines().add(vac6);

        doc1.getPatients().add(tempPat);
        tempPat.setDoctor(doc1);

        tempPat.setUser(user3);
        user3.setPatients(tempPat);
        user3.setFirstname(tempPat.getName());

        tempPat = patientsRepository.save(Patients.builder()
                .name("Tara")
                .surname("Hastings")
                .age(16L)
                .vaccinateStatus("Second dose")
                .firstDate("09-06-2021")
                .secondDate("01-08-2021")
                .homeTown("9728 North Ridgewood Drive Randallstown, MD 21133")
                .build());
        tempPat.getVaccines().add(vac2);
        tempPat.getVaccines().add(vac5);

        doc1.getPatients().add(tempPat);
        tempPat.setDoctor(doc1);

        tempPat.setUser(user6);
        user6.setPatients(tempPat);
        user6.setFirstname(tempPat.getName());

        tempPat = patientsRepository.save(Patients.builder()
                .name("Will")
                .surname("Dickens")
                .age(37L)
                .vaccinateStatus("Second dose")
                .firstDate("19-03-2021")
                .secondDate("11-01-2021")
                .homeTown("7826 Prince Rd. Newark, NJ 07103")
                .build());
        tempPat.getComment().add(comment2);
        comment2.setPatients(tempPat);

        tempPat.getVaccines().add(vac4);
        tempPat.getVaccines().add(vac5);

        doc2.getPatients().add(tempPat);
        tempPat.setDoctor(doc2);

        tempPat.setUser(user7);
        user7.setPatients(tempPat);
        user7.setFirstname(tempPat.getName());

        tempPat = patientsRepository.save(Patients.builder()
                .name("Daniel")
                .surname("Lees")
                .age(21L)
                .vaccinateStatus("Second dose")
                .firstDate("13-06-2021")
                .secondDate("12-08-2021")
                .homeTown("231 Bedford Street Canal Winchester, OH 43110")
                .build());
        tempPat.getVaccines().add(vac1);
        tempPat.getVaccines().add(vac6);

        doc2.getPatients().add(tempPat);
        tempPat.setDoctor(doc2);

        tempPat.setUser(user8);
        user8.setPatients(tempPat);
        user8.setFirstname(tempPat.getName());

        tempPat = patientsRepository.save(Patients.builder()
                .name("Farzana")
                .surname("Rennie")
                .age(65L)
                .vaccinateStatus("First dose")
                .firstDate("19-02-2021")
                .homeTown("7578 NW. Green Street Taunton, MA 02780")
                .build());
        tempPat.getVaccines().add(vac3);

        doc2.getPatients().add(tempPat);
        tempPat.setDoctor(doc2);

        tempPat.setUser(user9);
        user9.setPatients(tempPat);
        user9.setFirstname(tempPat.getName());

    }

    User user1, user2, user3, user4, user5, user6, user7, user8, user9;
    private void addUser() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Authority authUser =
                Authority.builder().name(AuthorityName.ROLE_USER).build();
        Authority authAdmin =
                Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
        Authority authDoctor =
                Authority.builder().name(AuthorityName.ROLE_DOCTOR).build();
        user1 = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01,
                        01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user2 = User.builder()
                .username("user1")
                .password(encoder.encode("user"))
                .firstname("")
                .lastname("user")
                .email("enabled@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01,
                        01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user3 = User.builder()
                .username("user2")
                .password(encoder.encode("user"))
                .firstname("")
                .lastname("user")
                .email("enabled@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01,
                        01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user4 = User.builder()
                .username("user4")
                .password(encoder.encode("user"))
                .firstname("")
                .lastname("user")
                .email("enabled@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01,
                        01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user5 = User.builder()
                .username("user5")
                .password(encoder.encode("user"))
                .firstname("")
                .lastname("user")
                .email("enabled@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01,
                        01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user6 = User.builder()
                .username("user6")
                .password(encoder.encode("user"))
                .firstname("")
                .lastname("user")
                .email("enabled@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01,
                        01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user7 = User.builder()
                .username("user7")
                .password(encoder.encode("user"))
                .firstname("")
                .lastname("user")
                .email("enabled@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01,
                        01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user8 = User.builder()
                .username("user8")
                .password(encoder.encode("user"))
                .firstname("")
                .lastname("user")
                .email("enabled@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01,
                        01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user9 = User.builder()
                .username("user9")
                .password(encoder.encode("user"))
                .firstname("")
                .lastname("user")
                .email("enabled@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01,
                        01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        authorityRepository.save(authUser);
        authorityRepository.save(authAdmin);
        authorityRepository.save(authDoctor);
        user1.getAuthorities().add(authAdmin);
        user2.getAuthorities().add(authUser);
        user3.getAuthorities().add(authUser);
        user4.getAuthorities().add(authDoctor);
        user5.getAuthorities().add(authDoctor);
        user6.getAuthorities().add(authUser);
        user7.getAuthorities().add(authUser);
        user8.getAuthorities().add(authUser);
        user9.getAuthorities().add(authUser);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
        userRepository.save(user6);
        userRepository.save(user7);
        userRepository.save(user8);
        userRepository.save(user9);
    }
}
