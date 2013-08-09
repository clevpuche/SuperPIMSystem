package br.ufu.facom.esof.superpimsystem.model;

public class Contato {
    private int id;
    private String nome;
    private int DDD;
    private String tel,cel,msn,skype,estado,cidade,bairro,endereco,site;
    private String informacoesAdd,email;

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
    

    public Contato(String nome, int DDD, String tel, String cel, String msn, String skype, String estado, String cidade, String bairro, String endereco, String site, String informacoesAdd, String email) {
        this.nome = nome;
        this.DDD = DDD;
        this.tel = tel;
        this.cel = cel;
        this.msn = msn;
        this.skype = skype;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.endereco = endereco;
        this.site = site;
        this.informacoesAdd = informacoesAdd;
        this.email = email;
    }

    public String getInformacoesAdd() {
        return informacoesAdd;
    }

    public void setInformacoesAdd(String informacoesAdd) {
        this.informacoesAdd = informacoesAdd;
    }

    public Contato(String nome, int DDD, String tel, String cel, String msn, String skype, String estado, String cidade, String bairro, String endereco, String site, String informacoesAdd) {
        this.nome = nome;
        this.DDD = DDD;
        this.tel = tel;
        this.cel = cel;
        this.msn = msn;
        this.skype = skype;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.endereco = endereco;
        this.site = site;
        this.informacoesAdd = informacoesAdd;
    }

    public int getDDD() {
        return DDD;
    }

    public void setDDD(int DDD) {
        this.DDD = DDD;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Contato(String nome, int DDD, String tel, String cel, String msn, String skype, String estado, String cidade, String bairro, String endereco, String site) {
        this.nome = nome;
        this.DDD = DDD;
        this.tel = tel;
        this.cel = cel;
        this.msn = msn;
        this.skype = skype;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.endereco = endereco;
        this.site = site;
    }



}
