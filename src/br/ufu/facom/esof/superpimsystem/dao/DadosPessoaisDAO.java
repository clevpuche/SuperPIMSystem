
package br.ufu.facom.esof.superpimsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.ufu.facom.esof.superpimsystem.control.DadosPessoais;


public class DadosPessoaisDAO extends DAO {
    
    private Connection conexao;


    private PreparedStatement update;
    private PreparedStatement select; 


    private final String updateSQL = "update DadosPessoais set nome = ?, email = ?where id = 1";
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
                a = new DadosPessoais(rs.getString(2), rs.getString(3));
         }
        
        if(a == null){
            a = new DadosPessoais("NaoRegistrou", "NaoRegistrou@NaoRegistrou");
        }
               
        return a;       
    }
    

    @Override
    public void update(DadosPessoais a) throws SQLException{
        update.setString(1, a.getNome());
        update.setString(2, a.getEmail());

        update.executeUpdate();
    }
    
    
}
