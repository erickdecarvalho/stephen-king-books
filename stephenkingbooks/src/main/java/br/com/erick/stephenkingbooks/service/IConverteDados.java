package br.com.erick.stephenkingbooks.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
