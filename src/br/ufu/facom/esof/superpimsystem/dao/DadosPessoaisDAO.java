
package br.ufu.facom.esof.superpimsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.ufu.facom.esof.superpimsystem.model.DadosPessoais;


public class DadosPessoaisDAO extends DAO {
    
    private Connection conexao;


    private PreparedStatement update;
    private PreparedStatement select; 


    private final String updateSQL = "update DadosPessoais set nome = ?, email = ?, facebookuser = ?, facebookpassword = ?, twitteruser = ?, twitterpassword = ? where id = 1";
    private final String selectSQL = "select * from DadosPessoais where id = 1";

    public DadosPessoaisDAO(Connection conexao) throws SQLException{
        this.conexao = conexao;
        update = this.conexao.prepareStatement(updateSQL);
        select = this.conexao.prepareStatement(selectSQL);
    }
    
    @Override
    public DadosPessoais getDado() throws SQLException{
        ResultSet rs = select.executeQuery();
        DadosPessoais a = null;
        while(rs.next()){
                a = new DadosPessoais(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
         }
        
        if(a == null){
            a = new DadosPessoais("NaoRegistrou", "NaoRegistrou@NaoRegistrou", "NaoRegistrou", "Vazio", "NaoRegistrou", "Vazio");
        }
               
        return a;       
    }
    

    @Override
    public void update(DadosPessoais a) throws SQLException{
        update.setString(1, a.getNome());
        update.setString(2, a.getEmail());
        update.setString(3, a.getFacebookUser());
        update.setString(4, a.getFacebookPassword());
        update.setString(5, a.getTwitterUser());
        update.setString(6, a.getTwitterPassword());

        update.executeUpdate();
    }
    
    
}
