package api.rest.martin.restfulapiwithspring.Controller;

import api.rest.martin.restfulapiwithspring.Model.Comment;
import api.rest.martin.restfulapiwithspring.Model.Post;
import api.rest.martin.restfulapiwithspring.Repositories.CommentRepo;
import api.rest.martin.restfulapiwithspring.Repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentRestController {
	@Autowired
	PostRepo postRepo;
	@Autowired
	CommentRepo commentRepo;

	/**
	 * Gets the comment from the database.
	 *
	 * @param id
	 * @return ResponseEntity<Comment>
	 */
	@GetMapping("/api/comment/{id}")
	public ResponseEntity<Comment> getComment(@PathVariable("id") Long id) {
		if (!commentRepo.existsById(id)) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(commentRepo.findCommentById(id), HttpStatus.OK);
	}

	/**
	 * Deletes a comment from the database. If the id doesn't exist then it returns null with a HTTP status 400 Bad request.
	 *
	 * @param id
	 * @return ResponseEntity<String>
	 */
	@GetMapping("/api/comment/delete/{id}")
	public ResponseEntity<String> deleteComment(@PathVariable("id") Long id) {
		if (!commentRepo.existsById(id)) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		commentRepo.delete(commentRepo.findCommentById(id));
		return new ResponseEntity<>("Comment with id: " + id + " has been deleted.", HttpStatus.OK);
	}

	/**
	 * Creates a new comment for a post.
	 *
	 * @param post_Id
	 * @param data
	 * @param name
	 * @return ResponseEntity<Comment>
	 */
	@GetMapping("/api/comment/create/{post_id}")
	public ResponseEntity<Comment> createCommentForPost(@PathVariable("post_id") Long post_Id,
	                                                    @RequestParam(defaultValue = "{{name}}") String name,
	                                                    @RequestParam(defaultValue = "{{data}}") String data
	)
	{
		if (!postRepo.existsById(post_Id)) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		// Create the new comment and find the post
		Comment comment = new Comment(name, data);
		Post post = postRepo.findPostById(post_Id);

		addCommentToPost(comment, post);

		commentRepo.save(comment);
		postRepo.save(post);

		return new ResponseEntity<>(comment, HttpStatus.OK);
	}

	/**
	 * Make a new list of the post's comments and then adds the new comment to the list.
	 *
	 * @param comment
	 * @param post
	 */
	private void addCommentToPost(Comment comment, Post post) {
		List<Comment> comments = post.getComments();
		comments.add(comment);
		post.setComments(comments);
	}


	/**
	 * Update the comment in the database.
	 *
	 * @return ResponseEntity<Comment>
	 *
	 * @param id
	 * @param name
	 * @param data
	 * */
	@GetMapping("/api/comment/update/{id}")
	public ResponseEntity<Comment> updateComment(@PathVariable("id") Long id,
	                                             @RequestParam(defaultValue = "{{name}}") String name,
	                                             @RequestParam(defaultValue = "{{data}}") String data
	)
	{
		if (!commentRepo.existsById(id)) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		Comment comment = commentRepo.findCommentById(id);
		comment.setData(data);
		comment.setName(name);
		comment.setDate();

		return new ResponseEntity<>(commentRepo.save(comment), HttpStatus.OK);
	}
}