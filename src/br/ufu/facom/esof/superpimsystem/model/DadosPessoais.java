
package br.ufu.facom.esof.superpimsystem.model;


public class DadosPessoais {
    private int id;
    private String nome;
    private String email;
    private String facebookuser;
    private String facebookpassword;
    private String twitteruser;
    private String twitterpassword;

    public DadosPessoais(String nome, String email, String facebookUser, String facebookPassword, String twitterUser, String twitterPassword) {
        id = 1;
        this.nome = nome;
        this.email = email;
        this.facebookuser = facebookUser;
        this.facebookpassword = facebookPassword;
        this.twitteruser = twitterUser;
        this.twitterpassword = twitterPassword;
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
    
    public String getFacebookUser() {
        return facebookuser;
    }
    
    public void setFacebookUser(String facebookusr) {
        this.facebookuser = facebookusr;
    }
    
    public String getFacebookPassword() {
        return facebookpassword;
    }
    
    public void setFacebookPassword(String facebookPasswd) {
        this.facebookpassword = facebookPasswd;
    }
    
    public String getTwitterUser() {
        return twitteruser;
    }
    
    public void setTwitterUser(String twitterUsr) {
        this.twitteruser = twitterUsr;
    }
    
    public String getTwitterPassword() {
        return twitterpassword;
    }
    
    public void setTwitterPassword(String twitterPasswd) {
        this.twitterpassword = twitterPasswd;
    }
    
}
