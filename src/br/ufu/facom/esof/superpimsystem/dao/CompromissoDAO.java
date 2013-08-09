
package br.ufu.facom.esof.superpimsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import br.ufu.facom.esof.superpimsystem.model.Compromisso;


public class CompromissoDAO extends DAO{
    
    private PreparedStatement save;
    private PreparedStatement update;
    private PreparedStatement delete;
    private PreparedStatement select; 
    private PreparedStatement selectComNotificacao;
    
    private final String insertSQL = "insert into Compromisso values (default,?,?,?,?,?,?,?)";
    private final String updateSQL = "update Compromisso set data = ?, hora = ?, localidade = ?, detalhes = ?, notificacao = ?, fuiNotificadoVespera = ?, fuiNotificadoDia = ? where id = ?";
    private final String deleteSQL = "delete from Compromisso where id = ?";
    private final String selectSQL = "select * from Compromisso";
    private final String selectComNotSQL = "select * from Compromisso where notificacao = TRUE AND (fuiNotificadoVespera = FALSE OR fuiNotificadoDia = FALSE );";
    private Connection conexao;
    
    public CompromissoDAO(Connection conexao) throws SQLException{
        this.conexao = conexao;
        save = this.conexao.prepareStatement(insertSQL);
        update = this.conexao.prepareStatement(updateSQL);
        delete = this.conexao.prepareStatement(deleteSQL);
        select = this.conexao.prepareStatement(selectSQL);
        selectComNotificacao = this.conexao.prepareStatement(selectComNotSQL);
    }
    
    @Override
    public ArrayList<Compromisso> getCompNot() throws SQLException{
        ArrayList<Compromisso> compromissos = new ArrayList<Compromisso>();
        ResultSet rs = selectComNotificacao.executeQuery();
        
        while(rs.next()){
            Compromisso a = new Compromisso(rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getBoolean(6));
            
            a.setFuiNotificadoVespera(rs.getBoolean(7));
            a.setFuiNotificadoDia(rs.getBoolean(8));
            a.setId(rs.getInt(1));
            compromissos.add(a);
        }
        
        return compromissos;
    }
    
    @Override
    public ArrayList<Compromisso> getAllComp() throws SQLException{
        ArrayList<Compromisso> compromissos = new ArrayList<Compromisso>();
        ResultSet rs = select.executeQuery();
        
        while(rs.next()){
            Compromisso a = new Compromisso(rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getBoolean(6));
            
            a.setFuiNotificadoVespera(rs.getBoolean(7));
            a.setFuiNotificadoDia(rs.getBoolean(8));               
            a.setId(rs.getInt(1));
            compromissos.add(a);
        }
        
        return compromissos;
    }
    
    @Override
    public void salvar(Compromisso a) throws SQLException{       
        save.setDate(1, a.getData());
        save.setString(2, a.getHora());        
        save.setString(3, a.getLocal());
        save.setString(4, a.getDetalhes());
        save.setBoolean(5, a.isNotificacao());
        save.setBoolean(6, a.isFuiNotificadoVespera());
        save.setBoolean(7, a.isFuiNotificadoDia());
        save.execute();
    }
    
    @Override
    public void update(Compromisso a) throws SQLException{
        update.setDate(1, a.getData());
        update.setString(2, a.getHora());
        update.setString(3, a.getLocal());
        update.setString(4, a.getDetalhes());
        update.setBoolean(5, a.isNotificacao());
        update.setBoolean(6, a.isFuiNotificadoVespera());
        update.setBoolean(7, a.isFuiNotificadoDia());
        update.setInt(8, a.getId());
    }
    
    @Override
    public void delete(Compromisso a) throws SQLException{
        delete.setInt(1, a.getId());
        delete.executeUpdate();
    }
}
