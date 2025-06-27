package br.com.bpkedu.library_spring_webmvc.controller;

import br.com.bpkedu.library_spring_webmvc.domain.Emprestimo;
import br.com.bpkedu.library_spring_webmvc.dto.EmprestimoDTO;
import br.com.bpkedu.library_spring_webmvc.service.EmprestimoService;
import br.com.bpkedu.library_spring_webmvc.service.LivroService;
import br.com.bpkedu.library_spring_webmvc.service.UsuarioService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/emprestimos")
@Data
public class EmprestimoController {

    private final EmprestimoService emprestimoService;
    private final LivroService livroService;
    private final UsuarioService usuarioService;

    private Emprestimo emprestimo;

    public EmprestimoController(EmprestimoService emprestimoService,
                                LivroService livroService,
                                UsuarioService usuarioService) {
        this.emprestimoService = emprestimoService;
        this.livroService = livroService;
        this.usuarioService = usuarioService;
    }

    // 1) Listar
    @GetMapping("/listar")
    public String listarEmprestimos(Model model) {
        model.addAttribute("emprestimos", emprestimoService.listarTodos());
        return "emprestimos/listar";
    }

    // 2) Formulário de novo empréstimo
    @GetMapping("/novo")
    public String formularioNovo(Model model) {
        model.addAttribute("emprestimoDTO", new EmprestimoDTO());
        model.addAttribute("livros", livroService.listarTodos());
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "emprestimos/novo";
    }

    // 3) Salvar empréstimo
    @PostMapping("/salvar")
    public String salvarEmprestimo(@ModelAttribute EmprestimoDTO dto) {
        emprestimoService.emprestar(dto.toEmprestimo(livroService, usuarioService));
        return "redirect:/emprestimos/listar";
    }

    // 4) Marcar devolução
    @PostMapping("/devolver/{id}")
    public String devolver(@PathVariable Long id) {
        emprestimoService.devolver(id);
        return "redirect:/emprestimos/listar";
    }

    // 5) Formulário de edição
@GetMapping("/editar/{id}")
public String formularioEditar(@PathVariable Long id, Model model) {
    var emprestimo = emprestimoService.buscarPorId(id);
    var emprestimoDTO = new EmprestimoDTO(emprestimo);
    model.addAttribute("emprestimoDTO", emprestimoDTO);
    model.addAttribute("livros", livroService.listarTodos());
    model.addAttribute("usuarios", usuarioService.listarTodos());
    return "emprestimos/editar";
}

@PostMapping("/editar/{id}")
public String atualizarEmprestimo(@PathVariable Long id, @ModelAttribute EmprestimoDTO dto) {
    var emprestimoExistente = emprestimoService.buscarPorId(id);
    // Atualize os campos que podem ser editados
    emprestimoExistente.setUsuario(usuarioService.buscarPorId(dto.getUsuarioId()));
    emprestimoExistente.setLivro(livroService.buscarPorId(dto.getLivroId()));
    // Se quiser, atualize outros campos também

    emprestimoService.atualizar(emprestimoExistente);
    return "redirect:/emprestimos/listar";
}

// 6) Excluir empréstimo
@PostMapping("/excluir/{id}")
public String excluirEmprestimo(@PathVariable Long id) {
    emprestimoService.excluir(id);
    return "redirect:/emprestimos/listar";
}




}
