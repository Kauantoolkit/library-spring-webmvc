package br.com.bpkedu.library_spring_webmvc.repository;

import br.com.bpkedu.library_spring_webmvc.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
