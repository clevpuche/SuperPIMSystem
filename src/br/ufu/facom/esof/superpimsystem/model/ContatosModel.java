package br.ufu.facom.esof.superpimsystem.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.ufu.facom.esof.superpimsystem.control.Contato;

public class ContatosModel extends AbstractTableModel {


    private static final long serialVersionUID = 1L;


    private List<Contato> linhas;
    private List<Contato> filtrados;


    private String[] colunas = new String[]{
        "Nome","DDD","Telefone","Celular","Cidade","Bairro","Endereço"};

        public void filtrarBairro(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (Contato atual : linhas) {
            if (pesquisando.equals("")
                    || atual.getBairro().toLowerCase().contains(pesquisando)) {
                filtrados.add(atual);
            }

        }

        fireTableDataChanged();
    }

    public void filtrarCidade(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (Contato atual : linhas) {
            if (pesquisando.equals("")
                    || atual.getCidade().toLowerCase().contains(pesquisando)) {
                filtrados.add(atual);
            }

        }

        fireTableDataChanged();
    }

    public void filtrarDDD(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (Contato atual : linhas) {

            String procurandoPor = "" + atual.getDDD();
            if (pesquisando.equals("")
                    || procurandoPor.contains(pesquisando)) {
                filtrados.add(atual);
            }
        }

        fireTableDataChanged();
    }

    public void filtrarNome(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null){pesquisando = "";}

        pesquisando = pesquisando.toLowerCase();

        for (Contato atual : linhas) {
            if (pesquisando.equals("")
                    || atual.getNome().toLowerCase().contains(pesquisando)) {
                filtrados.add(atual);
            }

        }

        fireTableDataChanged();
    }

    public ContatosModel() {
        linhas = new ArrayList<Contato>();
        filtrados = new ArrayList<Contato>();
        filtrarNome("");
    }


    public ContatosModel(List<Contato> listaDeContato) {
        linhas = new ArrayList<Contato>(listaDeContato);
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
            Contato Contato = filtrados.get(rowIndex);


        switch (columnIndex) {
        //"Nome","DDD","Telefone","Celular","Cidade","Bairro","Endereço"
            case 0:
                return Contato.getNome();
            case 1:
                return Contato.getDDD();
            case 2:
                return Contato.getTel();
            case 3:
                return Contato.getCel();
            case 4:
                return Contato.getCidade();
            case 5:
                return Contato.getBairro();
            case 6:
                return Contato.getEndereco();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

 @Override
 public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      //nao preciso implementar!
     }
    ;

        public void setValueAt(Contato aValue, int rowIndex) {

                    filtrados.set(rowIndex, aValue);


        fireTableRowsUpdated(rowIndex, rowIndex);
    }
    ;


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }




    public Contato getContato(int indiceLinha) {
        return filtrados.get(indiceLinha);
    }



    public void addContato(Contato m) {

        linhas.add(m);

        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }


    public void removeContato(int indiceLinha) {
        linhas.remove(indiceLinha);

        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }


    public void addListaDeContato(List<Contato> Contato) {

        int tamanhoAntigo = getRowCount();


        linhas.addAll(Contato);

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

