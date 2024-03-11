package br.com.erick.stephenkingbooks.principal;

import br.com.erick.stephenkingbooks.model.Livro;
import br.com.erick.stephenkingbooks.service.ConsumoApi;
import br.com.erick.stephenkingbooks.service.ConverteDados;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
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

        System.out.println("Exibindo todos os livros");
        livros.forEach(System.out::println);

        System.out.println("Exibindo todos os vilões");
        livros.forEach(l -> l.viloes().forEach(v -> System.out.println(v.nome())));

        Livro livroComMaisViloes = livros.stream()
                .max(Comparator.comparingInt(l -> l.viloes().size()))
                .orElse(null);

        System.out.println("O livro com mais vilões é: " + livroComMaisViloes.titulo() + " com um total de " + livroComMaisViloes.viloes().size());


        System.out.println("Digite o nome do livro para busca");
        var nomeLivro = leitura.nextLine();

        System.out.println("Informações do livro buscado");
        livros.stream()
            .filter(e -> e.titulo().equalsIgnoreCase(nomeLivro))
            .forEach(e -> System.out.println(
                    "Nome do livro: " + e.titulo() +
                    "\nQuantidade de páginas: " + e.totalPaginas() +
                    "\nAno do lançamento: " + e.anoLancamento() +
                    "\nVilões: " + e.viloes()
            ));

        System.out.println("A partir de que ano você deseja ver os livros lançados?");
        var ano = leitura.nextInt();
        leitura.nextLine();

        livros.stream()
                .filter(l -> l.anoLancamento() != null && l.anoLancamento() > ano)
                .forEach(e -> System.out.println(
                        "Nome do livro: " + e.titulo() +
                                "\nQuantidade de páginas: " + e.totalPaginas() +
                                "\nAno do lançamento: " + e.anoLancamento() +
                                "\nVilões: " + e.viloes()
                ));    }
}
