package rest.service;

import rest.entity.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAdmins();

    Admin getAdmin(Long id);

    Admin save(Admin admin);
}
