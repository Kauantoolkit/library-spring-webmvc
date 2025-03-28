package br.com.bpkedu.library_spring_webmvc.repository;

import br.com.bpkedu.library_spring_webmvc.domain.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LivroRepositoryTests {

    @Autowired
    private LivroRepository livroRepository;


    @Test
    public void getLivrosTest(){
        List<Livro> livros = livroRepository.findByTitulo("Java para Leigos");

        System.out.println(livros);
    }

}
