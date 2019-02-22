package api.rest.martin.restfulapiwithspring.Model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDateTime date;
	private String data;
	private String author;
	@OneToMany
	private List<Comment> comments = new ArrayList<>();

	public Post() {
	}

	public Post(String data, String author) {
		this.data = data;
		this.author = author;
		this.date = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate() {
		this.date = LocalDateTime.now();
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Post{" +
				"id=" + id +
				", date=" + date +
				", data='" + data + '\'' +
				", author='" + author + '\'' +
				", comments=" + comments +
				'}';
	}
}
