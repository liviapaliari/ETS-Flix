package br.bosch.ETSFlix.Service;

import br.bosch.ETSFlix.Model.DadosEpisodio;
import br.bosch.ETSFlix.Model.DadosSerie;
import br.bosch.ETSFlix.Model.DadosTemporada;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Principal {
    ConsumoAPI consumoAPI = new ConsumoAPI();
    ConverteDados converteDados = new ConverteDados();
    ArrayList<DadosTemporada> temporadas = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public void exibeMenu() throws InterruptedException, IOException {
        System.out.print("Digite o nome da série: ");
        var nomeSerie = input.nextLine();

        String json = consumoAPI.obterDados(nomeSerie);
        DadosSerie dadosSerie = converteDados.obterDados(json, DadosSerie.class);

        for (int i=1; i <= dadosSerie.totalTemporadas(); i++) {
            json = consumoAPI.obterDados(nomeSerie, i);
            DadosTemporada temporada = converteDados.obterDados(json, DadosTemporada.class);
            temporadas.add(temporada);
        }

//        for (int i=0; i < dadosSerie.totalTemporadas(); i++) {
//            List<DadosEpisodio> episodios = temporadas.get(i).episodios();
//            for (int j=0; j < episodios.size(); j++) {
//                System.out.println(episodios.get(j).titulo());
//            }
//        }

        // Lambda que simplifica o ForEach acima
        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        // Lambda que simplifica o ForEach
        temporadas.forEach(System.out::println);
    }
}