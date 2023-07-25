package kodlama.io.Kodlama.io.Devs;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
		
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
