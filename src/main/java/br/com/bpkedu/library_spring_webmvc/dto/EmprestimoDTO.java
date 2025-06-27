package br.com.bpkedu.library_spring_webmvc.dto;

import br.com.bpkedu.library_spring_webmvc.domain.Emprestimo;
import br.com.bpkedu.library_spring_webmvc.domain.Livro;
import br.com.bpkedu.library_spring_webmvc.domain.Usuario;
import br.com.bpkedu.library_spring_webmvc.service.LivroService;
import br.com.bpkedu.library_spring_webmvc.service.UsuarioService;
import lombok.Data;

import java.time.LocalDate;
@Data
public class EmprestimoDTO {

    private Long id; // importante para edição
    private Long livroId;
    private Long usuarioId;
    private int prazoDias;

    public EmprestimoDTO() {}

    public EmprestimoDTO(Emprestimo emprestimo) {
        this.id = emprestimo.getId();
        this.livroId = emprestimo.getLivro().getId();
        this.usuarioId = emprestimo.getUsuario().getId();

        if (emprestimo.getDataEmprestimo() != null && emprestimo.getDataPrevistaDevolucao() != null) {
            this.prazoDias = (int) emprestimo.getDataEmprestimo().until(emprestimo.getDataPrevistaDevolucao()).getDays();
        }
    }

    public Emprestimo toEmprestimo(LivroService livroService, UsuarioService usuarioService) {
        Livro livro = livroService.buscarPorId(livroId);
        Usuario usuario = usuarioService.buscarPorId(usuarioId);

        Emprestimo e = new Emprestimo();
        e.setId(this.id); // importante para o JPA entender que é um update
        e.setLivro(livro);
        e.setUsuario(usuario);
        e.setDataEmprestimo(LocalDate.now());
        e.setDataPrevistaDevolucao(LocalDate.now().plusDays(prazoDias));
        return e;
    }
}

