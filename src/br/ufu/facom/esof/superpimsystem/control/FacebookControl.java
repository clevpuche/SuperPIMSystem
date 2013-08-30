/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufu.facom.esof.superpimsystem.control;

import br.ufu.facom.esof.superpimsystem.view.Principal;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.User;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class FacebookControl {

    public FacebookControl() {
        
    }
    
    
    public void postarMensagem(String mensagem) throws SQLException, NullPointerException {
               
        
        //Cria a conexão com o Facebook com o usuário e o token access cadastrado...
        FacebookClient fbClient = new DefaultFacebookClient(Principal.dados.getFacebookPassword());
        User user = fbClient.fetchObject(Principal.dados.getFacebookUser(), com.restfb.types.User.class);
        
        FacebookType publishMessageResponse;
        publishMessageResponse = fbClient.publish("me/feed", FacebookType.class, Parameter.with("message",mensagem));
     }

    
}
