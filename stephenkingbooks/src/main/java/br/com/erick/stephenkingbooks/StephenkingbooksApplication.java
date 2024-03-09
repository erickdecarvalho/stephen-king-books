package br.com.erick.stephenkingbooks;

import br.com.erick.stephenkingbooks.model.Livro;
import br.com.erick.stephenkingbooks.service.ConsumoApi;
import br.com.erick.stephenkingbooks.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.erick.stephenkingbooks.principal.Principal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StephenkingbooksApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StephenkingbooksApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		var consumoApi = new ConsumoApi();
//		ConverteDados conversor = new ConverteDados();
//
//		List<Livro> livros = new ArrayList<>();
//		for (int i = 1; i <= 61; i++) {
//			var json = consumoApi.obterDados("https://stephen-king-api.onrender.com/api/book/" + i);
//			Livro dados = conversor.obterDados(json, Livro.class);
//			livros.add(dados);
//		}
//		livros.forEach(System.out::println);
		Principal principal = new Principal();
		principal.exibeMenu();
	}
}
