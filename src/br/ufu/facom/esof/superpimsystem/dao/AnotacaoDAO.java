
package br.ufu.facom.esof.superpimsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.ufu.facom.esof.superpimsystem.control.Anotacao;


public class AnotacaoDAO extends DAO{
    
    private PreparedStatement save;
    private PreparedStatement update;
    private PreparedStatement delete;
    private PreparedStatement select;
    private final String insertSQL = "insert into Anotacao values (default,?,?)";
    private final String updateSQL = "update Anotacao set titulo = ?, conteudo = ? where id = ?";
    private final String deleteSQL = "delete from Anotacao where id = ?";
    private final String selectSQL = "select * from Anotacao";
    private Connection conexao;
    
    public AnotacaoDAO(Connection conexao) throws SQLException{
        this.conexao = conexao;
        save = this.conexao.prepareStatement(insertSQL);
        update = this.conexao.prepareStatement(updateSQL);
        delete = this.conexao.prepareStatement(deleteSQL);
        select = this.conexao.prepareStatement(selectSQL);
    }
    
    @Override
    public ArrayList<Anotacao> getAllAnot() throws SQLException{
        ArrayList<Anotacao> anotacoes = new ArrayList<Anotacao>();
        ResultSet rs = select.executeQuery();
        
        while(rs.next()){
            Anotacao a = new Anotacao(rs.getString(2), rs.getString(3));
            a.setId(rs.getInt(1));
            anotacoes.add(a);
        }
        
       
        return anotacoes;
    }
    
    @Override
    public void salvar(Anotacao a) throws SQLException{       
        save.setString(1, a.getTitulo());
        save.setString(2, a.getConteudo());        
        save.execute();
    }
    
    @Override
    public void update(Anotacao a) throws SQLException{
        update.setString(1, a.getTitulo());
        update.setString(2, a.getConteudo());
        update.setInt(3, a.getId());

        update.executeUpdate();
    }
    
    @Override
    public void delete(Anotacao a) throws SQLException{
        delete.setInt(1, a.getId());
        delete.executeUpdate();
    }
    
}
