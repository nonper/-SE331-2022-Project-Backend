package rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rest.dao.AdminDao;
import rest.entity.Admin;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminDao adminDao;
    @Override
    public List<Admin> getAdmins() {
        return adminDao.getAdmins(Pageable.unpaged()).getContent();
    }

    @Override
    public Admin getAdmin(Long id) {
        return adminDao.findById(id);
    }

    @Override
    public Admin save(Admin admin) {
        return adminDao.save(admin);
    }
}
