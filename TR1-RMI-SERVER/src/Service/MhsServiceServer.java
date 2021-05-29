package Service;

import entity.Mahasiswa;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.util.List;
import service.MhsInterface;
import Utilities.DatabaseMhs;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//berisi implementasi method dari API utk memproses permintaan client
public class MhsServiceServer extends UnicastRemoteObject implements MhsInterface {
   
    public MhsServiceServer() throws RemoteException{    
    }

    @Override
    public Mahasiswa insertMahasiswa(Mahasiswa mahasiswa) throws RemoteException {
        System.out.println("[Server] : client memanggil fungsi insert !");
        
        //variabel statement yg akan diisi perintah query 
        PreparedStatement statement = null;
        
        try{
            //query insert u/ ke db 
            statement = DatabaseMhs.getConnection().prepareStatement
        ("INSERT INTO `mhs1` VALUES (?,?,?,?,?) ");
            
           //mengisi symbol '?' dg data yg diambil dr API 
           statement.setString(1, mahasiswa.getNim());
           statement.setString(2, mahasiswa.getNama());
           statement.setString(3, mahasiswa.getProgdi());
           statement.setString(4, mahasiswa.getFakultas());
           statement.setString(5, mahasiswa.getPhone());
           
           //utk menjalankan perintah diatas 
           statement.executeUpdate();
           
           //menampilkan hasil query diatas
            System.out.println("\t"+statement+"\n\tPermintaan Berhasil !");//feedback utk server
            mahasiswa.setLaporan("Data sudah ditambahkan "); //utk client 
            
            return mahasiswa; 
            
        } catch (SQLException e) {
            
            //tampilan ketika gagal dijalankan
            System.out.println("\t Gagal dijalankan !\n");
            mahasiswa.setLaporan("Data gagal ditambahkan");
            e.printStackTrace();
            
            return mahasiswa;
            
        } finally {
            if (statement !=null) {
                try {
                    statement.close();
                }catch (Exception e){
                    
                }
            }
        }

    }
    
