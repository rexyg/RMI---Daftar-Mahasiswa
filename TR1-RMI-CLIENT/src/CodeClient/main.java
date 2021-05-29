package CodeClient;

import ViewClient.FormClient;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.SwingUtilities;
import service.MhsInterface;

public class main {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        System.out.println("----------------------------------------");
        System.out.println("----------- DATABASE MAHASISWA ---------");
        System.out.println("----------------------------------------");
        
        try {
            //port yang digunakan 
            int port = 213; 
            
            //menghubungkan interface client dgn server yang telah dibuat
            Registry client = LocateRegistry.getRegistry("localhost", port);
            
            //membuat objek 'remote objek' MhsInterface yg ada diprogram Api
            MhsInterface service = (MhsInterface) client.lookup("service");
            
            //menjalankan Jframe client yg telah dibuat
            SwingUtilities.invokeLater(new Runnable() {
                
                @Override
                public void run() {
                    FormClient formMahasiswa = new FormClient(service);
                    formMahasiswa.setVisible(true);
                }
            });
            
            //feedback ketika client berhasil berjalan
            System.out.println("[clinet] : berhasil dijalankan ");
        }catch (RemoteException e) {
            
            //feedback ketika client gagal di jlnkan 
            System.out.println("[client] : gagal dijalankan !" + e);
        }
    }
}
