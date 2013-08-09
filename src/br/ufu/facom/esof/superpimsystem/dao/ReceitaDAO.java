package br.ufu.facom.esof.superpimsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.ufu.facom.esof.superpimsystem.model.Receita;

public class ReceitaDAO extends DAO{
       
    private PreparedStatement save;
    private PreparedStatement update;
    private PreparedStatement delete;
    private PreparedStatement select;

    private final String insertSQL = "insert into Receita values (default,?,?,?,?)";
    private final String updateSQL = "update Receita set nomeDaReceita = ?, ModoDePreparo = ?, ingredientes = ?,categoria = ? where id = ?";
    private final String deleteSQL = "delete from Receita where id = ?";
    private final String selectSQL = "select * from Receita";
     private Connection conexao;
    
    public ReceitaDAO(Connection conexao) throws SQLException{
        this.conexao = conexao;
        save = this.conexao.prepareStatement(insertSQL);
        update = this.conexao.prepareStatement(updateSQL);
        delete = this.conexao.prepareStatement(deleteSQL);
        select = this.conexao.prepareStatement(selectSQL);
    }
    
    @Override
    public ArrayList<Receita> getAllRec() throws SQLException{
        ArrayList<Receita> anotacoes = new ArrayList<Receita>();
        ResultSet rs = select.executeQuery();
        
        while(rs.next()){
            Receita a = new Receita(rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
            a.setId(rs.getInt(1));
            anotacoes.add(a);
        }
        
        return anotacoes;
    }
    
    public void salvar(Receita a) throws SQLException{   
        save.setString(1, a.getNomeDaReceita());
        save.setString(2, a.getModoDePreparo());
        save.setString(3, a.getIngredientes());
        save.setString(4, a.getCategoria());
        save.execute();
    }
    
    public void update(Receita a) throws SQLException{
        //nomeDaReceita = ?, ModoDePreparo = ?, ingredientes = ?,categoria = ? where id = ?";
        update.setString(1, a.getNomeDaReceita());
        update.setString(2, a.getModoDePreparo());
        update.setString(4, a.getIngredientes());
        update.setString(3, a.getCategoria());
        update.setInt(5, a.getId());

        update.executeUpdate();
    }
    
    public void delete(Receita a) throws SQLException{
        delete.setInt(1, a.getId());
        delete.executeUpdate();
    }
    
}
