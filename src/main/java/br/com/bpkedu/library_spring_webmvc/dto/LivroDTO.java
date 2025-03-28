package br.com.bpkedu.library_spring_webmvc.dto;

import br.com.bpkedu.library_spring_webmvc.domain.Livro;

public class LivroDTO {

    private String titulo;
    private String autor;
    private Integer anoPublicacao;
    private String isbn;
    private String editora;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Livro toLivro(LivroDTO livroDto){

        return new Livro(
                this.titulo,
                this.autor,
                this.anoPublicacao,
                this.isbn,
                this.editora
        );

    }

}
