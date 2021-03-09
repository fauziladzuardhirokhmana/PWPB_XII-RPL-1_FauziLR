package siswa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DataSiswa extends javax.swing.JFrame 
{

    Connection koneksi;
    DefaultTableModel dtm;
    
    public DataSiswa() throws SQLException 
    {
        initComponents();
        koneksi = DatabaseConnection.getKoneksi("localhost", "3306", "root", "", "pbo_sekolah");
        showData();
    }
    
    public void showData()
    {
        String[] kolom = {"No","NIS","Nama","Kelas","Jurusan"};
        dtm = new DefaultTableModel(null,kolom);
        
        try
        {
            Statement stmt = koneksi.createStatement();
            String query = "SELECT*FROM siswa";
            ResultSet rs = stmt.executeQuery(query);
            int no = 1;
            
            while(rs.next())
            {
                String nis = rs.getString("nis");
                String nama = rs.getString("nama");
                String kelas = rs.getString("kelas");
                String jurusan = rs.getString("jurusan");
                
                dtm.addRow(new String[]{no+"",nis,nama,kelas,jurusan});
                no++;
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        
        TBL_Siswa.setModel(dtm);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_Siswa = new javax.swing.JTable();
        LBL_Title = new javax.swing.JLabel();
        BTN_Refresh = new javax.swing.JButton();
        BTN_Tambah = new javax.swing.JButton();
        BTN_Edit = new javax.swing.JButton();
        BTN_Hapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        TBL_Siswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "NIS", "Nama", "Kelas", "Jurusan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_Siswa.setPreferredSize(new java.awt.Dimension(300, 162));
        TBL_Siswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBL_SiswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBL_Siswa);
        if (TBL_Siswa.getColumnModel().getColumnCount() > 0) {
            TBL_Siswa.getColumnModel().getColumn(0).setResizable(false);
            TBL_Siswa.getColumnModel().getColumn(1).setResizable(false);
            TBL_Siswa.getColumnModel().getColumn(2).setResizable(false);
            TBL_Siswa.getColumnModel().getColumn(3).setResizable(false);
            TBL_Siswa.getColumnModel().getColumn(4).setResizable(false);
        }

        LBL_Title.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        LBL_Title.setText("Data Siswa");

        BTN_Refresh.setText("Refresh");
        BTN_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_RefreshActionPerformed(evt);
            }
        });

        BTN_Tambah.setText("Tambah");
        BTN_Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_TambahActionPerformed(evt);
            }
        });

        BTN_Edit.setText("Edit");
        BTN_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EditActionPerformed(evt);
            }
        });

        BTN_Hapus.setText("Hapus");
        BTN_Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_HapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BTN_Refresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTN_Tambah)
                        .addGap(18, 18, 18)
                        .addComponent(BTN_Edit)
                        .addGap(18, 18, 18)
                        .addComponent(BTN_Hapus))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(LBL_Title)))
                        .addGap(0, 35, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LBL_Title)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_Refresh)
                    .addComponent(BTN_Tambah)
                    .addComponent(BTN_Edit)
                    .addComponent(BTN_Hapus))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EditActionPerformed
        String nis = TBL_Siswa.getValueAt(baris, 1).toString();
        try 
        {
            ManageData md = new ManageData(this,true,"edit",nis);
            md.setVisible(true);
        } 
        catch (SQLException ex) { Logger.getLogger(DataSiswa.class.getName()).log(Level.SEVERE, null, ex); }
    }//GEN-LAST:event_BTN_EditActionPerformed

    private void BTN_TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_TambahActionPerformed
        try 
        {
            ManageData md = new ManageData(this,true,"tambah","");
            md.setVisible(true);
        } 
        catch (SQLException ex) { Logger.getLogger(DataSiswa.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_BTN_TambahActionPerformed

    int baris;
    private void TBL_SiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBL_SiswaMouseClicked
        baris = TBL_Siswa.getSelectedRow();
    }//GEN-LAST:event_TBL_SiswaMouseClicked

    private void BTN_HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_HapusActionPerformed
        String nis = TBL_Siswa.getValueAt(baris, 1).toString();
        
        try
        {
            Statement stmt = koneksi.createStatement();
            String query = "DELETE FROM siswa WHERE nis='"+nis+"'";
            int berhasil = stmt.executeUpdate(query);
            if(berhasil == 1)
            {
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                dtm.getDataVector().removeAllElements();
                showData();
            }
            else    
            {JOptionPane.showMessageDialog(null, "Data Gagal Dihapus(DELETE)");}
            System.out.println(query);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_BTN_HapusActionPerformed

    private void BTN_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_RefreshActionPerformed
        showData();
        JOptionPane.showMessageDialog(null, "Berhasil Memperbarui Data");
        System.out.println("Berhasil Memperbarui Data");
    }//GEN-LAST:event_BTN_RefreshActionPerformed

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                try { new DataSiswa().setVisible(true); } 
                catch (SQLException ex) { Logger.getLogger(DataSiswa.class.getName()).log(Level.SEVERE, null, ex); }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Edit;
    private javax.swing.JButton BTN_Hapus;
    private javax.swing.JButton BTN_Refresh;
    private javax.swing.JButton BTN_Tambah;
    private javax.swing.JLabel LBL_Title;
    private javax.swing.JTable TBL_Siswa;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}