package rest.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rest.entity.Doctor;
import rest.repository.DoctorRepository;
import rest.security.dao.AuthDao;
import rest.security.dao.UserDao;
import rest.security.entity.Authority;
import rest.security.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Autowired
    AuthDao authDao;

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public List<User> getUsers() {
        return userDao.getUsers(Pageable.unpaged()).getContent();
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

}