
package br.ufu.facom.esof.superpimsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.ufu.facom.esof.superpimsystem.model.Contato;


public class ContatoDAO extends DAO {
    
    private PreparedStatement save;
    private PreparedStatement update;
    private PreparedStatement delete;
    private PreparedStatement select; 

    private final String insertSQL = "insert into Contato values (default,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String updateSQL = "update Contato set nome = ?, DDD = ?, tel = ?, cel = ?, msn = ?, skype = ?, estado = ?, cidade = ?, bairro = ?, endereco = ?, site = ?, informacoesAdd = ?, email = ? where id = ?";
    private final String deleteSQL = "delete from Contato where id = ?";
    private final String selectSQL = "select * from Contato";
     private Connection conexao;
    
    public ContatoDAO(Connection conexao) throws SQLException{
        this.conexao = conexao;
        save = this.conexao.prepareStatement(insertSQL);
        update = this.conexao.prepareStatement(updateSQL);
        delete = this.conexao.prepareStatement(deleteSQL);
        select = this.conexao.prepareStatement(selectSQL);
    }
    @Override
    public ArrayList<Contato> getAllCon() throws SQLException{
        ArrayList<Contato> anotacoes = new ArrayList<Contato>();
        ResultSet rs = select.executeQuery();
        
        while(rs.next()){
            Contato a = new Contato(       rs.getString(2),        rs.getInt(3),        rs.getString(4),        rs.getString(5),        rs.getString(6),        rs.getString(7),        rs.getString(8),        rs.getString(9),        rs.getString(10),        rs.getString(11),        rs.getString(12),        rs.getString(13),        rs.getString(14));
            a.setId(rs.getInt(1));
            anotacoes.add(a);
        }
        
        return anotacoes;
    }
    
    public void salvar(Contato a) throws SQLException {
        save.setString(1, a.getNome());
        save.setInt(2, a.getDDD());
        save.setString(3, a.getCel());
        save.setString(4, a.getCel());
        save.setString(5, a.getMsn());
        save.setString(6, a.getSkype());
        save.setString(7, a.getEstado());
        save.setString(8, a.getCidade());
        save.setString(9, a.getBairro());
        save.setString(10, a.getEndereco());
        save.setString(11, a.getSite());
        save.setString(12, a.getInformacoesAdd());
        save.setString(13, a.getEmail());
        save.execute();
    }
    
    public void update(Contato a) throws SQLException{
       update.setString(1, a.getNome());
        update.setInt(2, a.getDDD());
        update.setString(3, a.getCel());
        update.setString(4, a.getCel());
        update.setString(5, a.getMsn());
        update.setString(6, a.getSkype());
        update.setString(7, a.getEstado());
        update.setString(8, a.getCidade());
        update.setString(9, a.getBairro());
        update.setString(10, a.getEndereco());
        update.setString(11, a.getSite());
        update.setString(12, a.getInformacoesAdd());
        update.setString(13, a.getEmail());
        update.setInt(14, a.getId());
        
        update.executeUpdate();
    }
    
    public void delete(Contato a) throws SQLException{
        delete.setInt(1, a.getId());
        delete.executeUpdate();
    }
    
}