    //method UPDATE 
    @Override
    public Mahasiswa updateMahasiswa(Mahasiswa mahasiswa) throws RemoteException {
        System.out.println("[Server] : Client menunggu fungsi update !");
        
        //membuat variabel statement yg diisi perintah query 
        PreparedStatement statement = null;
        
        try {
            //query update 
            statement=DatabaseMhs.getConnection().prepareStatement(
                    "UPDATE mhs1 SET nama=?, progdi=?, fakultas=?,"
                            + " phone=? WHERE nim=? ");
            
            //mengisi nilai ?

            statement.setString(1, mahasiswa.getNama());
            statement.setString(2, mahasiswa.getProgdi());
            statement.setString(3, mahasiswa.getFakultas());
            statement.setString(4, mahasiswa.getPhone());
            statement.setString(5, mahasiswa.getNim());
            
            //utk menjalankan perintah di atas 
            statement.executeUpdate();
            
            //tampilan kalo berhasil
            System.out.println("\t"+statement+"\n\tPermintaan Berhasil !");//feedback utk server
            mahasiswa.setLaporan("Data sudah diperbarui "); //utk client 
            
            return mahasiswa;
            
        } catch (SQLException e){
            
            //tampilan ketika gagal dijalankan
            System.out.println("\t Gagal dijalankan !\n");
            mahasiswa.setLaporan("Data gagal diperbarui");
            e.printStackTrace();
            
            return mahasiswa;
        
        }finally{
            if (statement !=null) {
                try {
                    statement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
             }
         }
    }
    
    //method DELETE 
    @Override
    public Mahasiswa deleteMahasiswa(Mahasiswa mahasiswa) throws RemoteException {
        System.out.println("[Server] : Client menunggu fungsi update !");
        
        //membuat variabel statement yg diisi perintah query 
        PreparedStatement statement = null;
        
        try {
            //query update 
            statement=DatabaseMhs.getConnection().prepareStatement(
                    "DELETE FROM mhs1 WHERE nim=?");
            
            //mengisi nilai ?
            statement.setString(1, mahasiswa.getNim());
            
            //utk menjalankan perintah di atas 
            statement.executeUpdate();
            
            //tampilan kalo berhasil
            System.out.println("\t"+statement+"\n\tPermintaan Berhasil !");//feedback utk server
            mahasiswa.setLaporan("Data sudah dihapus "); //utk client 
            
            return mahasiswa;
            
        } catch (SQLException e){
            
            //tampilan ketika gagal dijalankan
            System.out.println("\t Gagal dijalankan !\n");
            mahasiswa.setLaporan("Data gagal dihapus");
            e.printStackTrace();
            
            return mahasiswa;
        
        }finally{
            if (statement !=null) {
                try {
                    statement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
             }
         }
    }

    //mengambil data yg ada di database 
    @Override
    public Mahasiswa getMahasiswa(String nim) throws RemoteException {
        System.out.println("[Server] : Client memanggil data di database !");
        
        //membuat variabel statement 
        PreparedStatement statement = null;
        try {
            //statement dg perintah query u/ mendapatkan data berdasarkan nim dari 
            //interface RMI 
            statement = DatabaseMhs.getConnection().prepareStatement(
                    "SELECT * FROM mhs1 WHERE nim = ?");
            
            //menjalankan perintah query 
            ResultSet resultSet = statement.executeQuery();
            
            //membuat objek 'mahasiswa'
            Mahasiswa mahasiswa = null;
            
            //menyimpan data yg didpt berdasarkan NIM di variabel mahasiswa 
            if (resultSet.next()){
                mahasiswa = new Mahasiswa();
                
                //record variabel mahasiswa 
                mahasiswa.setNim(nim);
                mahasiswa.setNama(resultSet.getString("nama"));
                mahasiswa.setProgdi(resultSet.getString("progdi"));
                mahasiswa.setFakultas(resultSet.getString("fakultas"));
                mahasiswa.setPhone(resultSet.getString("phone"));
            }
            
            //feedback ketika query berhasil dijalankan 
            System.out.println("\t Data Berhasil ditampilkan !");
            return mahasiswa; 
            
        } catch (SQLException e) {
            //feedback ketika query gagal dijalankan 
            e.printStackTrace();//keterangan gagal
            
            return null;
            
        }finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } 
            }
        }
    }

    //mengambil seluruh data yang ada di DB
    @Override
    public List<Mahasiswa> getAllMahasiswa() throws RemoteException {
        System.out.println("[server] : client memanggil data pada database !");
        
        //membuat variabel statemnt 
        Statement statement = null; 
        
        try {
            //membuat koneksi dengan database 
            statement = DatabaseMhs.getConnection().createStatement();
            
            //menjalankan query utk mendptkan seluruh data yg ada pada tabel mhs1
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mhs1 ");
            
            //membuat variabel tipe data Array 
            List<Mahasiswa> list = new ArrayList <>();
            
            //infinity looping sampai seluruh data tersimpan
            while (resultSet.next()) {
                Mahasiswa mahasiswa = new Mahasiswa ();
                
                //menyimpan setiap data pada variabel mahasiswa 
                mahasiswa.setNim(resultSet.getString("nim"));
                mahasiswa.setNama(resultSet.getString("nama"));
                mahasiswa.setProgdi(resultSet.getString("progdi"));
                mahasiswa.setFakultas(resultSet.getString("fakultas"));
                mahasiswa.setPhone(resultSet.getString("phone"));
                list.add(mahasiswa);
            }
            //feedback ketika query berhasil dijalankan 
            System.out.println("\t Data berhasil ditampilkan\n");
            
            return list; 
            
        } catch (SQLException e) {
            //feedback ketika query gagal dijalankan 
            e.printStackTrace();
            return null;
            
        }finally {
            if (statement !=null) {
                try {
                    statement.close();
                    
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        
        //
    }
    
    
}
