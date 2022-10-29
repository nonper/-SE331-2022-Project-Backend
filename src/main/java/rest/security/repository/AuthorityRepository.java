package rest.security.repository;



import org.springframework.data.repository.CrudRepository;
import rest.security.entity.Authority;
import rest.security.entity.AuthorityName;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {
    Authority findByName(AuthorityName input);
}
