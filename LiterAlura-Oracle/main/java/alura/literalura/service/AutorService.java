package alura.literalura.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alura.literalura.model.Autor;
import alura.literalura.model.AutorDTO;
import alura.literalura.repository.AutorRepository;


@Service
public class AutorService {
    @Autowired
    private AutorRepository repository;

    public List<AutorDTO> obtenerTodosLosAutores() {
        return convierteDatos(repository.findAll());
    }

    public List<AutorDTO> convierteDatos(List<Autor> autor) {
        return autor.stream()
                .map(a -> new AutorDTO(
                        a.getId(),
                        a.getNombre(),
                        a.getNacimiento(),
                        a.getDeceso()
                ))
                .collect(Collectors.toList());
    }
}
