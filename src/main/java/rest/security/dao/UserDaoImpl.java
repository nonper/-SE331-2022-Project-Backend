package rest.security.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import rest.security.entity.User;
import rest.security.repository.UserRepository;

@Profile("db")
@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    UserRepository userRepository;
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
