package br.edu.fatecgru.toybox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class ToyboxApplication {

	// Método para aplicar filtro para passar requisição PUT em HTML
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}


	public static void main(String[] args) {
		SpringApplication.run(ToyboxApplication.class, args);
	}

}
