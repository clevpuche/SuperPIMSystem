package br.ufu.facom.esof.superpimsystem.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.ufu.facom.esof.superpimsystem.control.Uteis;

public class TelefoneModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private List<Uteis> linhas;
    private List<Uteis> filtrados;
    private String[] colunas = new String[]{
        "Telefone", "Descrição"};

    public TelefoneModel() {
        linhas = new ArrayList<Uteis>();
        filtrados = new ArrayList<Uteis>();
    }

    public TelefoneModel(List<Uteis> listaDeUteis) {
        linhas = new ArrayList<Uteis>(listaDeUteis);
    }

        public void filtrar(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (Uteis atual : linhas) {
            if (pesquisando.equals("")
                    || atual.getDescricao().toLowerCase().contains(pesquisando)) {
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
        Uteis Uteis = filtrados.get(rowIndex);


        switch (columnIndex) {
            //"Data", "Hora","Local", "Estatus", "Detalhes"
            case 0:
                return Uteis.getTel();
            case 1:
                return Uteis.getDescricao();

            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //nao preciso implementar!
    }

    ;

    public void setValueAt(Uteis aValue, int rowIndex) {

        filtrados.set(rowIndex, aValue);



        fireTableRowsUpdated(rowIndex, rowIndex);
    }

    ;

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Uteis getUteis(int indiceLinha) {
        return filtrados.get(indiceLinha);
    }

    public void addUteis(Uteis m) {

        linhas.add(m);


        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeUteis(int indiceLinha) {
        filtrados.remove(indiceLinha);

        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addListaDeUteis(List<Uteis> Uteis) {

        int tamanhoAntigo = getRowCount();


        linhas.addAll(Uteis);

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
