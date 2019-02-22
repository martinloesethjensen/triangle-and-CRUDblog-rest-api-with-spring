package api.rest.martin.restfulapiwithspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RestfulApiWithSpringApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RestfulApiWithSpringApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(RestfulApiWithSpringApplication.class, args);
	}

}
