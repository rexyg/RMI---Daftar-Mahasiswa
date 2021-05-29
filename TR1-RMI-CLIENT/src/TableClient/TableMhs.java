package TableClient;

import entity.Mahasiswa;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


//utk menampilkan data di database ke Jframe
public class TableMhs extends AbstractTableModel {
    private List<Mahasiswa> list = new ArrayList<Mahasiswa>();
    
    //utk mengambil data trs ditampilkan ditabel 
    public Mahasiswa get (int row){
        return list.get (row); 
    }

    //untuk merubah data yang ada pada table
    public void setData(List<Mahasiswa> list) {
        this.list = list;
        fireTableDataChanged();
    }
    
    //menentukan jumlah baris ditabel berdasarkan data 
    @Override
    public int getRowCount() {
        return list.size ();
    }

    //menentukan byk jlh kolom pada tabel 
    @Override
    public int getColumnCount() {
        return 5; //utk 5 kolom
    }

    //mengambil dan menampilkan data kedlm kolom yg ditentukan
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0 :
                return list.get(rowIndex).getNim();
            case 1 :
                return list.get(rowIndex).getNama();
            case 2 :
                return list.get(rowIndex).getProgdi();
            case 3 :
                return list.get(rowIndex).getFakultas();
            case 4 :
                return list.get(rowIndex).getPhone();
                
            default :
                return null; 
        }
    }
    
    @Override
    public String getColumnName (int column){
        switch (column){
            case 0 :
                return "NIM";
            case 1 :
                return "Nama";
            case 2 :
                return "Program Studi";
            case 3 : 
                return "Fakultas";
            case 4 :
                return "Nomor Telp";
                
            default :
                return null;
        }
    
    }
}
