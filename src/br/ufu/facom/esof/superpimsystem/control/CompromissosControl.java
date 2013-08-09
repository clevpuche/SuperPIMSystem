package br.ufu.facom.esof.superpimsystem.control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.ufu.facom.esof.superpimsystem.model.Compromisso;

public class CompromissosControl extends AbstractTableModel {


    private static final long serialVersionUID = 1L;


    private List<Compromisso> linhas;
    private List<Compromisso> filtrados;


    private String[] colunas = new String[]{
        "Data", "Hora","Local", "Detalhes"};

      
      
    public void filtrarDetalhes(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (Compromisso atual : linhas) {
            if (pesquisando.equals("")
                    || atual.getDetalhes().toLowerCase().contains(pesquisando)) {
                filtrados.add(atual);
            }

        }

        fireTableDataChanged();
    }
  
    public void filtrarLocal(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (Compromisso atual : linhas) {
            if (pesquisando.equals("")
                    || atual.getLocal().toLowerCase().contains(pesquisando)) {
                filtrados.add(atual);
            }

        }

        fireTableDataChanged();
    }
public void filtrarHora(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (Compromisso atual : linhas) {
            if (pesquisando.equals("")
                    || atual.getHora().toLowerCase().contains(pesquisando)) {
                filtrados.add(atual);
            }

        }

        fireTableDataChanged();
    }

public void filtrarData(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (Compromisso atual : linhas) {
            if (pesquisando.equals("")
                    || atual.getData().toString().toLowerCase().contains(pesquisando)) {
                filtrados.add(atual);
            }

        }

        fireTableDataChanged();
    }


    public CompromissosControl() {
        linhas = new ArrayList<Compromisso>();
        filtrados = new ArrayList<Compromisso>();
    }


    public CompromissosControl(List<Compromisso> listaDeCompromisso) {
        linhas = new ArrayList<Compromisso>(listaDeCompromisso);
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
            Compromisso Compromisso = filtrados.get(rowIndex);


        switch (columnIndex) {
        //"Data", "Hora","Local", "Estatus", "Detalhes"
            case 0:
                return Compromisso.getData();
            case 1:
                return Compromisso.getHora();
            case 2:
                return Compromisso.getLocal();

            case 3:
                return Compromisso.getDetalhes();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

 @Override
 public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      //nao preciso implementar!
     }
    ;

        public void setValueAt(Compromisso aValue, int rowIndex) {

                    filtrados.set(rowIndex, aValue);


        fireTableRowsUpdated(rowIndex, rowIndex);
    }
    ;


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }




    public Compromisso getCompromisso(int indiceLinha) {
        return filtrados.get(indiceLinha);
    }



    public void addCompromisso(Compromisso m) {

        linhas.add(m);


        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }


    public void removeCompromisso(int indiceLinha) {
        linhas.remove(indiceLinha);

        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }


    public void addListaDeCompromisso(List<Compromisso> Compromisso) {

        int tamanhoAntigo = getRowCount();


        linhas.addAll(Compromisso);

        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }


    public void limpar() {
        linhas.clear();


        fireTableDataChanged();
    }


    public boolean isEmpty() {
        return linhas.isEmpty();
    }

    public ArrayList<Compromisso> getAllCompromissos() {
        return (ArrayList) linhas;
    }



}

