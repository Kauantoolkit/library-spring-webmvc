package br.com.bpkedu.library_spring_webmvc.dto;

import br.com.bpkedu.library_spring_webmvc.domain.Emprestimo;
import br.com.bpkedu.library_spring_webmvc.domain.Livro;
import br.com.bpkedu.library_spring_webmvc.domain.Usuario;
import br.com.bpkedu.library_spring_webmvc.service.LivroService;
import br.com.bpkedu.library_spring_webmvc.service.UsuarioService;

import java.time.LocalDate;

public class EmprestimoDTO {

    private Long livroId;
    private Long usuarioId;
    private int prazoDias;          // ex.: 7 ou 14 dias

    public EmprestimoDTO() {}

    // getters e setters omitidos para brevidade

    /**
     * Converte este DTO em uma entidade Emprestimo, buscando as entidades Livro e Usuario.
     */
    public Emprestimo toEmprestimo(LivroService livroService, UsuarioService usuarioService) {
        Livro livro = livroService.buscarPorId(livroId);
        Usuario usuario = usuarioService.buscarPorId(usuarioId);

        Emprestimo e = new Emprestimo();
        e.setLivro(livro);
        e.setUsuario(usuario);
        e.setDataEmprestimo(LocalDate.now());
        e.setDataPrevistaDevolucao(LocalDate.now().plusDays(prazoDias));
        return e;
    }
}
