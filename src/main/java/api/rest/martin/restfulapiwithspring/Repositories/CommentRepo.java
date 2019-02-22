package api.rest.martin.restfulapiwithspring.Repositories;

import api.rest.martin.restfulapiwithspring.Model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepo extends CrudRepository<Comment, Long> {
	Comment findCommentById(Long id);
}
