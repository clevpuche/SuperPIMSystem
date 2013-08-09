

package br.ufu.facom.esof.superpimsystem.model;


public class Receita {
private int id;
    private String nomeDaReceita,ModoDePreparo,categoria;
    private String ingredientes;

    public Receita(String nomeDaReceita, String ModoDePreparo,String ing,String categoria) {
        this.nomeDaReceita = nomeDaReceita;
        this.ModoDePreparo = ModoDePreparo;
        this.categoria = categoria;
        ingredientes = ing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }


    public String getModoDePreparo() {
        return ModoDePreparo;
    }

    public void setModoDePreparo(String ModoDePreparo) {
        this.ModoDePreparo = ModoDePreparo;
    }


    public String getNomeDaReceita() {
        return nomeDaReceita;
    }

    public void setNomeDaReceita(String nomeDaReceita) {
        this.nomeDaReceita = nomeDaReceita;
    }


}
