package br.com.bpkedu.library_spring_webmvc.controller;

import br.com.bpkedu.library_spring_webmvc.domain.Livro;
import br.com.bpkedu.library_spring_webmvc.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping("/listar")
    public String listarLivros(Model model) {
        model.addAttribute("livros", livroService.listarTodos());
        return "livros/listar";
    }

    @GetMapping("/{id:\\d+}")
    public String detalharLivro(@PathVariable Long id, Model model) {
        model.addAttribute("livro", livroService.buscarPorId(id));
        return "livros/detalhar";
    }

    @GetMapping("/novo")
    public String formularioNovoLivro(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/novo";
    }

    @PostMapping("/salvar")
    public String salvarLivro(@ModelAttribute Livro livro) {
        livroService.salvar(livro);
        return "redirect:/livros/listar";
    }

    @GetMapping("/editar/{id:\\d+}")
    public String formularioEditarLivro(@PathVariable Long id, Model model) {
        model.addAttribute("livro", livroService.buscarPorId(id));
        return "livros/editar";
    }

    @PostMapping("/editar/{id}")
    public String atualizarLivro(@PathVariable Long id, @ModelAttribute Livro livro) {
        livro.setId(id); // Garante que o ID do livro seja o mesmo da URL
        livroService.salvar(livro); // Atualiza o livro no banco de dados
        return "redirect:/livros/listar"; // Redireciona para a listagem de livros
    }



    @GetMapping("/deletar/{id:\\d+}")
    public String deletarLivro(@PathVariable Long id) {
        livroService.deletar(id);
        return "redirect:/livros/listar";
    }
}