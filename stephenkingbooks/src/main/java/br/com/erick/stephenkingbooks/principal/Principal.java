package br.com.erick.stephenkingbooks.principal;

import br.com.erick.stephenkingbooks.model.Livro;
import br.com.erick.stephenkingbooks.service.ConsumoApi;
import br.com.erick.stephenkingbooks.service.ConverteDados;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);

    public void exibeMenu() {

        var consumoApi = new ConsumoApi();
		ConverteDados conversor = new ConverteDados();

        var json = consumoApi.obterDados("https://stephen-king-api.onrender.com/api/books");

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonArray dataArray = jsonObject.getAsJsonArray("data");

        List<Livro> livros = new ArrayList<>();
        dataArray.forEach(
            e -> {
                Livro livro = conversor.obterDados(e.toString(), Livro.class);
                livros.add(livro);
            }
        );

        System.out.println("Digite o nome do livro para busca");
        var nomeLivro = leitura.nextLine();

        livros.stream()
            .filter(e -> e.titulo().equalsIgnoreCase(nomeLivro))
            .forEach(e -> System.out.println(
                    "Nome do livro: " + e.titulo() +
                    "\nQuantidade de páginas: " + e.totalPaginas() +
                    "\nAno do lançamento: " + e.anoLancamento()
            ));
    }
}
