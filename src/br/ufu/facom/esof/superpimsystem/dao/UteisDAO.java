
package br.ufu.facom.esof.superpimsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.ufu.facom.esof.superpimsystem.control.Uteis;

public class UteisDAO extends DAO{
    
    private PreparedStatement save;
    private PreparedStatement update;
    private PreparedStatement delete;
    private PreparedStatement select;

    private final String insertSQL = "insert into Uteis values (default,?,?)";
    private final String updateSQL = "update Uteis set descricao = ?, tel = ? where id = ?";
    private final String deleteSQL = "delete from Uteis where id = ?";
    private final String selectSQL = "select * from Uteis";
     private Connection conexao;
    
    public UteisDAO(Connection conexao) throws SQLException{
        this.conexao = conexao;
        save = this.conexao.prepareStatement(insertSQL);
        update = this.conexao.prepareStatement(updateSQL);
        delete = this.conexao.prepareStatement(deleteSQL);
        select = this.conexao.prepareStatement(selectSQL);
    }
    
    @Override
    public ArrayList<Uteis> getAllUti() throws SQLException{
        ArrayList<Uteis> anotacoes = new ArrayList<Uteis>();
        ResultSet rs = select.executeQuery();
        
        while(rs.next()){
            Uteis a = new Uteis(rs.getString(2), rs.getString(3));
            a.setId(rs.getInt(1));
            anotacoes.add(a);
        }
        
        return anotacoes;
    }
    
    @Override
    public void salvar(Uteis a) throws SQLException{
        save.setString(1, a.getDescricao());
        save.setString(2, a.getTel());
        save.execute();
    }
    
    @Override
    public void update(Uteis a) throws SQLException{
        update.setString(1, a.getDescricao());
        update.setString(2, a.getTel());
        update.setInt(3, a.getId());

        update.executeUpdate();
    }
    
    public void delete(Uteis a) throws SQLException{
        delete.setInt(1, a.getId());
        delete.executeUpdate();
    }
    
}
