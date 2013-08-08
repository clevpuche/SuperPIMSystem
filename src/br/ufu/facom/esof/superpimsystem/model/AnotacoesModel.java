package br.ufu.facom.esof.superpimsystem.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.ufu.facom.esof.superpimsystem.control.Anotacao;

public class AnotacoesModel extends AbstractTableModel {


    private static final long serialVersionUID = 1L;


    private List<Anotacao> linhas;
     private List<Anotacao> filtrados;


    private String[] colunas = new String[]{
        "Título","Conteúdo"};

    public AnotacoesModel() {
        linhas = new ArrayList<Anotacao>();
        filtrados = new ArrayList<Anotacao>();
    }


    public AnotacoesModel(List<Anotacao> listaDeAnotacao) {
        linhas = new ArrayList<Anotacao>(listaDeAnotacao);
    }

            public void filtrar(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (Anotacao atual : linhas) {
            if (pesquisando.equals("")
                    || atual.getTitulo().toLowerCase().contains(pesquisando)) {
                filtrados.add(atual);
            }

        }

        fireTableDataChanged();
    }



    @Override
    public int getColumnCount() {
        return colunas.length;
    }


    @Override
    public int getRowCount() {
        return filtrados.size();
    }


    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    ;

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    ;


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
            Anotacao Anotacao = filtrados.get(rowIndex);


        switch (columnIndex) {
        //"Nome","DDD","Telefone","Celular","Cidade","Bairro","Endereço"
            case 0:
                return Anotacao.getTitulo();
            case 1:
                return Anotacao.getConteudo();

            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

 @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //nao preciso implementar!
    }

    ;

    public void setValueAt(Anotacao aValue, int rowIndex) {

        filtrados.set(rowIndex, aValue);

        fireTableRowsUpdated(rowIndex, rowIndex);
    }

    ;


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }




    public Anotacao getAnotacao(int indiceLinha) {
        return filtrados.get(indiceLinha);
    }



    public void addAnotacao(Anotacao m) {

        linhas.add(m);


        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }


    public void removeAnotacao(int indiceLinha) {
        filtrados.remove(indiceLinha);

        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }


    public void addListaDeAnotacao(List<Anotacao> Anotacao) {


        int tamanhoAntigo = getRowCount();

        linhas.addAll(Anotacao);

        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);

    }


    public void limpar() {
        linhas.clear();


        fireTableDataChanged();
    }


    public boolean isEmpty() {
        return linhas.isEmpty();
    }



}

