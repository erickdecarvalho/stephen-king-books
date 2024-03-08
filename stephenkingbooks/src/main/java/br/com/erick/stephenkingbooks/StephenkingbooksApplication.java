package br.com.erick.stephenkingbooks;

import br.com.erick.stephenkingbooks.service.ConsumoApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StephenkingbooksApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StephenkingbooksApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://stephen-king-api.onrender.com/api/books");
		System.out.println(json);
	}
}
