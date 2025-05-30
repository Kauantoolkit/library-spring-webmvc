package br.com.bpkedu.library_spring_webmvc.controller.api;

import br.com.bpkedu.library_spring_webmvc.domain.Emprestimo;
import br.com.bpkedu.library_spring_webmvc.dto.EmprestimoDTO;
import br.com.bpkedu.library_spring_webmvc.service.EmprestimoService;
import br.com.bpkedu.library_spring_webmvc.service.LivroService;
import br.com.bpkedu.library_spring_webmvc.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/emprestimos")
public class EmprestimoRestController {

    @Autowired
    private EmprestimoService emprestimoService;

    @Autowired
    private LivroService livroService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/getAll")
    public List<Emprestimo> listarTodos() {
        return emprestimoService.listarTodos();
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<Emprestimo> buscarPorId(@PathVariable Long id) {
        Emprestimo e = emprestimoService.buscarPorId(id);
        return ResponseEntity.ok(e);
    }

    @PostMapping("/emprestar")
    public ResponseEntity<Emprestimo> emprestar(@RequestBody EmprestimoDTO dto) {
        Emprestimo novo = dto.toEmprestimo(livroService, usuarioService);
        Emprestimo salvo = emprestimoService.emprestar(novo);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PostMapping("/devolver/{id:\\d+}")
    public ResponseEntity<Emprestimo> devolver(@PathVariable Long id) {
        Emprestimo atualizado = emprestimoService.devolver(id);
        return ResponseEntity.ok(atualizado);
    }
}
