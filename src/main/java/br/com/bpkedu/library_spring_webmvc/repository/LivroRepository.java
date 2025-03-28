package br.com.bpkedu.library_spring_webmvc.repository;

import br.com.bpkedu.library_spring_webmvc.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {


    List<Livro> findByTitulo(String titulo);


}
