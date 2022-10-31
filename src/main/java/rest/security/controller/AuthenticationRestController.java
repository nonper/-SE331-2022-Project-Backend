package rest.security.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import rest.entity.Patients;
import rest.repository.PatientsRepository;
import rest.entity.Doctor;
import rest.repository.DoctorRepository;
import rest.security.entity.Authority;
import rest.security.entity.AuthorityName;
import rest.security.entity.JwtUser;
import rest.security.entity.User;
import rest.security.repository.AuthorityRepository;
import rest.security.repository.UserRepository;
import rest.security.service.UserService;
import rest.security.util.JwtTokenUtil;
import rest.util.LabMapper;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class AuthenticationRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    PatientsRepository patientsRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    UserService userService;

    @PostMapping("${jwt.route.authentication.path}")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {

        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        Map result = new HashMap();
        result.put("token", token);
        User user = userRepository.findById(((JwtUser) userDetails).getId()).orElse(null);
        if (user.getPatients() != null) {
            result.put("user", LabMapper.INSTANCE.getPatientAuthDTO( user.getPatients()));
        } else if (user.getDoctor() != null) {
            result.put("user", LabMapper.INSTANCE.getDoctorAuthDTO( user.getDoctor()));
        } else if (user.getAdmin() != null){
            result.put("user", LabMapper.INSTANCE.getAdminAuthDTO( user.getAdmin()));
        }

        return ResponseEntity.ok(result);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws  AuthenticationException{
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Authority authAdmin = Authority.builder().name(AuthorityName.ROLE_USER).build();
        authorityRepository.save(authAdmin);
        User user2 = User.builder()
                .enabled(true)
                .email(user.getEmail())
                .firstname("")
                .lastname("")
                .username(user.getUsername())
                .password(encoder.encode(user.getPassword()))
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01)
                        .atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user2.getAuthorities().add(authAdmin);
        userRepository.save(user2);
//
//        Organizer organizer = Organizer.builder().name(user.getUsername()).build();
//        organizerRepository.save(organizer);
//
//        organizer.setUser(user2);
//        user2.setOrganizer(organizer);

        userService.save(user2);
        return ResponseEntity.ok(LabMapper.INSTANCE.getUserDTO(user2));
    }

    @GetMapping(value = "${jwt.route.authentication.refresh}")
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/users")
    ResponseEntity<?> getDoctors() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getUserDTO(userService.getUsers()));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
        User output = userService.findById(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getUserDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }


}
