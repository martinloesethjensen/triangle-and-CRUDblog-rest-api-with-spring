package api.rest.martin.restfulapiwithspring.Model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private LocalDateTime date;
	private String data;

	public Comment() {
	}

	public Comment(String name, String data) {
		this.name = name;
		this.data = data;
		this.date = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Comment{" +
				"id=" + id +
				", name='" + name + '\'' +
				", date=" + date +
				", data='" + data + '\'' +
				'}';
	}
}

