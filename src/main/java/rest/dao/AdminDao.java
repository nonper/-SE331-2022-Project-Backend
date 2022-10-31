package rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rest.entity.Admin;

public interface AdminDao {
    Page<Admin> getAdmins(Pageable pagerequest);

    Admin findById(Long id);

    Admin save(Admin admin);
}
