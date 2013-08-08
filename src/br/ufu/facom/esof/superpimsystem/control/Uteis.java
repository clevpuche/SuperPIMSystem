package br.ufu.facom.esof.superpimsystem.control;

public class Uteis {
private int id;
    private String descricao,tel;

    public Uteis(String descricao, String tel) {
        this.descricao = descricao;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}
