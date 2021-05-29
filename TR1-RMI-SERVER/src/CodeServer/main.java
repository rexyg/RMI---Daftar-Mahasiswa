package CodeServer;

import Service.MhsServiceServer;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class main {
    public static void main(String[] args) throws RemoteException {
        
        System.out.println("----------------------------------------");
        System.out.println("----------- DATABASE MAHASISWA ---------");
        System.out.println("----------------------------------------");
        
        try {
            //port yang digunakan
            int port = 213; 
            
            //Register RMI utk port 213
            Registry server = LocateRegistry.createRegistry(port);
            
            //membuat objek MhsServiceServer
            MhsServiceServer userService = new MhsServiceServer();
            
            //membuat objek userServuce dg nama "service" diport RMI
            server.rebind("service", userService);
            
            //feedback ketika Server RMI berhasil dijalankan
            System.out.println("[Server] : server sedang berjalan di port : "
            +port+".....\n");
        }catch (RemoteException e){
            
            //feedback ketika server RMI gagal dijalankan
            System.out.println("[server] server gagal dijalankan"+e);
        }
    }
  
}
