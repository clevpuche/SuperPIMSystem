package br.ufu.facom.esof.superpimsystem.model;

public class SerialSenha {
    private int id;
    private String usuarioSoft,senhaSerial,comentario;

    public SerialSenha(String usuarioSoft, String senhaSerial, String comentario) {
        this.usuarioSoft = usuarioSoft;
        this.senhaSerial = senhaSerial;
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getSenhaSerial() {
        return senhaSerial;
    }

    public void setSenhaSerial(String senhaSerial) {
        this.senhaSerial = senhaSerial;
    }

    public String getUsuarioSoft() {
        return usuarioSoft;
    }

    public void setUsuarioSoft(String usuarioSoft) {
        this.usuarioSoft = usuarioSoft;
    }

    

}
