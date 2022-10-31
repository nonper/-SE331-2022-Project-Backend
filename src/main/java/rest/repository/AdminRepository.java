package rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
