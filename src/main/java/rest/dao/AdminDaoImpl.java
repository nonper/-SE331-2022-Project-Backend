package rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import rest.entity.Admin;
import rest.repository.AdminRepository;

@Profile("db")
@Repository
public class AdminDaoImpl implements AdminDao{
    @Autowired
    AdminRepository adminRepository;

    @Override
    public Page<Admin> getAdmins(Pageable pagerequest) {
        return adminRepository.findAll(pagerequest);
    }

    @Override
    public Admin findById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }
}
