package rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import rest.entity.Comment;
import rest.repository.CommentRepository;

import java.util.Optional;

@Profile("db")
@Repository
public class CommentDaoImpl implements CommentDao{

    @Autowired
    CommentRepository commentRepository;


    @Override
    public Page<Comment> getComment(Pageable pagerequest) {
        return commentRepository.findAll(pagerequest);
    }

    @Override
    public Comment findByID(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }
}
