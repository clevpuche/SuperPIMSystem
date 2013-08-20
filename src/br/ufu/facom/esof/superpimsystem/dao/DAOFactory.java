package br.ufu.facom.esof.superpimsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOFactory {

    private static DAOFactory single = null;
    public static final int ANOTACAO = 1;
    public static final int COMPROMISSO = 2;
    public static final int CONTATO = 3;
    public static final int RECEITA = 4;
    public static final int SENHA = 5;
    public static final int UTEIS = 6;
    public static final int DADOS = 7;
    private AnotacaoDAO anotDAO;
    private CompromissoDAO compDAO;
    private ContatoDAO contDAO;
    private ReceitaDAO recDAO;
    private SenhaSerialDAO senDAO;
    private UteisDAO utilDAO;
    private DadosPessoaisDAO dadosDAO;
    private String url = "jdbc:h2:./lib/superPIMSystem";
    private String user = "admin";
    private String pass = "admin";
    private String driver = "org.h2.Driver";
    private Connection conexao;

    private DAOFactory() {
        try {

            Class.forName(driver);
            conexao = null;

            conexao = DriverManager.getConnection(url, user, pass);          
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try{
            create();
        }catch(Exception e){
        }
        
         try{
            inserirDado();
        }catch(Exception e){
        }
    
        
        try{
            anotDAO = new AnotacaoDAO(conexao);
            compDAO = new CompromissoDAO(conexao);
            contDAO = new ContatoDAO(conexao);
            recDAO = new ReceitaDAO(conexao);
            senDAO = new SenhaSerialDAO(conexao);
            utilDAO = new UteisDAO(conexao);
            dadosDAO = new DadosPessoaisDAO(conexao);
  
        }catch(Exception e){
            e.printStackTrace();
        }


    }
    
    public void fechaConexao(){
        try{
            conexao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void create() throws SQLException {
        StringBuilder createTable = new StringBuilder();
        createTable.append("create table Anotacao(");
        createTable.append("id int identity Primary key,");
        createTable.append("titulo varchar,");
        createTable.append("conteudo varchar");
        createTable.append(");");

        createTable.append("create table Compromisso(");
        createTable.append("id int identity Primary key,");
        createTable.append("data Date,");
        createTable.append("hora varchar,");
        createTable.append("localidade varchar,");
        createTable.append("detalhes varchar,");
        createTable.append("notificacao boolean,");
        createTable.append("fuiNotificadoVespera boolean,");
        createTable.append("fuiNotificadoDia boolean");
        createTable.append(");");

        createTable.append("create table Contato(");
        createTable.append("id int identity Primary key,");
        createTable.append("nome varchar,");
        createTable.append("dataNascimento varchar,");
        createTable.append("DDD Integer,");
        createTable.append("tel varchar,");
        createTable.append("cel varchar,");
        createTable.append("msn varchar,");
        createTable.append("skype varchar,");
        createTable.append("estado varchar,");
        createTable.append("cidade varchar,");
        createTable.append("bairro varchar,");
        createTable.append("endereco varchar,");
        createTable.append("site varchar,");
        createTable.append("informacoesAdd varchar,");
        createTable.append("email varchar");
        createTable.append(");");

        createTable.append("create table Receita(");
        createTable.append("id int identity Primary key,");
        createTable.append("nomeDaReceita varchar,");
        createTable.append("ModoDePreparo varchar,");
        createTable.append("categoria varchar,");
        createTable.append("ingredientes varchar");
        createTable.append(");");

        createTable.append("create table Senha(");
        createTable.append("id int identity Primary key,");
        createTable.append("usuario varchar,");
        createTable.append("senha varchar,");
        createTable.append("comentario varchar");
        createTable.append(");");

        createTable.append("create table Uteis(");
        createTable.append(" id int identity Primary key,");
        createTable.append(" descricao varchar,");
        createTable.append(" tel varchar");
        createTable.append(");");

        createTable.append("create table DadosPessoais(");
        createTable.append("id int primary key,");
        createTable.append("nome varchar,");
        createTable.append("email varchar,");
        createTable.append("facebookuser varchar,");
        createTable.append("facebookpassword varchar,");
        createTable.append("twitteruser varchar,");
        createTable.append("twitterpassword varchar");
        createTable.append(");");

        Statement cria = conexao.createStatement();
        cria.execute(createTable.toString());
    }
    
    public void inserirDado() throws SQLException{
       StringBuilder insertDado = new StringBuilder();
        insertDado.append("insert into DadosPessoais values (1,'NaoRegistrou2','NaoRegistrou@NaoRegistrou2','','','','');");

        Statement insere = conexao.createStatement();
        insere.execute(insertDado.toString());
    }
    

    public DAO getDAO(int tipo) {
        switch (tipo) {
            case DAOFactory.ANOTACAO:
                return anotDAO;
            case DAOFactory.COMPROMISSO:
                return compDAO;
            case DAOFactory.CONTATO:
                return contDAO;
            case DAOFactory.RECEITA:
                return recDAO;
            case DAOFactory.SENHA:
                return senDAO;
            case DAOFactory.UTEIS:
                return utilDAO;
            case DAOFactory.DADOS:
                return dadosDAO;
        }

        return null;
    }

    public static DAOFactory getInstance() {
        if (single == null) {
            single = new DAOFactory();
        }
        return single;
    }
    
    public Connection getConnection() {
        return conexao;
    }
}
