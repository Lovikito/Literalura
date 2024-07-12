package alura.literalura.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import alura.literalura.model.Autor;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor,Long> {
    Optional<Autor> findByNombreContainingIgnoreCase(String nombreAutor);
}
