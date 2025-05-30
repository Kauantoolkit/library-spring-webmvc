package br.com.bpkedu.library_spring_webmvc.controller;

import br.com.bpkedu.library_spring_webmvc.dto.EmprestimoDTO;
import br.com.bpkedu.library_spring_webmvc.service.EmprestimoService;
import br.com.bpkedu.library_spring_webmvc.service.LivroService;
import br.com.bpkedu.library_spring_webmvc.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;
    private final LivroService livroService;
    private final UsuarioService usuarioService;

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
}
