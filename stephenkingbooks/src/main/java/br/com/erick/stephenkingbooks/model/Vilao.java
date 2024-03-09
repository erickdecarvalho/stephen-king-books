package br.com.erick.stephenkingbooks.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Vilao(@JsonAlias("name") String nome,
                    @JsonAlias("books.title") String livro) {
}
