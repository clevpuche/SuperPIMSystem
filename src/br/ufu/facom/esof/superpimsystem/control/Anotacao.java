package br.ufu.facom.esof.superpimsystem.control;

public class Anotacao {

    private int id;
    private String titulo,conteudo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Anotacao(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    

}
