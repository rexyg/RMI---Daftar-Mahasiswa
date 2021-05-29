package ViewClient;

//class Jframe Client

import TableClient.TableMhs;
import entity.Mahasiswa;
import java.rmi.RemoteException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;
import service.MhsInterface;

public class FormClient extends javax.swing.JFrame {
    
    //membuat objek dari class 'TabelMhs' utk menampilkan data pada tabel
    private TableMhs tableMhs = new TableMhs();
    
    //membuat objek dr class 'MhsInterface' utk memproses permintaan
    private MhsInterface service; 
    
    public FormClient(MhsInterface service){
        this.service = service ;
        
        //mengambil seluruh data yg ada di database 
        //menyimpan ke objek TabelMhs di Jframe client
        try{
            tableMhs.setData(service.getAllMahasiswa());
        }catch (RemoteException e) {
            e.printStackTrace();
        }
        initComponents();
        
        //menampilkan data dan menata data yg didpt dari objek 'TabelMhs'
        //kedlm TabelMhs di Jframe Client
        tableMahasiswa.setModel(tableMhs);
        tableMahasiswa.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        
            @Override 
            public void valueChanged (ListSelectionEvent e){
                int row = tableMahasiswa.getSelectedRow();
                if (row != -1){
                    Mahasiswa Mahasiswa = tableMhs.get(row); 

                    txtNim.setText(Mahasiswa.getNim());
                    txtNama.setText(Mahasiswa.getNama());
                    comboProgdi.setSelectedItem(Mahasiswa.getProgdi());
                    comboFakultas.setSelectedItem(Mahasiswa.getFakultas());
                    txtPhone.setText(Mahasiswa.getPhone());
                }
            }
        });
    }

    private FormClient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNim = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMahasiswa = new javax.swing.JTable();
        buttonInsert = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        buttonRefresh = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        comboProgdi = new javax.swing.JComboBox<>();
        comboFakultas = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 102, 0));
        jLabel1.setText("Data Mahasiswa ");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("NIM");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nama");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Progdi");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Fakultas");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Phone");

        txtNim.setBackground(new java.awt.Color(204, 204, 204));
        txtNim.setForeground(new java.awt.Color(0, 0, 0));
        txtNim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNimActionPerformed(evt);
            }
        });

        txtNama.setBackground(new java.awt.Color(204, 204, 204));
        txtNama.setForeground(new java.awt.Color(0, 0, 0));

        txtPhone.setBackground(new java.awt.Color(204, 204, 204));
        txtPhone.setForeground(new java.awt.Color(0, 0, 0));

        tableMahasiswa.setBackground(new java.awt.Color(255, 255, 255));
        tableMahasiswa.setForeground(new java.awt.Color(0, 0, 0));
        tableMahasiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NIM", "Nama", "Progdi", "Fakultas", "Phone"
            }
        ));
        tableMahasiswa.setGridColor(new java.awt.Color(0, 0, 0));
        tableMahasiswa.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tableMahasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMahasiswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMahasiswa);

        buttonInsert.setText("INSERT ");
        buttonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsertActionPerformed(evt);
            }
        });

        buttonUpdate.setText("UPDATE");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });

        buttonRefresh.setText("REFRESH");
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });

        buttonDelete.setText("DELETE");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        buttonSearch.setText("Search ");
        buttonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchActionPerformed(evt);
            }
        });

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        comboProgdi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teknik Informatika", "Hukum", "Teknik Elektro ", "Musik" }));
        comboProgdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProgdiActionPerformed(evt);
            }
        });

        comboFakultas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fakultas Teknologi Informasi ", "Fakultas Seni dan Bahasa", "Fakultas Hukum", "Fakultas Teknik " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addGap(32, 32, 32)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPhone)
                                .addComponent(txtNama)
                                .addComponent(txtNim)
                                .addComponent(comboProgdi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboFakultas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(buttonInsert)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonUpdate)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonDelete)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(buttonRefresh))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(comboProgdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboFakultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonInsert)
                            .addComponent(buttonUpdate)
                            .addComponent(buttonDelete)
                            .addComponent(buttonRefresh)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNimActionPerformed

    //untuk search
    private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed
        // Tprosedur utk mencari data di tabel Jframe
        TableRowSorter rowSorter = new TableRowSorter (tableMhs);
        txtSearch.getDocument().addDocumentListener(new DocumentListener () {
            
            @Override
            public void insertUpdate(DocumentEvent e) {
                tableMahasiswa.setRowSorter(rowSorter);
                rowSorter.setRowFilter(RowFilter.regexFilter(txtSearch.getText()));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
               tableMahasiswa.setRowSorter(rowSorter);
               rowSorter.setRowFilter(RowFilter.regexFilter(txtSearch.getText()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                tableMahasiswa.setRowSorter(rowSorter);
                rowSorter.setRowFilter(RowFilter.regexFilter(txtSearch.getText()));
            }
        });
    }//GEN-LAST:event_buttonSearchActionPerformed

    private void buttonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertActionPerformed
        try {
            //membuat objek mahasiswa dari package Api 
            Mahasiswa mahasiswa = new Mahasiswa ();
            
            //menyimpan record data dari client ke tiap entitas
            mahasiswa.setNim(txtNim.getText());
            mahasiswa.setNama(txtNama.getText());
            mahasiswa.setProgdi((String) comboProgdi.getSelectedItem());
            mahasiswa.setFakultas((String) comboFakultas.getSelectedItem()) ;
            mahasiswa.setPhone(txtPhone.getText());
            
            //mengirim permintaan kpd server utk prosedur INSERT
            Mahasiswa mahasiswa1 = service.insertMahasiswa(mahasiswa);
            
            //menampilkan feedback yg diberikan oleh server 
            JOptionPane.showMessageDialog(null, mahasiswa1.getLaporan());
            refresh(); 
            
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_buttonInsertActionPerformed

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        try {
            //membuat objek mahasiswa dari package API 
            Mahasiswa mahasiswa = new Mahasiswa();
            
            //menyimpan record data dri client ke tiap2 entitas 
            mahasiswa.setNim(txtNim.getText());
            mahasiswa.setNama(txtNama.getText());
            mahasiswa.setProgdi((String) comboProgdi.getSelectedItem());
            mahasiswa.setFakultas ((String) comboFakultas.getSelectedItem());
            mahasiswa.setPhone(txtPhone.getText());
            
            //mengirim permintaan kepada server utk prosedure UPDATE
            Mahasiswa mahasiswa1 = service.updateMahasiswa(mahasiswa);
            
            //menampilkan feedback dari server 
            JOptionPane.showMessageDialog(null, mahasiswa1.getLaporan());
            refresh();
            
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        try {
            //membuat objek mahasiswa dari package API
            Mahasiswa mahasiswa = new Mahasiswa();
            
            //menyimpan data NIM dari client ke entitas NIM di remote API
            mahasiswa.setNim(txtNim.getText());
            
            //mengirim permintaan kpd server utk prosedur DELETE
            Mahasiswa mahasiswa1 = service.deleteMahasiswa(mahasiswa);
            
            //menampilkan feedback dari server 
            JOptionPane.showMessageDialog(null, mahasiswa1.getLaporan());
            refresh();
            
        } catch (RemoteException e) {
           e.printStackTrace();
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        //memanggil prosedur REFRESH 
        refresh();
        
        //menampilkan feedback 
        JOptionPane.showMessageDialog(null, "Refresh !");
    }//GEN-LAST:event_buttonRefreshActionPerformed

    private void tableMahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMahasiswaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableMahasiswaMouseClicked

    private void comboProgdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProgdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboProgdiActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    
    //prosedur utk merefresh table pada Jframe Client
    public void refresh(){
        txtNama.setText("");
        txtNim.setText("");
        txtPhone.setText("");
        
        try {
            int row = tableMahasiswa.getSelectedRow();
            if (row == -1){
                return;
            }
            List<Mahasiswa> list = service.getAllMahasiswa();
            tableMhs.setData(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonInsert;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JButton buttonSearch;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JComboBox<String> comboFakultas;
    private javax.swing.JComboBox<String> comboProgdi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMahasiswa;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNim;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
