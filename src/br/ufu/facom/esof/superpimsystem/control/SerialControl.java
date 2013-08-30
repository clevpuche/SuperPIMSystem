package br.ufu.facom.esof.superpimsystem.control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.ufu.facom.esof.superpimsystem.model.SerialSenha;


public class SerialControl extends AbstractTableModel {


    private static final long serialVersionUID = 1L;


    private List<SerialSenha> linhas;
    private List<SerialSenha> filtrados;


    private String[] colunas = new String[]{
        "Usuário / Software", "Senha / Serial", "Comentário"};



    public void filtrarSenha(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (SerialSenha atual : linhas) {
            if (pesquisando.equals("")
                    || atual.getSenhaSerial().toLowerCase().contains(pesquisando)) {
                filtrados.add(atual);
            }

        }

        fireTableDataChanged();
    }

    public void filtrarUsuario(String pesquisando) {
        filtrados.clear();
        if (pesquisando == null) {
            pesquisando = "";
        }

        pesquisando = pesquisando.toLowerCase();

        for (SerialSenha atual : linhas) {
            if (pesquisando.equals("")
                    || atual.getUsuarioSoft().toLowerCase().contains(pesquisando)) {
                filtrados.add(atual);
            }

        }

        fireTableDataChanged();
    }


    public SerialControl() {
        linhas = new ArrayList<SerialSenha>();
        filtrados = new ArrayList<SerialSenha>();
    }


    public SerialControl(List<SerialSenha> listaDeSerialSenha) {
        linhas = new ArrayList<SerialSenha>(listaDeSerialSenha);
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
            SerialSenha SerialSenha = filtrados.get(rowIndex);


        switch (columnIndex) {
        //"Nome","DDD","Telefone","Celular","Cidade","Bairro","Endereço"
            case 0:
                return SerialSenha.getUsuarioSoft();
            case 1:
                return SerialSenha.getSenhaSerial();
            case 2:
                return SerialSenha.getComentario();

            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

 @Override
 public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      //nao preciso implementar!
     }
    ;

        public void setValueAt(SerialSenha aValue, int rowIndex) {

                    filtrados.set(rowIndex, aValue);
                    
        fireTableRowsUpdated(rowIndex, rowIndex);
    }
    ;


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }




    public SerialSenha getSerialSenha(int indiceLinha) {
        return filtrados.get(indiceLinha);
    }



    public void addSerialSenha(SerialSenha m) {

        linhas.add(m);


        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }


    public void removeSerialSenha(int indiceLinha) {
        linhas.remove(indiceLinha);

        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }


    public void addListaDeSerialSenha(List<SerialSenha> SerialSenha) {

        int tamanhoAntigo = getRowCount();


        linhas.addAll(SerialSenha);

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

