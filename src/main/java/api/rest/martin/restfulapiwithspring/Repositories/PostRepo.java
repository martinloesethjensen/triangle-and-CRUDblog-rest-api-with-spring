package api.rest.martin.restfulapiwithspring.Repositories;

import api.rest.martin.restfulapiwithspring.Model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post,Long> {
	Post findPostById(Long id);
}
