package rest.security.dao;

import org.springframework.data.domain.Page;
import rest.security.entity.Authority;

public interface AuthDao {

    Authority getAuthority(Long id);
}
