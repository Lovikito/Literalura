package alura.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ConvierteDatosAutor implements IConvierteDatos {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            JsonNode rootNode = objectMapper.readTree(json);

            JsonNode resultsArray = rootNode.get("results");

            if (resultsArray != null && resultsArray.size() > 0) {
                JsonNode firstResult = resultsArray.get(0).get("authors").get(0);

                return objectMapper.treeToValue(firstResult, clase);
            } else {
                throw new RuntimeException("No se encontraron resultados en el JSON.");
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> obtenerDatosArray(String json, Class<T> clase) {
        try {
            JsonNode rootNode = objectMapper.readTree(json);

            JsonNode resultsArray = rootNode.get("results");
            if (resultsArray != null && resultsArray.size() > 0) {
                List<T> resultList = new ArrayList<>();
                for (int i = 0; i < resultsArray.size(); i++) {
                    JsonNode firstResult = resultsArray.get(i).get("authors").get(0);
                    T result = objectMapper.treeToValue(firstResult, clase);
                    resultList.add(result);
                }
                return resultList;
            } else {
                throw new RuntimeException("No se encontraron resultados en el JSON.");
            }
        }
        catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
