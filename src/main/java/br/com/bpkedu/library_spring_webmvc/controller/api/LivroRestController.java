package br.com.bpkedu.library_spring_webmvc.controller.api;

import br.com.bpkedu.library_spring_webmvc.domain.Livro;
import br.com.bpkedu.library_spring_webmvc.dto.LivroDTO;
import br.com.bpkedu.library_spring_webmvc.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/livros")
public class LivroRestController {

    @Autowired
    private LivroService livroService;


    @GetMapping("/getAll")
    public List<Livro> getAll(){
        return livroService.listarTodos();
    }

    @PostMapping()
    public ResponseEntity<Livro> novoLivro(@RequestBody LivroDTO livroDTO){
        Livro livro = livroDTO.toLivro(livroDTO);

        Livro saved =  livroService.salvar(livro);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

}
