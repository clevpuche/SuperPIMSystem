
package br.ufu.facom.esof.superpimsystem.model;


public class DadosPessoais {
    private int id;
    private String nome;
    private String email;

    public DadosPessoais(String nome, String email) {
        id = 1;
        this.nome = nome;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    
    
}
