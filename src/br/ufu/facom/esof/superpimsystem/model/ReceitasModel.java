package br.ufu.facom.esof.superpimsystem.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.ufu.facom.esof.superpimsystem.control.Receita;

public class ReceitasModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private List<Receita> linhas;
    private List<Receita> filtrados;
    private String[] colunas = new String[]{
        "Nome", "Categoria","Ingredientes","Modo de Preparo"};

    public ReceitasModel() {
        linhas = new ArrayList<Receita>();
        filtrados = new ArrayList<Receita>();
    }

    public ReceitasModel(List<Receita> listaDeReceita) {
        linhas = new ArrayList<Receita>(listaDeReceita);
    }

    public void filtrarNome(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (Receita atual : linhas) {
            if (pesquisando.equals("")
                    || atual.getNomeDaReceita().toLowerCase().contains(pesquisando)) {
                filtrados.add(atual);
            }

        }

        fireTableDataChanged();
    }

     public void filtrarCategoria(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (Receita atual : linhas) {
            if (pesquisando.equals("")
                    || atual.getCategoria().toLowerCase().contains(pesquisando)) {
                filtrados.add(atual);
            }

        }

        fireTableDataChanged();
    }

    public void filtrarIngrediente(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (Receita atual : linhas) {
                if (pesquisando.equals("")
                        || atual.getIngredientes().toLowerCase().contains(pesquisando)) {
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
        Receita Receita = filtrados.get(rowIndex);


        switch (columnIndex) {
            //"Data", "Hora","Local", "Estatus", "Detalhes"
            case 0:
                return Receita.getNomeDaReceita();
            case 1:
                return Receita.getCategoria();
            case 2:
                return Receita.getIngredientes();
            case 3:
                return Receita.getModoDePreparo();

            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //nao preciso implementar!
    }

    ;

    public void setValueAt(Receita aValue, int rowIndex) {

        filtrados.set(rowIndex, aValue);



        fireTableRowsUpdated(rowIndex, rowIndex);
    }

    ;

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Receita getReceita(int indiceLinha) {
        return filtrados.get(indiceLinha);
    }

    public void addReceita(Receita m) {

        linhas.add(m);


        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeReceita(int indiceLinha) {
        filtrados.remove(indiceLinha);

        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addListaDeReceita(List<Receita> Receita) {

        int tamanhoAntigo = getRowCount();


        linhas.addAll(Receita);

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
