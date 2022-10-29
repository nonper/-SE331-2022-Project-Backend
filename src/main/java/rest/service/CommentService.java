package rest.service;

import org.springframework.data.domain.Pageable;
import rest.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComment();

    Comment getComment(Long id);

    Comment save(Comment comment);
}
