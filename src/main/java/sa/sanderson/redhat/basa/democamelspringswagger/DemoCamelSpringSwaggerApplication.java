package sa.sanderson.redhat.basa.democamelspringswagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("sa.sanderson.redhat.basa.democamelspringswagger")
public class DemoCamelSpringSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCamelSpringSwaggerApplication.class, args);
	}

}
