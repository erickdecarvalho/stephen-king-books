package br.com.erick.stephenkingbooks.principal;

import br.com.erick.stephenkingbooks.model.Livro;
import br.com.erick.stephenkingbooks.service.ConsumoApi;
import br.com.erick.stephenkingbooks.service.ConverteDados;

import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://stephen-king-api.onrender.com/api/book/";

    public void exibeMenu() {
        System.out.println("Digite o id do livro para busca");
        var nomeLivro = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeLivro);
        Livro dados = conversor.obterDados(json, Livro.class);
        System.out.println(dados);
    }
}
