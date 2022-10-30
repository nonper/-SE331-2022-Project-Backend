package rest.security.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rest.security.entity.User;

public interface UserDao {
    Page<User> getUsers(Pageable pagerequest);

    User findById(Long id);
    User save(User user);
}
