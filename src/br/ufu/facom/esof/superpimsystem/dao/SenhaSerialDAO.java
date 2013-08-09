
package br.ufu.facom.esof.superpimsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.ufu.facom.esof.superpimsystem.model.SerialSenha;

public class SenhaSerialDAO extends DAO{

    private PreparedStatement save;
    private PreparedStatement update;
    private PreparedStatement delete;
    private PreparedStatement select;

    private final String insertSQL = "insert into Senha values (default,?,?,?)";
    private final String updateSQL = "update Senha set  usuario = ?,senha = ?,comentario = ? where id = ?";
    private final String deleteSQL = "delete from Senha where id = ?";
    private final String selectSQL = "select * from Senha";
    private Connection conexao;
    
    public SenhaSerialDAO(Connection conexao) throws SQLException{
        this.conexao = conexao;
        save = this.conexao.prepareStatement(insertSQL);
        update = this.conexao.prepareStatement(updateSQL);
        delete = this.conexao.prepareStatement(deleteSQL);
        select = this.conexao.prepareStatement(selectSQL);
    }
    
    @Override
    public ArrayList<SerialSenha> getAllSen() throws SQLException{
        ArrayList<SerialSenha> anotacoes = new ArrayList<SerialSenha>();
        ResultSet rs = select.executeQuery();
        
        while(rs.next()){
            SerialSenha a = new SerialSenha(rs.getString(2), rs.getString(3),rs.getString(4));
            a.setId(rs.getInt(1));
            anotacoes.add(a);
        }
        
        return anotacoes;
    }
    
    @Override
    public void salvar(SerialSenha a) throws SQLException{
        save.setString(1, a.getUsuarioSoft());
        save.setString(2, a.getSenhaSerial());
        save.setString(3, a.getComentario());
        save.execute();
    }
    
    @Override
    public void update(SerialSenha a) throws SQLException{
        update.setString(1, a.getUsuarioSoft());
        update.setString(2, a.getSenhaSerial());
        update.setString(3, a.getComentario());
        update.setInt(4, a.getId());

        update.executeUpdate();
    }
    
    @Override
    public void delete(SerialSenha a) throws SQLException{
        delete.setInt(1, a.getId());
        delete.executeUpdate();
    }
    
}
