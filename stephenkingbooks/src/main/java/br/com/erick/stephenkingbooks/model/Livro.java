package br.com.erick.stephenkingbooks.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Livro(@JsonAlias("Title") String titulo,
                    @JsonAlias("Pages") Integer totalPaginas,
                    @JsonAlias("Year") Integer anoLancamento,
                    @JsonAlias("villains") List<Vilao> viloes
) {
}
