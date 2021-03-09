package siswa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ManageData extends javax.swing.JDialog {

    Connection koneksi;
    String action;
    
    public ManageData(java.awt.Frame parent, boolean modal, String act, String nis) throws SQLException {
        super(parent, modal);
        initComponents();
        koneksi = DatabaseConnection.getKoneksi("localhost", "3306", "root", "", "pbo_sekolah");
        
        action = act;
        
        if(action == "edit")
        {
            TBX_NIS.setEnabled(false);
            showData(nis);
        }
    }
    
    public void editData()
    {
        String nis = TBX_NIS.getText();
        String nama = TBX_Nama.getText();
        String kelas = CBX_Kelas.getSelectedItem().toString();
        String jurusan = CBX_Jurusan.getSelectedItem().toString();
        
        try
        {
            Statement stmt = koneksi.createStatement();
            String query = "UPDATE siswa SET nama='"+nama+"',kelas='"+kelas+"',jurusan='"+jurusan+"' WHERE nis='"+nis+"'";
            System.out.println(query);
            int berhasil = stmt.executeUpdate(query);
            if(berhasil == 1)   {JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");}
            else                {JOptionPane.showMessageDialog(null, "Data Gagal Diubah");}
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan Pada Query(UPDATE)");
        }
    }
    
    public void showData(String nis)
    {
        try
        {
            Statement stmt = koneksi.createStatement();
            String query = "SELECT*FROM siswa WHERE nis='"+nis+"'";
            ResultSet rs = stmt.executeQuery(query);
            rs.first();
            
            TBX_NIS.setText(rs.getString("nis"));
            TBX_Nama.setText(rs.getString("nama"));
            CBX_Kelas.setSelectedItem(rs.getString("kelas"));
            CBX_Jurusan.setSelectedItem(rs.getString("jurusan"));
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Pada Query");
        }
    }
    
    public void simpanData() throws SQLException
    {
        String nis = TBX_NIS.getText();
        String nama = TBX_Nama.getText();
        String kelas = CBX_Kelas.getSelectedItem().toString();
        String jurusan = CBX_Jurusan.getSelectedItem().toString();
        
        try
        {
            Statement stmt = koneksi.createStatement();
            String query = "INSERT INTO siswa(nis,nama,kelas,jurusan) VALUES('"+nis+"','"+nama+"','"+kelas+"','"+jurusan+"')";
            int berhasil = stmt.executeUpdate(query);
            if(berhasil == 1)   {JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");}
            else                {JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan");}
            System.out.println(query);
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan Pada Database(INSERT)");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LBL_Title = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        LBL_NIS = new javax.swing.JLabel();
        LBL_Nama = new javax.swing.JLabel();
        LBL_Kelas = new javax.swing.JLabel();
        LBL_Jurusan = new javax.swing.JLabel();
        TBX_NIS = new javax.swing.JTextField();
        TBX_Nama = new javax.swing.JTextField();
        CBX_Kelas = new javax.swing.JComboBox<>();
        CBX_Jurusan = new javax.swing.JComboBox<>();
        BTN_Simpan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        LBL_Title.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        LBL_Title.setText("Tambah Data");

        LBL_NIS.setText("NIS");

        LBL_Nama.setText("Nama");

        LBL_Kelas.setText("Kelas");

        LBL_Jurusan.setText("Jurusan");

        CBX_Kelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "XI RPL 1", "XI RPL 2", "XI RPL 3", "XI TKJ 1", "XI TKJ 2", "XI MM" }));

        CBX_Jurusan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RPL", "TKJ", "MM" }));

        BTN_Simpan.setText("Simpan");
        BTN_Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_SimpanActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LBL_Nama)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(LBL_Title))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LBL_NIS)
                                    .addComponent(LBL_Kelas))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TBX_Nama)
                                    .addComponent(CBX_Kelas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CBX_Jurusan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TBX_NIS)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LBL_Jurusan))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(BTN_Simpan)))
                        .addGap(0, 34, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LBL_Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBL_NIS)
                    .addComponent(TBX_NIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBL_Nama)
                    .addComponent(TBX_Nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBX_Kelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBL_Kelas))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBL_Jurusan)
                    .addComponent(CBX_Jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BTN_Simpan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SimpanActionPerformed
        try 
        {
            if(action == "edit")  {editData();}
            else { simpanData(); }
        } 
        catch (SQLException ex) { Logger.getLogger(ManageData.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_BTN_SimpanActionPerformed

    public static void main(String args[]) {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Simpan;
    private javax.swing.JComboBox<String> CBX_Jurusan;
    private javax.swing.JComboBox<String> CBX_Kelas;
    private javax.swing.JLabel LBL_Jurusan;
    private javax.swing.JLabel LBL_Kelas;
    private javax.swing.JLabel LBL_NIS;
    private javax.swing.JLabel LBL_Nama;
    private javax.swing.JLabel LBL_Title;
    private javax.swing.JTextField TBX_NIS;
    private javax.swing.JTextField TBX_Nama;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
