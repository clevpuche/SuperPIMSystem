package br.ufu.facom.esof.superpimsystem.model;

import br.ufu.facom.esof.superpimsystem.view.Principal;
import br.ufu.facom.esof.superpimsystem.dao.DAO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class ThreadCompromisso implements Runnable {

    ArrayList<Compromisso> comNotificacao = null;
    DAO d;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdfBR = new SimpleDateFormat("dd/MM/yyyy");

    
    public void enviarEmail(String para,String assunto,String conteudo) {
        SendMail sm = new SendMail();
        try{
        sm.sendMail("lembretesnortev@gmail.com", para, assunto, conteudo);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "..::ATENÇÃO ::..\n\nNotificação de compromisso!\n\nAssunto:\n"+assunto+"\n\nConteudo:\n"+conteudo," Notificação de Compromisso",JOptionPane.WARNING_MESSAGE);
        }
        }
    
    
    public synchronized void addCom(Compromisso c) {
        if (c.isNotificacao()) {
            comNotificacao.add(c);
        }
    }

    public synchronized void remCom(Compromisso c) {
        comNotificacao.remove(c);
    }

    public ThreadCompromisso(DAO d) {
        this.d = d;
    }

    public void run() {
        try{
            comNotificacao = d.getCompNot();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        if(comNotificacao == null){
            comNotificacao = new ArrayList<Compromisso>();
        }
        

        while (true) {
            verificarLista();
            try {
                Thread.sleep(600000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }

    private synchronized void verificarLista() {
        ArrayList<Compromisso> comRemovidos = new ArrayList<Compromisso>();

        java.sql.Date dataHoje = new java.sql.Date(new java.util.Date().getTime());
        String stringHoje = sdf.format(dataHoje);


        for (Compromisso not : comNotificacao) {
            Calendar vespera = Calendar.getInstance();
            vespera.setTime(not.getData());
            vespera.add(Calendar.DATE, -1);

            java.sql.Date dataVespera = new java.sql.Date(vespera.getTime().getTime());
            java.sql.Date dataComp = not.getData();

            String stringVespera = sdf.format(dataVespera);
            String stringComp = sdf.format(dataComp);


            if (not.isFuiNotificadoVespera() == false) {
                boolean naoHoje = true;

                //se HOJE for o dia da vespera...
                if (stringVespera.equals(stringHoje)) {
                    //manda o email avisando q ta na vespera...
                    enviarEmail(Principal.dados.getEmail(),"Amanha voce tem um compromisso! -Equipe Nortev Solutions","Caro(a) "+Principal.dados.getNome()+",\nAmanha, dia: "+sdfBR.format(dataComp)+", você tem um compromisso.\n\nLocal: "+not.getLocal()+"\nHora: "+not.getHora()+"\nAssunto: "+not.getDetalhes());                        
                    not.setFuiNotificadoVespera(true);
                    naoHoje = false;
                    
                    try {
                        d.update(not);
                    } catch (SQLException e) {
                        System.out.println("erro na thread");
                        e.printStackTrace();
                    }
                    
                }

                if (naoHoje) {
                    //se HOJE for depois da vespera...
                    if (dataHoje.after(dataVespera)) {
                        enviarEmail(Principal.dados.getEmail(),"Notificacao de compromisso possivelmente atrasado! Super PIM System","Caro(a) "+Principal.dados.getNome()+",\nNo  dia: "+sdfBR.format(dataComp)+", voce tem/tinha um compromisso.\n\nLocal: "+not.getLocal()+"\nHora: "+not.getHora()+"\nAssunto: "+not.getDetalhes());                        
                        not.setFuiNotificadoVespera(true);
                        try {
                            d.update(not);
                        } catch (SQLException e) {
                            System.out.println("erro na thread");
                            e.printStackTrace();
                        }
                    }
                }

            } else {
                boolean naoHoje = true;


                if (stringComp.equals(stringHoje)) {
                    //mando o email falando que é hoje...
                    enviarEmail(Principal.dados.getEmail(),"Hoje voce tem um compromisso! -Equipe Nortev Solutions","Caro(a) "+Principal.dados.getNome()+",\nHoje, dia: "+sdfBR.format(dataComp)+", voce tem um compromisso.\n\nLocal: "+not.getLocal()+"\nHora: "+not.getHora()+"\nAssunto: "+not.getDetalhes());                        
                    not.setFuiNotificadoDia(true);
                    naoHoje = false;
                    try {
                        d.update(not);
                    } catch (SQLException e) {
                        System.out.println("erro na thread");
                        e.printStackTrace();
                    }
                    comRemovidos.add(not);
                }

                if (naoHoje) {
                    //se HOJE for depois da dia do compromisso...

                    if (dataHoje.after(not.getData())) {
                       enviarEmail(Principal.dados.getEmail(),"Voce perdeu um compromisso... -Equipe Nortev Solutions","Caro(a) "+Principal.dados.getNome()+",\nNo  dia: "+sdfBR.format(dataComp)+", voce tinha um compromisso.\n\nLocal: "+not.getLocal()+"\nHora: "+not.getHora()+"\nAssunto: "+not.getDetalhes());                        
                        not.setFuiNotificadoDia(true);
                        try {
                            d.update(not);
                        } catch (SQLException e) {
                            System.out.println("erro na thread");
                            e.printStackTrace();
                        }
                        comRemovidos.add(not);
                    }
                }
            }
        }


        for (Compromisso rem : comRemovidos) {
            this.remCom(rem);
        }

    }
}
