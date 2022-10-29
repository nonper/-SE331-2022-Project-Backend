package rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
