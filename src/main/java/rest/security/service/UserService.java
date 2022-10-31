package rest.security.service;

import org.springframework.data.domain.Pageable;
import rest.security.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User findById(Long id);
    User save(User user);

}
