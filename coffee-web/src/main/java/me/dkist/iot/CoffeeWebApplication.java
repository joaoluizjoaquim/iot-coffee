package me.dkist.iot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoffeeWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeWebApplication.class, args);
	}
	
//	@Autowired(required = true)
//	public void configeJackson(ObjectMapper mapper) {
//	    mapper.registerModule(new ParameterNamesModule());
//	    mapper.registerModule(new Jdk8Module());
//	    mapper.registerModule(new JavaTimeModule());
//	}
}
