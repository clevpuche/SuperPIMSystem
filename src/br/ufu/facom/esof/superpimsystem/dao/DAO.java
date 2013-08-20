
package br.ufu.facom.esof.superpimsystem.dao;

import br.ufu.facom.esof.superpimsystem.model.SerialSenha;
import br.ufu.facom.esof.superpimsystem.model.Contato;
import br.ufu.facom.esof.superpimsystem.model.Uteis;
import br.ufu.facom.esof.superpimsystem.model.Receita;
import br.ufu.facom.esof.superpimsystem.model.DadosPessoais;
import br.ufu.facom.esof.superpimsystem.model.Anotacao;
import br.ufu.facom.esof.superpimsystem.model.Compromisso;
import java.sql.SQLException;
import java.util.ArrayList;


public abstract class DAO {   
    public void update(DadosPessoais a) throws SQLException{}
    public DadosPessoais getDado() throws SQLException{return null;}

    
    
    public void salvar(Anotacao a) throws SQLException{System.out.println("N Houve Sobrescrita");}
    public void update(Anotacao a) throws SQLException{}
    public void delete(Anotacao a) throws SQLException{}
    public ArrayList<Anotacao> getAllAnot() throws SQLException{return null;}
    
    public void salvar(Compromisso a) throws SQLException{}
    public void update(Compromisso a) throws SQLException{}
    public void delete(Compromisso a) throws SQLException{}
    public ArrayList<Compromisso> getAllComp() throws SQLException{return null;}
    public ArrayList<Compromisso> getCompNot() throws SQLException{return null;}
    
    public void salvar(Contato a) throws SQLException{}
    public void update(Contato a) throws SQLException{}
    public void delete(Contato a) throws SQLException{}
     public ArrayList<Contato> getAllCon() throws SQLException{return null;}
    
    public void salvar(Receita a) throws SQLException{}
    public void update(Receita a) throws SQLException{}
    public void delete(Receita a) throws SQLException{}
    public ArrayList<Receita> getAllRec() throws SQLException{return null;}
    
    public void salvar(SerialSenha a) throws SQLException{}
    public void update(SerialSenha a) throws SQLException{}
    public void delete(SerialSenha a) throws SQLException{}
    public ArrayList<SerialSenha> getAllSen() throws SQLException{return null;}
    
    public void salvar(Uteis a) throws SQLException{}
    public void update(Uteis a) throws SQLException{}
    public void delete(Uteis a) throws SQLException{}
    public ArrayList<Uteis> getAllUti() throws SQLException{return null;}
    
    
    
}