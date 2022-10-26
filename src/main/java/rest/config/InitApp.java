package rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import rest.entity.Doctor;
import rest.entity.Patients;
import rest.repository.DoctorRepository;
import rest.repository.PatientsRepository;

import javax.transaction.Transactional;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    PatientsRepository patientsRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Doctor doc1, doc2;
        doc1 = doctorRepository.save(Doctor.builder()
                .name("Supachok")
                .surname("Jrirarojkul")
                .build());
        doc2 = doctorRepository.save(Doctor.builder()
                .name("Thictikorne")
                .surname("Vin")
                .build());

        Patients tempPat = null;
        tempPat = patientsRepository.save(Patients.builder()
                .name("Jevan")
                .surname("Jevan")
                .age(29L)
                .homeTown("907 Pennington Lane Ankeny, IA 50023")
                .build());
        doc1.getPatients().add(tempPat);
        tempPat.setDoctor(doc1);
        tempPat = patientsRepository.save(Patients.builder()
                .name("Evelyn")
                .surname("Horne")
                .age(52L)
                .homeTown("8657 Prairie Drive Reynoldsburg, OH 43068")
                .build());
        doc1.getPatients().add(tempPat);
        tempPat.setDoctor(doc1);
        tempPat = patientsRepository.save(Patients.builder()
                .name("Tara")
                .surname("Hastings")
                .age(16L)
                .homeTown("9728 North Ridgewood Drive Randallstown, MD 21133")
                .build());
        doc1.getPatients().add(tempPat);
        tempPat.setDoctor(doc1);
        tempPat = patientsRepository.save(Patients.builder()
                .name("Will")
                .surname("Dickens")
                .age(37L)
                .homeTown("7826 Prince Rd. Newark, NJ 07103")
                .build());
        doc2.getPatients().add(tempPat);
        tempPat.setDoctor(doc2);
        tempPat = patientsRepository.save(Patients.builder()
                .name("Daniel")
                .surname("Lees")
                .age(21L)
                .homeTown("231 Bedford Street Canal Winchester, OH 43110")
                .build());
        doc2.getPatients().add(tempPat);
        tempPat.setDoctor(doc2);
        tempPat = patientsRepository.save(Patients.builder()
                .name("Farzana")
                .surname("Rennie")
                .age(65L)
                .homeTown("7578 NW. Green Street Taunton, MA 02780")
                .build());
        doc2.getPatients().add(tempPat);
        tempPat.setDoctor(doc2);
    }
}
