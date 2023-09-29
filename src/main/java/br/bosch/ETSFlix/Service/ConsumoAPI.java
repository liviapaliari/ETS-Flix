package br.bosch.ETSFlix.Service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsumoAPI {
    String apiKey = "a4f77678";

    private String requisitaDados(String endereco) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().proxy(ProxySelector.of(new InetSocketAddress("proxy.br.bosch.com", 8080))).build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    // SÉRIE
    public String obterDados(String titulo) throws IOException, InterruptedException {
        String endereco = "http://www.omdbapi.com/?t=" + titulo + "&apikey=" + apiKey;
        endereco = endereco.replace(" ", "+");
        return requisitaDados(endereco);
    }

    // TEMPORADA
    public String obterDados(String titulo, int temporada) throws IOException, InterruptedException {
        String endereco = String.format("http://www.omdbapi.com/?t=%s&season=%s&apikey=%s", titulo, temporada, apiKey);
        endereco = endereco.replace(" ", "+");
        return requisitaDados(endereco);
    }

    // EPISÓDIO
    public String obterDados(String titulo, int temporada, int episodio) throws IOException, InterruptedException {
        String endereco = String.format("http://www.omdbapi.com/?t=%s&season=%s&episode=%s&apikey=%s", titulo, temporada, episodio, apiKey);
        endereco = endereco.replace(" ", "+");
        return requisitaDados(endereco);
    }
}