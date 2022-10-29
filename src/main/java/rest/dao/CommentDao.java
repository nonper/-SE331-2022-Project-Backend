package rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rest.entity.Comment;

import java.util.Optional;

public interface CommentDao {
    Page<Comment> getComment(Pageable pagerequest);

    Comment findByID(Long id);

    Comment save(Comment comment);
}
