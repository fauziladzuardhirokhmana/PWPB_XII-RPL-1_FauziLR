package siswa;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseConnection 
{
    public static Connection getKoneksi(String host, String port, String username, String password, String db) throws SQLException
    {
        String konString = "jdbc:mysql://" + host + ":" + port + "/" + db;
        Connection koneksi = null;

        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(konString, username, password);
            System.out.println("Koneksi Berhasil");
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Koneksi Database Error");
            koneksi = null;
        }
        return koneksi;
    }
}
