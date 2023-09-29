package br.bosch.ETSFlix.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// Serve para ignorar os campos que não vamos usar que vem do JSON
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonProperty("Title") String titulo, @JsonProperty("totalSeasons") int totalTemporadas, @JsonProperty("imdbRating") String avaliacao) {
    // @JsonAlias = Somente de Json para Objetos
    // @JsonProperty = Funciona nos dois caminhos, de objetos para Json e vice-versa
    // Pode usar os dois, o Property faz parte da versão mais nova


}