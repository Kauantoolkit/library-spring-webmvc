package br.com.bpkedu.library_spring_webmvc.domain;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String senha;
    private String email;
    private String endereco;
    private String telefone;







    @Override
    public String toString() {
        return "Usuario{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", senha='" + senha + '\'' +
            ", email='" + email + '\'' +
            ", endereco='" + endereco + '\'' +
            ", telefone='" + telefone + '\'' +
            '}';
    }
}
