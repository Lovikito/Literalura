package alura.literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import alura.literalura.model.Libro;

import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro,Long> {
    Optional<Libro> findByTituloContainingIgnoreCase(String nombreLibro);
}
