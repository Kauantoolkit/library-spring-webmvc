package br.com.bpkedu.library_spring_webmvc.service;

import br.com.bpkedu.library_spring_webmvc.domain.Emprestimo;
import br.com.bpkedu.library_spring_webmvc.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public Emprestimo emprestar(Emprestimo emprestimo) {
        emprestimo.setDataEmprestimo(LocalDate.now());
        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo devolver(Long id) {
        Emprestimo e = buscarPorId(id);
        if (e.getDataDevolucao() != null) {
            throw new IllegalStateException("Empréstimo já devolvido: " + id);
        }
        e.setDataDevolucao(LocalDate.now());
        emprestimoRepository.save(e);
        return e;
    }

    public List<Emprestimo> listarTodos() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo buscarPorId(Long id) {
        return emprestimoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Empréstimo não encontrado: " + id));
    }

    public Emprestimo atualizar(Emprestimo emprestimo) {
    return emprestimoRepository.save(emprestimo);
}

public void excluir(Long id) {
    Emprestimo emprestimo = buscarPorId(id);
    emprestimoRepository.delete(emprestimo);
}


}
